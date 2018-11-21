package gyqw.xiaobaitu.dgraph.service;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import gyqw.xiaobaitu.dgraph.model.NodeModel;
import gyqw.xiaobaitu.dgraph.model.ResultModel;
import io.dgraph.DgraphClient;
import io.dgraph.DgraphGrpc;
import io.dgraph.DgraphProto;
import io.dgraph.Transaction;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

    private static DgraphClient createDgraphClient() {
        String hostname = "127.0.0.1";
        int port = 9080;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(hostname, port).usePlaintext(true).build();
        DgraphGrpc.DgraphStub stub = DgraphGrpc.newStub(channel);

        return new DgraphClient(stub);
    }

    public void getAuth() {
        try {
            String url = "https://www.geexfinance.com/geex-security-web/home/getAuthorityList";
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(url), new EmptyContent());
            String rawResponse = request.execute().parseAsString();

            Gson resultStr = new Gson();
            ResultModel resultModel = resultStr.fromJson(rawResponse, ResultModel.class);

            walkNode(resultModel.getResult());
            logger.info("总权限数" + this.nodeNum);
        } catch (Exception e) {
            logger.error("getAuth error", e);
        }
    }

    private void walkNode(List<NodeModel> nodeModelList) {
        for (NodeModel nodeModel : nodeModelList) {
            if (nodeModel.getChildren() != null) {
                walkNode(nodeModel.getChildren());

                nodeModel.setChildren(null);
            } else {
                this.nodeNum++;
            }

            mutate(nodeModel);
            logger.info(nodeModel.toString());
        }
    }

    public void init() {
        DgraphClient dgraphClient = createDgraphClient();

        // Initialize
        dgraphClient.alter(DgraphProto.Operation.newBuilder().setDropAll(true).build());

        // Set schema
        String schema = "name: string @index(exact) .";
        DgraphProto.Operation op = DgraphProto.Operation.newBuilder().setSchema(schema).build();
        dgraphClient.alter(op);

    }

    private void mutate(NodeModel nodeModel) {
        DgraphClient dgraphClient = createDgraphClient();

        // For JSON encode/decode
        Gson gson = new Gson();

        Transaction txn = dgraphClient.newTransaction();
        try {
            // Serialize it
            String json = gson.toJson(nodeModel);

            // Run mutation
            DgraphProto.Mutation mu = DgraphProto.Mutation.newBuilder().setSetJson(ByteString.copyFromUtf8(json)).build();
            txn.mutate(mu);
            txn.commit();

        } finally {
            txn.discard();
        }

    }
}
