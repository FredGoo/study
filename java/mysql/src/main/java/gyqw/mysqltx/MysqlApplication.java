package gyqw.mysqltx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fred
 * 2019-03-27 3:47 PM
 */
@ImportResource({"classpath:database.xml"})
@SpringBootApplication
public class MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }
}
