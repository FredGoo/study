package gyqw.xiaobaitu.huiyu.controller;

import gyqw.xiaobaitu.huiyu.dto.BaseResult;
import gyqw.xiaobaitu.huiyu.service.AiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fred
 * 2018-10-31 5:53 PM
 */
@RequestMapping("/index")
@RestController
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    private AiRequest aiRequest;

    @Autowired
    public void setAiRequest(AiRequest aiRequest) {
        this.aiRequest = aiRequest;
    }

    @RequestMapping("/getDetailByBatchNo")
    public BaseResult getDetailByBatchNo() {
        return this.aiRequest.queryList("190213001514", 1, 10);
    }
}
