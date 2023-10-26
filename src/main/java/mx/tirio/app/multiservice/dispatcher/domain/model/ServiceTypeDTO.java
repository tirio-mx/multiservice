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
public class ServiceTypeDTO extends BaseRecordDTO {

	/**
	 * Attribute serialVersionUID.
	 */
	private static final long serialVersionUID = -849929799426585831L;

	/**
	 * Attribute id.
	 */
	private Integer id;

	/**
	 * All args contructor.
	 * 
	 * @param id           id
	 * @param descripcion  description
	 * @param creationDate creation date
	 * @param creationUser creation user
	 * @param status       status
	 */
	@Builder
	public ServiceTypeDTO(final Integer id, final String name, final String descripcion, final Date creationDate,
			final String creationUser, final Short status) {
		super(name, descripcion, creationDate, creationUser, status);
		this.id = id;
	}

}
