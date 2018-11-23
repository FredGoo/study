package gyqw.xiaobaitu.graph;

import gyqw.xiaobaitu.graph.domain.neo4j.Auth;
import gyqw.xiaobaitu.graph.repositories.neo4j.AuthRepository;
import gyqw.xiaobaitu.graph.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphTest {
    private Logger logger = LoggerFactory.getLogger(GraphTest.class);

    private AuthRepository authRepository;
    private BaseService baseService;

    @Autowired
    public void setAuthRepository(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Autowired
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @Test
    public void setUp() {
        // 清空数据库
        this.authRepository.deleteAll();

        // 插入父权限
        Auth parent = new Auth("parent", "父权限", null);
        this.authRepository.save(parent);

        // 插入子权限
        Auth child = new Auth("child", "子权限", parent);
        this.authRepository.save(child);
    }

    @Test
    public void graphTest() {
        this.baseService.getAuth();
    }
}
