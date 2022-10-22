package mx.tirio.app.multiservice;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.retry.annotation.EnableRetry;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;

@OpenAPIDefinition(info = @Info(
        title = "MultiService",
        version = "0.1.1",
        description = "Multiservice application", 
        license = @License(
                name = "APACHE LICENSE, VERSION 2.0",
                url = "https://www.apache.org/licenses/LICENSE-2.0"),
        contact = @Contact(
                name = "TirioMX",
                url = "http://tirio.mx")))
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
