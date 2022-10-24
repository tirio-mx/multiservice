package mx.tirio.app.multiservice.dispatcher.domain.output;

import java.util.List;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceTypeDTO;

/**
 * Output port ServiceTypeStorePort.
 * 
 * @author Gerardo Corsan
 */
public interface ServiceTypeStorePort {

    /**
     * Retrieve the list of service types.
     * 
     * @return the list of service types.
     */
    List<ServiceTypeDTO> getServiceTypeList();
}
