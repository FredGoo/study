package gyqw.xiaobaitu.dgraph;

import gyqw.xiaobaitu.dgraph.service.BaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DgraphTest {
    private Logger logger = LoggerFactory.getLogger(DgraphTest.class);

    private BaseService baseService;

    @Autowired
    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    @Test
    public void dgraphTest() {
        this.baseService.getAuth();
    }
}
