package mx.tirio.app.multiservice;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.retry.annotation.EnableRetry;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableRetry
@EnableFeignClients
@Slf4j
public class MultiserviceApplication {

    public static void main(final String[] args) {
        log.info("main");
        SpringApplication.run(MultiserviceApplication.class, args);

    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        final String userDir = System.getProperty("user.dir");
        return Server.createTcpServer("-baseDir", userDir + "/data/db", "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    @Bean
    public DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
        var dsv = new DatabaseStartupValidator();
        dsv.setDataSource(dataSource);
        dsv.setValidationQuery(DatabaseDriver.H2.getValidationQuery());
        return dsv;
    }

    @Override
    public final String toString() {
        return "MultiService Application";
    }

    @PostConstruct
    public final void init() {
        log.info("Initializing ...");
    }

}
