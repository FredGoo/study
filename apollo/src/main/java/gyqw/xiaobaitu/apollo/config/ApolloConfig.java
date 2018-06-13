package gyqw.xiaobaitu.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author fred
 * @date 2018/06/13 13:24
 */
@Configuration
@EnableApolloConfig({"application", "architecture-group.constant"})
public class ApolloConfig {
}
