package gyqw.playground.rabbitmq.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

/**
 * @author fred
 * 2019-01-24 11:41 PM
 */
public class Sender implements Runnable {
    private Logger logger = LoggerFactory.getLogger(Sender.class);

    private RabbitAdmin rabbitAdmin;
    private String exchange;
    private String queueName;
    private String msg;

    public Sender(RabbitAdmin rabbitAdmin, String exchange, String queueName, String msg) {
        this.rabbitAdmin = rabbitAdmin;
        this.exchange = exchange;
        this.queueName = queueName;
        this.msg = msg;
    }

    @Override
    public void run() {
        this.rabbitAdmin.getRabbitTemplate().convertAndSend(this.exchange, this.queueName, this.msg);
    }
}
