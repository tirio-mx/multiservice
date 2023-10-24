package mx.tirio.app.multiservice.dispatcher.domain.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.tirio.app.multiservice.common.domain.MultiserviceException;
import mx.tirio.app.multiservice.dispatcher.domain.input.ServiceLogic;
import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceDTO;
import mx.tirio.app.multiservice.dispatcher.domain.output.ServiceStorePort;
import mx.tirio.app.multiservice.dispatcher.infraestructure.GenericServiceClient;

/**
 * Used to get service data.
 * 
 * @author Gerardo Corsan
 *
 */
@Service
@Slf4j
public class GenericService implements ServiceLogic {

    /**
     * Attibute enviroment.
     */
    @Autowired
    private Environment enviroment;

    /**
     * Attibute genericClient.
     */
    @Autowired
    private GenericServiceClient genericClient;

    /**
     * Output port ServiceLogic.
     */
    @Autowired
    private ServiceStorePort serviceStore;

    /**
     * Used to get services data.
     * 
     * @param serviceId Service identifier.
     * @return Data for the requested service.
     * @throws MultiserviceException if error occurs.
     */
    public String getServiceData(final String serviceId) {
        log.info("enviroment: {}", enviroment);

        log.info("Getting data for service: {}", serviceId);
        File serviceDataFile = new File("./data/responses/" + serviceId + ".json");
        String fileData = null;

        if (serviceDataFile.exists()) {
            try {
                fileData = FileUtils.readFileToString(serviceDataFile, "UTF-8");
            } catch (IOException e) {
                throw new MultiserviceException(e);
            }
        } else {
            throw new MultiserviceException("No response found for service [" + serviceId + "]");
        }

        return fileData;
    }

    /**
     * Used to get services test data.
     * 
     * @param serviceId Service identifier.
     * @return Data for the requested service.
     * @throws MultiserviceException if error occurs.
     */
    public String testService(final String serviceId) {
        log.info("enviroment: {}", enviroment);

        log.info("Getting data for service: {}", serviceId);
        HashMap<String, Object> response = genericClient.postMapping(serviceId);
        String fileData = null;

        if (response != null) {
            try {
                fileData = response.toString();
            } catch (Exception e) {
                throw new MultiserviceException(e);
            }
        } else {
            throw new MultiserviceException("No response found for service [" + serviceId + "]");
        }

        return fileData;
    }

    /**
     * Used to get services list.
     * 
     * @return list of services.
     * @throws MultiserviceException if error occurs.
     */
    public List<ServiceDTO> getServiceList() throws MultiserviceException {
        log.info("Getting list of services ...");

        List<ServiceDTO> services = new LinkedList<>();
        try {
            services = serviceStore.getServiceList();
        } catch (Exception e) {
            throw new MultiserviceException(e);
        }

        return services;
    }

}
