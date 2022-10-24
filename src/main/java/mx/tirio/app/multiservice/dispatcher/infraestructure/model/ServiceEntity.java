package mx.tirio.app.multiservice.dispatcher.infraestructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Transfer object used for services.
 *
 * @author Gerardo Corsan
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
@EqualsAndHashCode(callSuper = true)
public class ServiceEntity extends BaseFact {

    /**
     * Attribute serialVersionUID.
     */
    private static final long serialVersionUID = 5604094974851343542L;

    /**
     * Attribute id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    /**
     * Attribute key.
     */
    @Column(name = "service_key")
    private String key;

    /**
     * Attribute hash.
     */
    @Column(name = "service_hash")
    private String hash;

    /**
     * Attribute serviceType.
     */
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceTypeEntity serviceType;

}
