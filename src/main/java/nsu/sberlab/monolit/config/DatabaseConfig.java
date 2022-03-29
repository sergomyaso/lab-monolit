package nsu.sberlab.monolit.config;

import org.apache.logging.log4j.LogManager;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {
    // захардкодили по пацански
    private static final String postgresDSN = "jdbc:postgresql://127.0.0.1:5434/monolit";
    private static final String postgresUser = "superadmin";
    private static final String postgresPassword = "123123";

    @Bean(name = "db")
    public Connection db() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(postgresDSN, postgresUser, postgresPassword);
        } catch (SQLException e) {
            System.out.printf("[ERROR] Gark with connection to db, err: %s", e.getMessage());
        }

        return conn;
    }
}
