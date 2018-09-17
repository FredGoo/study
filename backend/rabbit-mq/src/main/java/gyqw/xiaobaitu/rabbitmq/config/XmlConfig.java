package gyqw.xiaobaitu.rabbitmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author fred
 * 2018/06/13 13:57
 */
@Configuration
@ImportResource({"classpath:spring-servlet.xml", "classpath:spring-amqp.xml"})
public class XmlConfig {
}
