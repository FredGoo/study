package gyqw.playground.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author fred
 */
@EnableWebMvc
@ComponentScan
public class PlaygroundRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaygroundRabbitmqApplication.class, args);
    }
}
