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

/**
 * Class used to start Multiservice application.
 * @author Gerardo Corsan
 *
 */
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

    /**
     * Main method.
     * 
     * @param args the args.
     */
    public static void main(final String[] args) {
        log.info("main");
        SpringApplication.run(MultiserviceApplication.class, args);

    }

    /**
     * Used to start internal H2 database.
     * 
     * @return The created server.
     * @throws SQLException if error occurs.
     */
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
    	log.info("##################################################################");
        final String userDir = System.getProperty("user.dir");
        return Server.createTcpServer("-baseDir", userDir + "/data/db", "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    /**
     * DataSource validator.
     * 
     * @param dataSource the data source.
     * @return the validator.
     */
    @Bean
    public DatabaseStartupValidator databaseStartupValidator(final DataSource dataSource) {
        var dsv = new DatabaseStartupValidator();
        dsv.setDataSource(dataSource);
        return dsv;
    }

    /**
     * Application to String.
     */
    @Override
    public final String toString() {
        return "MultiService Application";
    }

    /**
     * Application initizalization.
     */
    @PostConstruct
    public final void init() {
        log.info("Initializing ...");
    }

}
