package mx.tirio.app.multiservice.dispatcher.domain.core;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.tirio.app.multiservice.common.domain.MultiserviceException;
import mx.tirio.app.multiservice.dispatcher.infraestructure.GenericServiceClient;

/**
 * Used to get service data.
 * 
 * @author Gerardo Corsan
 *
 */
@Service
@Slf4j
public class GenericService {

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
     * @return JSON Strinf for the list of services.
     * @throws MultiserviceException if error occurs.
     */
    public String listServices() {
        log.info("Getting list of services ...");
        File serviceDataDir = new File("./data/responses");
        String result = null;

        if (serviceDataDir.exists()) {
            try {
                File[] files = serviceDataDir.listFiles(new FilenameFilter() {
                    public boolean accept(final File dir, final String name) {
                        return name.toLowerCase().endsWith(".json");
                    }
                });
                Stream<File> stream = Arrays.stream(files);
                result = stream
                        .map(file -> "\"" + file.getName().substring(0, file.getName().lastIndexOf('.')) + "\"")
                        .collect(Collectors.joining(",\n", "{\"services\":\n[\n", "]\n}"));
            } catch (Exception e) {
                throw new MultiserviceException(e);
            }
        } else {
            throw new MultiserviceException("No response found.");
        }

        return result;
    }

}
