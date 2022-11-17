package mx.tirio.app.multiservice.dispatcher.domain.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transfer object used for services.
 *
 * @author Gerardo Corsan
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ServiceDTO extends BaseRecordDTO {

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

    /**
     * All args contructor.
     * 
     * @param id           id
     * @param key          key
     * @param hash         hash
     * @param serviceType  service type
     * @param descripcion  description
     * @param creationDate creation date
     * @param creationUser creation user
     * @param status       status
     */
    @Builder
    public ServiceDTO(
            final Integer id, final String key, final String hash, final ServiceTypeDTO serviceType,
            final String descripcion, final Date creationDate, final String creationUser, final short status) {
        super(descripcion, creationDate, creationUser, status);
        this.id = id;
        this.key = key;
        this.hash = hash;
        this.serviceType = serviceType;
    }
}
