package gyqw.xiaobaitu.graph.dao;

import gyqw.xiaobaitu.graph.domain.neo4j.Auth;
import gyqw.xiaobaitu.graph.model.GraphNodeModel;
import gyqw.xiaobaitu.graph.repositories.neo4j.AuthRepository;
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

    private AuthRepository authRepository;

    public Neo4jDao(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void init() {
        logger.info("init");
        this.authRepository.deleteAll();
    }

    @Override
    public void mutate(GraphNodeModel graphNodeModel) {
        logger.info("mutate: " + graphNodeModel.toString());

        Auth parentAuth = null;
        if (graphNodeModel.getParentCode() != null) {
            parentAuth = new Auth(graphNodeModel.getParentCode(), graphNodeModel.getParentText(), null);
        }

        Auth auth = new Auth(graphNodeModel.getCode(), graphNodeModel.getText(), parentAuth);
        this.authRepository.save(auth);
    }
}
