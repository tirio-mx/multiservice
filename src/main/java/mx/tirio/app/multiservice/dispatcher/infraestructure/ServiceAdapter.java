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
import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceEntity;
import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceTypeEntity;

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
     * Used to convert service type entity into DTO.
     * 
     * @param entity service type entity
     * @return service type DTO
     */
    private ServiceTypeDTO serviceTypeEntityToDto(final ServiceTypeEntity entity) {
        ServiceTypeDTO serviceType = new ServiceTypeDTO();
        BeanUtils.copyProperties(entity, serviceType);

        return serviceType;
    }

    /**
     * Used to convert service entity into DTO.
     * 
     * @param entity service entity
     * @return service DTO
     */
    private ServiceDTO serviceEntityToDto(final ServiceEntity entity) {
        ServiceTypeDTO serviceType = serviceTypeEntityToDto(entity.getServiceType());
        ServiceDTO service = ServiceDTO.builder().build();
        BeanUtils.copyProperties(entity, service);
        service.setServiceType(serviceType);

        return service;
    }

    /**
     * Retrieve a list of services.
     * 
     * @return the list of services.
     */
    public List<ServiceDTO> getServiceList() {
        List<ServiceDTO> services = StreamSupport.stream(serviceRepository.findAll().spliterator(), false)
                .map(entity -> {
                    ServiceDTO service = serviceEntityToDto(entity);
                    return service;
                }).collect(Collectors.toList());

        return services;
    }

}
