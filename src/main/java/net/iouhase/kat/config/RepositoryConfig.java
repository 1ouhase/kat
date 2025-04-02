package net.iouhase.kat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfig {

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://iouhase.net:3306/kat");
        dataSource.setUsername("user");
        dataSource.setPassword("kan ikke huske det gad ikke finde det :)");

        return dataSource;
    }
}
