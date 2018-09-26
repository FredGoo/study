package gyqw.xiaobaitu.rabbitmq.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author fred
 * 2018-09-17 3:35 PM
 */
@Component
public class TestListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            String jsonStr = new String(message.getBody(), StandardCharsets.UTF_8);
            logger.info("get " + jsonStr);
        } catch (Exception e) {
            logger.error("TestListener onMessage error", e);
        }

    }
}
