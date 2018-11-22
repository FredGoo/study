package gyqw.xiaobaitu.graph.dao;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import gyqw.xiaobaitu.graph.model.GraphNodeModel;
import io.dgraph.DgraphClient;
import io.dgraph.DgraphGrpc;
import io.dgraph.DgraphProto;
import io.dgraph.Transaction;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fred
 * 2018-11-22 5:29 PM
 */
@Repository
public class DgraphDao implements GraphDao {
    private Logger logger = LoggerFactory.getLogger(DgraphDao.class);

    private DgraphClient dgraphClient;

    public DgraphDao() {
        this.dgraphClient = createDgraphClient();
    }

    private static DgraphClient createDgraphClient() {
        String hostname = "127.0.0.1";
        int port = 9080;

        ManagedChannel channel = ManagedChannelBuilder.forAddress(hostname, port).usePlaintext(true).build();
        DgraphGrpc.DgraphStub stub = DgraphGrpc.newStub(channel);

        return new DgraphClient(stub);
    }

    @Override
    public void init() {
        // Initialize
        this.dgraphClient.alter(DgraphProto.Operation.newBuilder().setDropAll(true).build());

        // Set schema
        String schema = "code: string @index(exact) .";
        DgraphProto.Operation op = DgraphProto.Operation.newBuilder().setSchema(schema).build();
        this.dgraphClient.alter(op);
    }

    @Override
    public void mutate(GraphNodeModel graphNodeModel) {
        // For JSON encode/decode
        Gson gson = new Gson();

        Transaction txn = this.dgraphClient.newTransaction();
        try {
            // Serialize it
            String json = gson.toJson(graphNodeModel);

            // Run mutation
            DgraphProto.Mutation mu = DgraphProto.Mutation.newBuilder().setSetJson(ByteString.copyFromUtf8(json)).build();
            txn.mutate(mu);
            txn.commit();

        } finally {
            txn.discard();
        }


    }

}
