package mx.tirio.app.multiservice.service;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "service-test-client", url = "http://localhost:9000/msr/service")
public interface GenericServiceClient {

    @PostMapping(value = "/{serviceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HashMap<String, Object> postMapping(@PathVariable("serviceId") String serviceId);
}
