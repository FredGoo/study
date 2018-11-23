package gyqw.xiaobaitu.graph.service;

import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import gyqw.xiaobaitu.graph.dao.GraphDao;
import gyqw.xiaobaitu.graph.dao.GraphDaoEnum;
import gyqw.xiaobaitu.graph.dao.GraphDaoFactory;
import gyqw.xiaobaitu.graph.model.GraphNodeModel;
import gyqw.xiaobaitu.graph.model.NodeModel;
import gyqw.xiaobaitu.graph.model.ResultModel;
import io.dgraph.DgraphProto;
import io.dgraph.Transaction;
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
    private GraphDao graphDao;

    public BaseService(GraphDaoFactory graphDaoFactory) {
        this.graphDao = graphDaoFactory.getGraphDao(GraphDaoEnum.NEO4J);
    }

    public void getAuth() {
        try {
            this.graphDao.init();

            String url = "https://www.geexfinance.com/geex-security-web/home/getAuthorityList";
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(url), new EmptyContent());
            String rawResponse = request.execute().parseAsString();

            Gson resultStr = new Gson();
            ResultModel resultModel = resultStr.fromJson(rawResponse, ResultModel.class);

            walkNode(resultModel.getResult(), null, null);
            logger.info("节点数" + this.nodeNum);
        } catch (Exception e) {
            logger.error("getAuth error", e);
        }
    }

    private void walkNode(List<NodeModel> nodeModelList, String parentCode, String parentText) {
        for (NodeModel nodeModel : nodeModelList) {
            try {
                String[] textArr = nodeModel.getText().split("\\(");
                GraphNodeModel graphNodeModel = new GraphNodeModel();
                graphNodeModel.setCode(textArr[1].substring(0, textArr[1].length() - 1));
                graphNodeModel.setText(textArr[0]);
                graphNodeModel.setParentCode(parentCode);
                graphNodeModel.setParentText(parentText);
                graphNodeModel.setState(nodeModel.getState());
                this.graphDao.mutate(graphNodeModel);

                if (nodeModel.getChildren() != null) {
                    walkNode(nodeModel.getChildren(), graphNodeModel.getCode(), graphNodeModel.getText());
                }

                this.nodeNum++;
            } catch (Exception e) {
                logger.error("walkNode error", e);
            }
        }
    }
}
