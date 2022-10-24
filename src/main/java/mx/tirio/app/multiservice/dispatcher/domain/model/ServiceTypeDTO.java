package mx.tirio.app.multiservice.dispatcher.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Transfer object used for services.
 *
 * @author Gerardo Corsan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ServiceTypeDTO implements Serializable {

    /**
     * Attribute id.
     */
    private Integer id;

    /**
     * Attribute description.
     */
    private String description;

}
