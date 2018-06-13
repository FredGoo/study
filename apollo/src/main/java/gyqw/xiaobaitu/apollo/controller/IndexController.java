package gyqw.xiaobaitu.apollo.controller;

import gyqw.xiaobaitu.apollo.model.Config1Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fred
 * @date 2018/06/13 13:48
 */
@RestController
public class IndexController {
    private Config1Model configModel;

    @Autowired
    public void setConfigModel(Config1Model configModel) {
        this.configModel = configModel;
    }

    @RequestMapping("/")
    public String index() {
        return this.configModel.getContainer();
    }
}
