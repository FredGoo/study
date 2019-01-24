package gyqw.playground.rabbitmq.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fred
 * 2019-01-24 2:23 PM
 */
public class Receiver {
    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    public void onMessage(String msg) {
        logger.info("Receiver1  : " + msg);
    }
}
