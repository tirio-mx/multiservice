package mx.tirio.app.multiservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Logger;

/**
 * REST clients configuration.
 * 
 * @author Gerardo Corsan
 *
 */
@Configuration
public class RestConfig {

    /**
     * Used to define logging leve for Feign clients.
     * 
     * @return logger
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * Used to get an instance of RestTemplate.
     * 
     * @return RestTemplate instance.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}