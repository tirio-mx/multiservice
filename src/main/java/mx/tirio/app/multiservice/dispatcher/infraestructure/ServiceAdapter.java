package mx.tirio.app.multiservice.dispatcher.infraestructure;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceDTO;
import mx.tirio.app.multiservice.dispatcher.domain.model.ServiceTypeDTO;
import mx.tirio.app.multiservice.dispatcher.domain.output.ServiceStorePort;

/**
 * JPA Adapter used to access ServiceRepository.
 * 
 * @author Gerardo Corsan
 */
@Component
public class ServiceAdapter implements ServiceStorePort {

    /**
     * Attribute serviceRepository.
     */
    @Autowired
    private ServiceRepository serviceRepository;

    /**
     * Retrieve a list of services.
     * 
     * @return the list of services.
     */
    public List<ServiceDTO> getServiceList() {
        List<ServiceDTO> services = StreamSupport.stream(serviceRepository.findAll().spliterator(), false)
                .map(entity -> {
                    ServiceTypeDTO serviceType = ServiceTypeDTO.builder().build();
                    BeanUtils.copyProperties(entity.getServiceType(), serviceType);
                    ServiceDTO service = ServiceDTO.builder().build();
                    BeanUtils.copyProperties(entity, service);
                    service.setServiceType(serviceType);
                    return service;
                }).collect(Collectors.toList());

        return services;
    }

}
