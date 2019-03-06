package huiyu.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import huiyu.dto.BaseResult;
import huiyu.dto.BatchDetail;
import huiyu.dto.BatchPlan;
import huiyu.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 业务操作类 by kevin.yao
 */
public class AiRequest {
    private Logger logger = LoggerFactory.getLogger(AiRequest.class);

    private String appcode;
    // md5秘钥
    private String appkey;
    // 账号
    private String accountid;

    // api 请求地址配置
    private String apiUrl;
    private String batchUrl;
    private String queryListUrl;
    private String queryDetailUrl;

    public AiRequest() {
        try {
            Resource resource = new ClassPathResource("/application.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            this.appcode = props.get("appcode").toString();
            this.appkey = props.get("appkey").toString();
            this.accountid = props.get("accountid").toString();
            this.apiUrl = props.get("apiUrl").toString();
            this.batchUrl = props.get("batchUrl").toString();
            this.queryListUrl = props.get("queryListUrl").toString();
            this.queryDetailUrl = props.get("queryDetailUrl").toString();
        } catch (Exception e) {
            logger.error("AiRequest error", e);
        }
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
