package gyqw.xiaobaitu.ignite;

import gyqw.xiaobaitu.ignite.function.MyFunction;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author fred
 * @date 2018/07/02 14:19
 */
public class CollocationQueryMain {
    public static void main(String[] args) {
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
        // 设置预定义IP地址，注意端口或者端口范围是可选的。
        ipFinder.setAddresses(Collections.singleton("192.168.102.22"));
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDiscoverySpi(spi);
        cfg.setClientMode(true);
        cfg.setPeerClassLoadingEnabled(true);
        // 启动集群
        Ignite ignite = Ignition.start(cfg);

        // 注册自定义函数
        CacheConfiguration ccfg = new CacheConfiguration();
        ccfg.setSqlFunctionClasses(MyFunction.class);
        ccfg.setSqlSchema("APPINFO");
        ccfg.setName("SQL_PUBLIC_APPINFO");
        IgniteCache appInfoCache = ignite.getOrCreateCache(ccfg);

        try {
            // 标准查询
            SqlFieldsQuery query = new SqlFieldsQuery("select distinct idno as idno, sqr(2) from appinfo where mobile='15001964062'");
            long start = System.currentTimeMillis();
            FieldsQueryCursor<List<?>> cursor = appInfoCache.query(query);
            long end = System.currentTimeMillis();
            Iterator<List<?>> iterator = cursor.iterator();
            System.out.println("Query result:");
            List<?> row = iterator.next();
            System.out.println(">>>    " + row.get(0) + " time: " + (end - start));

            // 模糊查询
            SqlFieldsQuery query1 = new SqlFieldsQuery("select sqr(2)");
            QueryCursor<List<?>> cursor1 = appInfoCache.query(query1);
            iterator = cursor.iterator();
            List<?> row1 = iterator.next();
            System.out.println("调用sqr函数后的number数据为：" + row1.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }

        appInfoCache.close();
        ignite.close();
    }
}
