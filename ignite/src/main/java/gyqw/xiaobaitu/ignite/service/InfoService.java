package gyqw.xiaobaitu.ignite.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author fred
 */
@Service
public class InfoService {
    private static final Logger logger = LoggerFactory.getLogger(InfoService.class);

    public void start() {
        try {
            // Register JDBC driver
            Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

            // Open JDBC connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:ignite:thin://192.168.2.77/");

            // Create database tables
            try (Statement stmt = conn.createStatement()) {

                // Create table based on REPLICATED template
                stmt.executeUpdate("CREATE TABLE City (" +
                        " id LONG PRIMARY KEY, name VARCHAR) " +
                        " WITH \"template=replicated\"");

                // Create table based on PARTITIONED template with one backup
                stmt.executeUpdate("CREATE TABLE Person (" +
                        " id LONG, name VARCHAR, city_id LONG, " +
                        " PRIMARY KEY (id, city_id)) " +
                        " WITH \"backups=1, affinityKey=city_id\"");
            }

        } catch (Exception e) {
            logger.error("start error", e);
        }

    }
}
