package mx.tirio.app.multiservice.dispatcher.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import mx.tirio.app.multiservice.dispatcher.domain.core.GenericService;
import mx.tirio.app.multiservice.model.MultiserviceException;

/**
 * 
 * @author Gerardo Corsan
 *
 */
@RestController
@RequestMapping("multiservice")
@Slf4j
public class MainController {

    @Autowired
    private GenericService service;

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/service/{serviceId}", produces = "application/json", method = {
            RequestMethod.GET })
    public final ResponseEntity<String> executeGetService(
            @PathVariable("serviceId") final String serviceId) {
        log.info("Calling GET service: {} ...", serviceId);
        return new ResponseEntity<>(service.getServiceData(serviceId), HttpStatus.OK);
    }

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/service/{serviceId}", produces = "application/json", method = {
            RequestMethod.PUT })
    public final ResponseEntity<String> executePutService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling PUT service: {} ... Body: {}", serviceId, body);
        return new ResponseEntity<>(service.getServiceData(serviceId), HttpStatus.OK);
    }

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/service/{serviceId}", produces = "application/json", method = {
            RequestMethod.POST })
    public final ResponseEntity<String> executePostService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling POST service: {} ... Body: {}", serviceId, body);
        return new ResponseEntity<>(service.getServiceData(serviceId), HttpStatus.OK);
    }

    /**
     *
     * @param serviceId
     * @param body
     * @return
     * @throws MultiserviceException
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/test/{serviceId}", produces = "application/json", method = {
            RequestMethod.GET,
            RequestMethod.PUT,
            RequestMethod.POST })
    public final ResponseEntity<String> executeTestService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling test service: {}. Body: {}", serviceId, body);
        return new ResponseEntity<>(service.testService(serviceId), HttpStatus.OK);
    }

    /**
     * 
     * @return
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/list", produces = "application/json", method = {
            RequestMethod.GET })
    public final ResponseEntity<String> listServices() {
        log.info("Calling list services ...");
        return new ResponseEntity<>(service.listServices(), HttpStatus.OK);
    }

}
