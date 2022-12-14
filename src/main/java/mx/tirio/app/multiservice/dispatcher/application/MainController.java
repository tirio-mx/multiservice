package mx.tirio.app.multiservice.dispatcher.application;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.tirio.app.multiservice.common.domain.MultiserviceException;
import mx.tirio.app.multiservice.dispatcher.domain.core.GenericService;

/**
 * 
 * @author Gerardo Corsan
 *
 */
@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "multiservice")
public class MainController {

    @Autowired
    private GenericService service;

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @Operation(summary = "Generic GET")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_ACCEPTED,
                    description = "Generic service GET call"),
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_BAD_REQUEST,
                    description = "An error ocurred while calling (Generic GET).")
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
    @RequestMapping(value = "/multiservice/service/{serviceId}",
            produces = "application/json",
            method = { RequestMethod.GET })
    public final ResponseEntity<String> executeGetService(
            @PathVariable("serviceId") final String serviceId) {
        log.info("Calling GET service: {} ...", serviceId);

        return ResponseEntity.ok(service.getServiceData(serviceId));
    }

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @Operation(summary = "Generic PUT")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_ACCEPTED,
                    description = "Generic service PUT call"),
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_BAD_REQUEST,
                    description = "An error ocurred while calling (Generic PUT).")
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
    @RequestMapping(value = "/multiservice/service/{serviceId}",
            produces = "application/json",
            method = { RequestMethod.PUT })
    public final ResponseEntity<String> executePutService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling PUT service: {} ... Body: {}", serviceId, body);
        return ResponseEntity.ok(service.getServiceData(serviceId));
    }

    /**
     * MultiService main endpoint.
     * 
     * @param serviceId .
     * @return Something
     */
    @Operation(summary = "Generic POST")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_ACCEPTED,
                    description = "Generic service POST call"),
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_BAD_REQUEST,
                    description = "An error ocurred while calling (Generic POST).")
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
    @RequestMapping(value = "/multiservice/service/{serviceId}",
            produces = "application/json",
            method = { RequestMethod.POST })
    public final ResponseEntity<String> executePostService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling POST service: {} ... Body: {}", serviceId, body);
        return ResponseEntity.ok(service.getServiceData(serviceId));
    }

    /**
     *
     * @param serviceId
     * @param body
     * @return
     * @throws MultiserviceException
     */
    @Operation(summary = "Generic TEST")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_ACCEPTED,
                    description = "Generic service TEST call"),
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_BAD_REQUEST,
                    description = "An error ocurred while calling (Generic TEST).")
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
    @RequestMapping(value = "/multiservice/test/{serviceId}",
            produces = "application/json",
            method = {
                    RequestMethod.GET,
                    RequestMethod.PUT,
                    RequestMethod.POST })
    public final ResponseEntity<String> executeTestService(
            @PathVariable("serviceId") final String serviceId,
            @RequestBody(required = false) final String body) {
        log.info("Calling test service: {}. Body: {}", serviceId, body);
        return ResponseEntity.ok(service.getServiceData(serviceId));
    }

    /**
     * 
     * @return
     */
    @Operation(summary = "Service list")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_ACCEPTED,
                    description = "Returns the list of registered services"),
            @ApiResponse(
                    responseCode = "" + HttpStatus.SC_BAD_REQUEST,
                    description = "An error ocurred while calling (Service list).")
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
    @RequestMapping(value = "/multiservice/list",
            produces = "application/json",
            method = { RequestMethod.GET })
    public final ResponseEntity<String> listServices() {
        log.info("Calling list services ...");
        return ResponseEntity.ok(service.listServices());
    }

}
