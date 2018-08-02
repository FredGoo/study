package gyqw.xiaobaitu.urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author fred
 * @date 2018/02/02
 */
@SpringBootApplication
@ImportResource({"classpath:urule-console-context.xml"})
public class XiaobaituUruleApplication {
    public static void main(String[] args) {
        SpringApplication.run(XiaobaituUruleApplication.class, args);
    }
}
