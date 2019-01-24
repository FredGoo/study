package gyqw.playground.rabbitmq.controller;

import gyqw.playground.rabbitmq.service.RabbitmqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fred
 * 2019-01-24 1:56 PM
 */
@RestController
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    private RabbitmqService rabbitmqService;


    @Autowired
    public void setRabbitmqService(RabbitmqService rabbitmqService) {
        this.rabbitmqService = rabbitmqService;
    }

    @RequestMapping("/startTest")
    public boolean startTest() {
        this.rabbitmqService.initQueues();
        this.rabbitmqService.bindListeners();
        this.rabbitmqService.startSendMsg();
        return true;
    }

    @RequestMapping("/initQueues")
    public boolean initQueues() {
        this.rabbitmqService.initQueues();
        return true;
    }

    @RequestMapping("/bindListeners")
    public boolean bindListeners() {
        this.rabbitmqService.bindListeners();
        return true;
    }

    @RequestMapping("/startSend")
    public boolean start() {
        this.rabbitmqService.startSendMsg();
        return true;
    }

    @RequestMapping("/stopSend")
    public boolean stop() {
        this.rabbitmqService.setSend(false);
        return true;
    }
}
