package mx.tirio.app.multiservice.dispatcher.infraestructure.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "service_type")
@EqualsAndHashCode(callSuper = true)
public class ServiceTypeEntity extends BaseFact {

    /**
     * Attribute serialVersionUID.
     */
    private static final long serialVersionUID = -2557271073273277265L;

    /**
     * Attribute id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Integer id;

    /**
     * Atributo service.
     */
    @OneToMany(mappedBy = "serviceType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServiceEntity> service;

}
