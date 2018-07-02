package gyqw.xiaobaitu.ignite.function;

import org.apache.ignite.cache.query.annotations.QuerySqlFunction;

/**
 * @author fred
 * @date 2018/07/02 15:48
 */
public class MyFunction {
    @QuerySqlFunction
    public static int sqr(int x) {
        return x * x;
    }
}
