package mx.tirio.app.multiservice.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Used for retry JDBC connection.
 * 
 * @author Gerardo Corsan.
 *
 */
@Slf4j
@RequiredArgsConstructor
public class RetryableDataSource extends AbstractDataSource {

    /**
     * Constant MAX_ATTEMPTS.
     */
    private static final int MAX_ATTEMPTS = 5;

    /**
     * Constant MAX_DELAY.
     */
    private static final int MAX_DELAY = 10000;

    /**
     * Constant MULTIPLIER.
     */
    private static final float MULTIPLIER = 1.3f;

    /**
     * Attribute dataSource.
     */
    private final DataSource dataSource;

    /**
     * Used to get a connection.
     */
    @Override
    @Retryable(maxAttempts = MAX_ATTEMPTS, backoff = @Backoff(multiplier = MULTIPLIER, maxDelay = MAX_DELAY))
    public Connection getConnection() throws SQLException {
        log.info("getting connection ...");
        return dataSource.getConnection();
    }

    /**
     * Used to get a connection with user/password combination.
     */
    @Override
    @Retryable(maxAttempts = MAX_ATTEMPTS, backoff = @Backoff(multiplier = MULTIPLIER, maxDelay = MAX_DELAY))
    public Connection getConnection(final String username, final String password) throws SQLException {
        log.info("getting connection by username and password ...");
        return dataSource.getConnection(username, password);
    }
}