package gyqw.xiaobaitu.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fred
 * 2018-10-31 5:53 PM
 */
@RequestMapping("/index")
@RestController
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
