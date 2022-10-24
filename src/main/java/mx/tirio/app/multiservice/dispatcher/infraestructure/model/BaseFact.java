package mx.tirio.app.multiservice.dispatcher.infraestructure.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Class having common fact attributes.
 *
 * @author Gerardo Corsan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode
public class BaseFact implements Serializable {

    /**
     * Attribute serialVersionUID.
     */
    private static final long serialVersionUID = -9043976862441911000L;

    /**
     * Attribute description.
     */
    @Column(name = "description")
    private String description;

    /**
     * Attribute creationDate.
     */
    @Column(name = "creationDate")
    private Date creationDate;

    /**
     * Attribute creationUser.
     */
    @Column(name = "creation_user")
    private String creationUser;

    /**
     * Attribute status.
     */
    private Short status;

}
