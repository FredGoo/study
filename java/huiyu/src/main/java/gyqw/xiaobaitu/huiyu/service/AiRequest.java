package gyqw.xiaobaitu.huiyu.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import gyqw.xiaobaitu.huiyu.dto.BaseResult;
import gyqw.xiaobaitu.huiyu.dto.BatchDetail;
import gyqw.xiaobaitu.huiyu.dto.BatchPlan;
import gyqw.xiaobaitu.huiyu.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务操作类 by kevin.yao
 */
@Service
public class AiRequest {
    private Logger logger = LoggerFactory.getLogger(AiRequest.class);

    @Value("${appcode}")
    private String appcode;
    // md5秘钥
    @Value("${appkey}")
    private String appkey;
    // 账号
    @Value("${accountid}")
    private String accountid;

    // api 请求地址配置
    @Value("${apiUrl}")
    private String apiUrl;
    @Value("${batchUrl}")
    private String batchUrl;
    @Value("${queryListUrl}")
    private String queryListUrl;
    @Value("${queryDetailUrl}")
    private String queryDetailUrl;

    public AiRequest() {
    }

    public AiRequest(String appcode, String appkey, String accountid) {
        this.appcode = appcode;
        this.appkey = appkey;
        this.accountid = accountid;
    }

    // 导入计划
    public BaseResult batch(List<BatchDetail> details, String wordstemplateid, String robotid, String workstarttime,
                            String workendtime) {
        BatchPlan requestParams = new BatchPlan() {
            {
                setAccountid(Integer.parseInt(accountid));
                // setBatchno(new SimpleDateFormat("yyyyMMddHHmmss").format(new
                // Date()));
                setWordstemplateid(wordstemplateid);
                setRobotid(robotid);
                setWorkstarttime(workstarttime);
                setWorkendtime(workendtime);
                setDetails(details);
            }
        };
        String params = JSON.toJSONString(requestParams);
        return doRequest(apiUrl + batchUrl, params, setHeads(sign(params)));
    }

    // 批次查询
    public BaseResult queryList(String batchno, int pageIndex, int pageSize) {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("batchno", batchno);
        requestParams.put("page", pageIndex);
        requestParams.put("pagesize", pageSize);

        String params = JSON.toJSONString(requestParams);
        return doRequest(apiUrl + queryListUrl, params, setHeads(sign(params)));
    }

    //单个查询
    public BaseResult queryDetail(String batchno, String phone) {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put("batchno", batchno);
        requestParams.put("phone", phone);
        String params = JSON.toJSONString(requestParams);
        return doRequest(apiUrl + queryDetailUrl, params, setHeads(sign(params)));
    }

    // 发送请求
    private BaseResult doRequest(String url, String params, Map<String, String> headParams) {
        String result = HttpUtil.post(url, params, "text/plain; charset=utf-8", headParams);
        if (result != null && result.length() > 0) {
            return JSON.parseObject(result, new TypeReference<BaseResult>() {
            });
        }
        return null;
    }

    // 设置请求头
    private Map<String, String> setHeads(String sign) {
        Map<String, String> headParams = new HashMap<>();
        headParams.put("appcode", appcode);
        headParams.put("sign", sign);
        return headParams;
    }

    //签名算法
    private String sign(String data) {
        String temp = appcode + "|" + data + "|" + appkey;
        return MD5(temp);
    }

    private String MD5(String input) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(input.getBytes());
            byte[] md = mdInst.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                String shaHex = Integer.toHexString(md[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
