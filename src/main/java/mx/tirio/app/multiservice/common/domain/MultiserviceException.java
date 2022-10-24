package mx.tirio.app.multiservice.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

/**
 * MultiService exception.
 * 
 * @author Gerardo Corsan.
 *
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MultiserviceException extends RuntimeException {

    /**
     * Attribute serialVersionUID.
     */
    private static final long serialVersionUID = 5785734391644859417L;

    /**
     * Constructor using a string message.
     * 
     * @param message the message.
     */
    public MultiserviceException(final String message) {
        super(message);

    }

    /**
     * Constructor using a exception.
     * 
     * @param ex the exception.
     */
    public MultiserviceException(final Exception ex) {
        super(ex);

    }

}
