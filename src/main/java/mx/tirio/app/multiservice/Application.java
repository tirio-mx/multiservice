package mx.tirio.app.multiservice;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class Application {

    public static void main(final String[] args) {
        log.info("main");
        SpringApplication.run(Application.class, args);

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
