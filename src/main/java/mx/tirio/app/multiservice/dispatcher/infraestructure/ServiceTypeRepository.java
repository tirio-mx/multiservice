package mx.tirio.app.multiservice.dispatcher.infraestructure;

import org.springframework.data.repository.CrudRepository;

import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceTypeEntity;

/**
 * 
 * Repository used for Service entity.
 *
 * @author Gerardo Corsan
 */
public interface ServiceTypeRepository extends CrudRepository<ServiceTypeEntity, Integer> {

}
