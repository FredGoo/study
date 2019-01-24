package gyqw.playground.rabbitmq.service;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fred
 * 2019-01-24 2:40 PM
 */
@Service
public class RabbitmqService {
    private Logger logger = LoggerFactory.getLogger(RabbitmqService.class);

    private String exchangeName = "geex-exchange";
    private boolean send;
    private Map<String, Map<String, Object>> rabbitMap = new HashMap<>();
    private String host = "192.168.101.41";
    private String username = "guest";
    private String password = "guest";
    private String virutalHost = "/";

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    /**
     * 开始测试
     */
    public void initQueues() {
        for (int i = 0; i < 100; i++) {
            // 队列名称
            String queueName = "queue" + i;

            // 建立连接
            ConnectionFactory connectionFactory = connect();

            // 建立rabbit admin
            RabbitAdmin rabbitAdmin = createRabbitAdmin(connectionFactory);

            // 绑定队列
            declareQueue(rabbitAdmin, queueName);

            Map<String, Object> map = new HashMap<>();
            map.put("admin", rabbitAdmin);
            map.put("connect", connectionFactory);
            this.rabbitMap.put(queueName, map);
        }
    }

    /**
     * 绑定队列监听器
     */
    public void bindListeners() {
        for (String key : this.rabbitMap.keySet()) {
            messageContainer(key);
        }
    }

    public void startSendMsg() {
        setSend(true);

        int i = 0;
        while (isSend()) {
            for (String queueName : this.rabbitMap.keySet()) {
                String msg = "round: " + i + ", queue: " + queueName;
                RabbitAdmin rabbitAdmin = (RabbitAdmin) this.rabbitMap.get(queueName).get("admin");
                sendMsg(rabbitAdmin, queueName, msg);
            }

            i++;
        }
    }

    /**
     * 建立rabbitmq连接
     */
    private ConnectionFactory connect() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(this.host);
        connectionFactory.setUsername(this.username);
        connectionFactory.setPassword(this.password);
        connectionFactory.setVirtualHost(this.virutalHost);
        // 消息确认
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }

    /**
     * 创建rabbit admin
     */
    private RabbitAdmin createRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * 绑定队列
     */
    private void declareQueue(RabbitAdmin rabbitAdmin, String queueName) {
        if (rabbitAdmin.getQueueProperties(queueName) == null) {
            /*
             queue 队列声明
             durable=true,交换机持久化,rabbitmq服务重启交换机依然存在,保证不丢失; durable=false,相反
             auto-delete=true:无消费者时，队列自动删除; auto-delete=false：无消费者时，队列不会自动删除
             排他性，exclusive=true:首次申明的connection连接下可见; exclusive=false：所有connection连接下
             */
            Queue queue = new Queue(queueName);
            rabbitAdmin.declareQueue(queue);
            TopicExchange directExchange = new TopicExchange(this.exchangeName);
            // 声明exchange
            rabbitAdmin.declareExchange(directExchange);
            // 将queue绑定到exchange
            Binding binding = BindingBuilder.bind(queue).to(directExchange).with(queueName);
            // 声明绑定关系
            rabbitAdmin.declareBinding(binding);
        } else {
            rabbitAdmin.getRabbitTemplate().setQueue(queueName);
            rabbitAdmin.getRabbitTemplate().setExchange(this.exchangeName);
            rabbitAdmin.getRabbitTemplate().setRoutingKey(queueName);
        }
    }

    /**
     * 发送信息
     */
    private void sendMsg(RabbitAdmin rabbitAdmin, String queueName, String msg) {
        rabbitAdmin.getRabbitTemplate().convertAndSend(this.exchangeName, queueName, msg);
    }

    /**
     * 监听队列
     */
    private void messageContainer(String queueName) {
        try {
            com.rabbitmq.client.ConnectionFactory factory = new com.rabbitmq.client.ConnectionFactory();
            factory.setHost(this.host);
            factory.setUsername(this.username);
            factory.setPassword(this.password);
            factory.setVirtualHost(this.virutalHost);
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            // 申明接收消息的队列，与发送消息队列"hello"对应
            channel.queueDeclare(queueName, true, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                // 重写DefaultConsumer中handleDelivery方法，在方法中获取消息
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                    String message = new String(body, StandardCharsets.UTF_8);
                    logger.info("[x] Received: " + message);
                }
            };
            channel.basicConsume(queueName, true, consumer);
        } catch (Exception e) {
            logger.error("messageContainer error", e);
        }
    }
}
