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
public class ServiceDTO implements Serializable {
    /**
     * Attribute serialVersionUID.
     */
    private static final long serialVersionUID = -65206569935593456L;

    /**
     * Attribute id.
     */
    private Integer id;

    /**
     * Attribute key.
     */
    private String key;

    /**
     * Attribute hash.
     */
    private String hash;

    /**
     * Attribute serviceType.
     */
    private ServiceTypeDTO serviceType;

}
