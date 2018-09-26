package gyqw.xiaobaitu.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * @author fred
 * 2018-09-17 3:40 PM
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    private int init = 0;
    private int status = 1;
    private int timeGap = 1000;
    private AmqpTemplate amqpTemplate;

    @Autowired
    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @RequestMapping("/start")
    public void start() {
        while (this.status == 1) {
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("time", this.init);
                amqpTemplate.convertAndSend("testQueueKey", map);
                logger.info("start " + map.toString());
                this.init++;
                sleep(this.timeGap);
            } catch (Exception e) {
                logger.error("start error", e);
            }
        }
    }

    @RequestMapping("/status")
    public int status(@RequestParam("status") int status) {
        this.status = status;
        return this.status;
    }

    @RequestMapping("/setTimeGap")
    public void setTimeGap(@RequestParam("gap") int gap) {
        this.timeGap = gap;
    }
}
