package gyqw.xiaobaitu.ignite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author fred
 * @date 2018/07/02 14:19
 */
public class JdbcQueryMain {
    public static void main(String[] args) {
        try {
            // Register JDBC driver
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

            // Open JDBC connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:ignite:thin://192.168.102.22/");

            // Create database tables
            try (Statement stmt = conn.createStatement()) {

                // Create table based on PARTITIONED template with one backup
                long start = System.currentTimeMillis();
                ResultSet resultSet = stmt.executeQuery("SELECT DISTINCT idno AS num FROM appinfo WHERE mobile='15001964062'");
                long end = System.currentTimeMillis();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("num"));
                    System.out.println(end - start);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
