package gyqw.xiaobaitu.dgraph.service;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import gyqw.xiaobaitu.dgraph.model.NodeModel;
import gyqw.xiaobaitu.dgraph.model.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fred
 * 2018-11-21 5:05 PM
 */
@Service
public class BaseService {
    private Logger logger = LoggerFactory.getLogger(BaseService.class);

    private Integer nodeNum = 0;

    public void getAuth() {
        try {
            String url = "https://www.geexfinance.com/geex-security-web/home/getAuthorityList";
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(url), new EmptyContent());
            String rawResponse = request.execute().parseAsString();

            Gson resultStr = new Gson();
            ResultModel resultModel = resultStr.fromJson(rawResponse, ResultModel.class);

            walkNode(resultModel.getResult());
            logger.info("总节点数" + this.nodeNum);
        } catch (Exception e) {
            logger.error("getAuth error", e);
        }
    }

    private void walkNode(List<NodeModel> nodeModelList) {
        for (NodeModel nodeModel : nodeModelList) {
            if (nodeModel.getChildren() != null) {
                walkNode(nodeModel.getChildren());
            } else {
                this.nodeNum++;
            }

            nodeModel.setChildren(null);
            logger.info(nodeModel.toString());
        }
    }
}
