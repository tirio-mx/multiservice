package mx.tirio.app.multiservice.dispatcher.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@MappedSuperclass
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseRecordDTO implements Serializable {

	/**
	 * Attribute serialVersionUID.
	 */
	private static final long serialVersionUID = 3437417787288415440L;

	/**
	 * Attribute name.
	 */
	private String name;

	/**
	 * Attribute description.
	 */
	private String description;

	/**
	 * Attribute creationDate.
	 */
	private Date creationDate;

	/**
	 * Attribute creationUser.
	 */
	private String creationUser;

	/**
	 * Attribute status.
	 */
	private Short status;

}
