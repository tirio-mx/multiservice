package mx.tirio.app.multiservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * Format exception.
 * 
 * @author Gerardo Corsan.
 *
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MultiserviceException extends RuntimeException {

    private static final long serialVersionUID = 5785734391644859417L;

    public MultiserviceException(final String message) {
        super(message);

    }

    public MultiserviceException(final Exception ex) {
        super(ex);

    }

}
