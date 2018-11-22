package gyqw.xiaobaitu.graph;

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

    private BaseService baseService;

    @Autowired
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @Test
    public void graphTest() {
        this.baseService.getAuth();
    }
}
