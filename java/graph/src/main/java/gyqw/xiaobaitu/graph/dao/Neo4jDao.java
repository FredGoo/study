package gyqw.xiaobaitu.graph.dao;

import gyqw.xiaobaitu.graph.model.GraphNodeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author fred
 * 2018-11-22 5:29 PM
 */
@Repository
public class Neo4jDao implements GraphDao {
    private Logger logger = LoggerFactory.getLogger(Neo4jDao.class);

    @Override
    public void init() {
        logger.info("init");
    }

    @Override
    public void mutate(GraphNodeModel graphNodeModel) {
        logger.info("mutate: " + graphNodeModel.toString());
    }
}
