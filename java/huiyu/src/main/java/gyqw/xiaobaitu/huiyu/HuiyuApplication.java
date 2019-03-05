package gyqw.xiaobaitu.huiyu;

import gyqw.xiaobaitu.huiyu.dto.BaseResult;
import gyqw.xiaobaitu.huiyu.service.AiRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fred
 * 2018-10-31 5:47 PM
 */
public class HuiyuApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("huiyu");

        AiRequest aiRequest = applicationContext.getAutowireCapableBeanFactory().getBean(AiRequest.class);
        BaseResult baseResult = aiRequest.queryList("190213001514", 1, 10);
    }
}
