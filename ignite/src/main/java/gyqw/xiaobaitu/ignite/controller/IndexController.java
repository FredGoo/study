package gyqw.xiaobaitu.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fred
 * @date 2018/06/13 13:48
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "";
    }
}
