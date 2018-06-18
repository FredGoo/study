package gyqw.xiaobaitu.apollo;

import gyqw.xiaobaitu.ignite.service.InfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiaobaituIgniteApplicationTests {
    private InfoService infoService;

    @Autowired
    public void setInfoService(InfoService infoService) {
        this.infoService = infoService;

    }

    @Test
    public void start() {
        this.infoService.start();
    }
}
