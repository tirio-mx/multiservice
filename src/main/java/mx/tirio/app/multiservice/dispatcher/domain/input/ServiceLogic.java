package mx.tirio.app.multiservice.dispatcher.domain.input;

import java.util.List;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceDTO;

/**
 * Input port ServiceLogic.
 * 
 * @author Gerardo Corsan
 */
public interface ServiceLogic {

    /**
     * Retrieve the list of services.
     * 
     * @return the list of services.
     */
    List<ServiceDTO> getServiceList();

}
