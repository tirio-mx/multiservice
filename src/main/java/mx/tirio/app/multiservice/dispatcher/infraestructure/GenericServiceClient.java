package mx.tirio.app.multiservice.dispatcher.infraestructure;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Client for call generic services.
 * 
 * @author Gerardo Corsan
 *
 */
@FeignClient(name = "service-test-client", url = "http://localhost:4080/msr/service")
public interface GenericServiceClient {

    /**
     * Used for POST calls.
     * 
     * @param serviceId service identifier.
     * @return the post call response.
     */
    @PostMapping(value = "/{serviceId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    HashMap<String, Object> postMapping(@PathVariable("serviceId") String serviceId);
}
