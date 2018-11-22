package gyqw.xiaobaitu.graph.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fred
 * 2018-11-22 5:33 PM
 */
@Component
public class GraphDaoFactory {
    private Logger logger = LoggerFactory.getLogger(GraphDaoFactory.class);

    private DgraphDao dgraphDao;
    private Neo4jDao neo4jDao;

    @Autowired
    public void setDgraphDao(DgraphDao dgraphDao) {
        this.dgraphDao = dgraphDao;
    }

    @Autowired
    public void setNeo4jDao(Neo4jDao neo4jDao) {
        this.neo4jDao = neo4jDao;
    }

    public GraphDao getGraphDao(GraphDaoEnum graphDaoEnum) {
        switch (graphDaoEnum) {
            case DGRAPH:
                return this.dgraphDao;
            case NEO4J:
            default:
                return this.neo4jDao;
        }
    }
}
