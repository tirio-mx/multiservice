package mx.tirio.app.multiservice.dispatcher.infraestructure;

import org.springframework.data.repository.CrudRepository;

import mx.tirio.app.multiservice.dispatcher.infraestructure.model.ServiceEntity;

/**
 * 
 * Repository used for Service entity.
 *
 * @author Gerardo Corsan
 */
public interface ServiceRepository extends CrudRepository<ServiceEntity, Integer> {

}
