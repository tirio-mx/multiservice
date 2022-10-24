package mx.tirio.app.multiservice.dispatcher.domain.output;

import java.util.List;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceDTO;

/**
 * Output port ServiceStorePort.
 * 
 * @author Gerardo Corsan
 */
public interface ServiceStorePort {

    /**
     * Retrieve the list of services.
     * 
     * @return the list of services.
     */
    List<ServiceDTO> getServiceList();

}
