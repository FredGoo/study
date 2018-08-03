package gyqw.xiaobaitu.urule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fred
 * @date 2018/08/03 11:06
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/index")
    public String index() {
        //输出日志文件
        System.out.println("the first jsp pages");
        //返回一个index.jsp这个视图
        return "index";
    }
}