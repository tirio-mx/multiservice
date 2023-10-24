package mx.tirio.app.multiservice.dispatcher.infraestructure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceTypeDTO;
import mx.tirio.app.multiservice.dispatcher.domain.output.ServiceTypeStorePort;

/**
 * JPA Adapter used to access ServiceTypeRepository.
 * 
 * @author Gerardo Corsan
 */
@Component
public class ServiceTypeAdapter implements ServiceTypeStorePort {

    /**
     * Attribute servicetypeRepository.
     */
    @Autowired
    private ServiceTypeRepository servicetypeRepository;

    /**
     * Retrieve a list of service types.
     * 
     * @return the list of service types.
     */
    public List<ServiceTypeDTO> getServiceTypeList() {
        List<ServiceTypeDTO> serviceTypess = StreamSupport.stream(servicetypeRepository.findAll().spliterator(), false)
                .map(entity -> {
                    ServiceTypeDTO serviceType = ServiceTypeDTO.builder().build();
                    BeanUtils.copyProperties(entity, serviceType);
                    return serviceType;
                }).collect(Collectors.toList());

        return serviceTypess;
    }

}
