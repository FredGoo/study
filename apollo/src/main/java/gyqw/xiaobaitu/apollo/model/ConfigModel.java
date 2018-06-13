package gyqw.xiaobaitu.apollo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author fred
 * @date 2018/06/13 13:35
 */
public class ConfigModel {
    @Value("${dubbo.container}")
    private String container;

    public String getContainer() {
        return container;
    }
}
