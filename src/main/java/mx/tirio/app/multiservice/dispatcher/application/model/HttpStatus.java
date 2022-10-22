package mx.tirio.app.multiservice.dispatcher.application.model;

/**
 * @author Gerardo Corsan
 *
 */
public final class HttpStatus {

    public static final int OK = 200;

    public static final int ACCEPTED = 202;

    public static final int BAD_REQUEST = 400;

    public static final int NOT_FOUND = 404;

    public static final int INTERNAL_SERVER_ERROR = 500;

    private HttpStatus() {
    }

}
