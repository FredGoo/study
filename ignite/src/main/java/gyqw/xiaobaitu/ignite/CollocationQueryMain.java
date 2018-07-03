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

        for (String name : ignite.cacheNames()) {
            System.out.println(name);
        }

        // 注册自定义函数
//        ignite.destroyCache("appInfoCache");
        CacheConfiguration ccfg = new CacheConfiguration("appInfoCache");
        ccfg.setSqlFunctionClasses(MyFunction.class);
        ccfg.setSqlSchema("PUBLIC");

//        ccfg.setName("SQL_PUBLIC_APPINFO");
        IgniteCache appInfoCache = ignite.getOrCreateCache(ccfg);

        try {
            // 创建表
            SqlFieldsQuery query0 = new SqlFieldsQuery("CREATE TABLE appInfo (\n" +
                    "ORDERID VARCHAR,\n" +
                    "STORELEVEL VARCHAR,\n" +
                    "SELLERNAME VARCHAR,\n" +
                    "DEVICENO VARCHAR,\n" +
                    "SPFULLADDRESS VARCHAR,\n" +
                    "CPNYTEL VARCHAR,\n" +
                    "CUSTOMBIRTHDAY VARCHAR,\n" +
                    "ORDERCREATETIME VARCHAR,\n" +
                    "GPSFULLADDRESS VARCHAR,\n" +
                    "LOANMONEY VARCHAR,\n" +
                    "STOREADDRESS VARCHAR,\n" +
                    "CMNAME VARCHAR,\n" +
                    "HOMEFULLADDRESS VARCHAR,\n" +
                    "ORDERTYPE VARCHAR,\n" +
                    "CUSTOMNAME VARCHAR,\n" +
                    "CPNYFULLADDRESS VARCHAR,\n" +
                    "STORENAME VARCHAR,\n" +
                    "MERCHANTNAME VARCHAR,\n" +
                    "C2RELATION VARCHAR,\n" +
                    "ORDERGPS VARCHAR,\n" +
                    "C1RELATION VARCHAR,\n" +
                    "C2MOBILE VARCHAR,\n" +
                    "SELLERMOBILE VARCHAR,\n" +
                    "CPNYNAME VARCHAR,\n" +
                    "IDNO VARCHAR,\n" +
                    "CUSTOMBANKNO VARCHAR,\n" +
                    "C1MOBILE VARCHAR,\n" +
                    "C2NAME VARCHAR,\n" +
                    "MOBILE VARCHAR,\n" +
                    "STOREINDUSTRY VARCHAR,\n" +
                    "LOANPERIOD VARCHAR,\n" +
                    "MONTHLYPAY VARCHAR,\n" +
                    "MAC VARCHAR,\n" +
                    "HOUSEHOLDFULLADDRESS VARCHAR,\n" +
                    "C1NAME VARCHAR,\n" +
                    "age INTEGER,SPFULLADDRESS_PROVINCE varchar ,SPFULLADDRESS_CITY varchar ,SPFULLADDRESS_AREA varchar ,SPFULLADDRESS_DETAIL varchar ,STOREADDRESS_PROVINCE varchar ,STOREADDRESS_CITY varchar ,STOREADDRESS_AREA varchar ,STOREADDRESS_DETAIL varchar ,HOUSEHOLDFULLADDRESS_PROVINCE varchar ,HOUSEHOLDFULLADDRESS_CITY varchar ,HOUSEHOLDFULLADDRESS_AREA varchar ,HOUSEHOLDFULLADDRESS_DETAIL varchar ,HOMEFULLADDRESS_PROVINCE varchar ,HOMEFULLADDRESS_CITY varchar ,HOMEFULLADDRESS_AREA varchar ,HOMEFULLADDRESS_DETAIL varchar ,CPNYFULLADDRESS_PROVINCE varchar ,CPNYFULLADDRESS_CITY varchar ,CPNYFULLADDRESS_AREA varchar ,CPNYFULLADDRESS_DETAIL varchar, STORECODE varchar, MERCHANTCODE varchar,\n" +
                    "gender varchar,\n" +
                    "       PRIMARY KEY (orderid))");
//            appInfoCache.query(query0);

            // 标准查询
            SqlFieldsQuery query = new SqlFieldsQuery("select distinct idno as idno from appinfo where mobile='15001964062'");
            long start = System.currentTimeMillis();
            FieldsQueryCursor<List<?>> cursor = appInfoCache.query(query);
            long end = System.currentTimeMillis();
            Iterator<List<?>> iterator = cursor.iterator();
            if (iterator.hasNext()) {
                List<?> row = iterator.next();
                System.out.println(">>>    " + row.get(0) + " time: " + (end - start));
            }

            // 模糊查询
            SqlFieldsQuery query1 = new SqlFieldsQuery("select HOMEFULLADDRESS, strSimilar('北京 昌平 计算机啊吗', HOMEFULLADDRESS) from appinfo where strSimilar('北京 昌平 计算机啊吗', HOMEFULLADDRESS) > 0.8");
            start = System.currentTimeMillis();
            QueryCursor<List<?>> cursor1 = appInfoCache.query(query1);
            end = System.currentTimeMillis();
            iterator = cursor1.iterator();
            while (iterator.hasNext()) {
                List<?> row1 = iterator.next();
                System.out.println("调用strSimilar函数后的number数据为：" + row1.get(0) + ", " + row1.get(1));
            }
            System.out.println("time: " + (end - start));

        } catch (Exception e) {
            e.printStackTrace();
        }

        appInfoCache.close();
        ignite.close();
    }
}
