package laboratorio.config.databaseConfiguration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;


@Configuration
public class TimesheetDbConfig {

    @Bean(name = "timesheetDataSource")
    public DataSource timesheetDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=timesheet"); // Set JDBC URL
        hikariConfig.setUsername("sa"); // Set username
        hikariConfig.setPassword("Password123!"); // Set password
        hikariConfig.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Set driver class name
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "timesheetJdbcTemplate")
    public JdbcTemplate timesheetJdbcTemplate(@Qualifier("timesheetDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}