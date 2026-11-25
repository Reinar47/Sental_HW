package ru.sental.mainmodulespring.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class ConnectionHolder {

    private final DataSource dataSource;

    private final Map<Thread, Connection> threadConnections = new ConcurrentHashMap<>();
    private final Map<Thread, Boolean> transactionFlags = new ConcurrentHashMap<>();


    /** Взять коннект для текущего потока */
//     *
//     * getConnection()
//     * │
//     * ├─ есть коннект для потока?
//     * │   ├─ нет ──────────────────────────────────┐
//     * │   └─ да                                     │
//     * │       ├─ закрыт?                            │
//     * │       │   ├─ да, и поток в транзакции ──► throw IllegalStateException
//     * │       │   ├─ да, поток не в транзакции ──► удалить записи → создать новый
//     * │       │   └─ нет ──► return existing
//     * │                                             │
//     * └─────────────────────────────────────────────┘
//     *                                               │
//     *               создать новый: dataSource.getConnection()
//     *               setAutoCommit(true)
//     *               threadConnections.put(thread, conn)
//     *               transactionFlags.put(thread, false)
//     *               return conn
//     * */
    public Connection getConnection() throws SQLException {
        Thread current = Thread.currentThread();
        Connection existing = threadConnections.get(current);
        boolean inTransaction = Boolean.TRUE.equals(transactionFlags.get(current));

        if (existing != null) {
            if (existing.isClosed()) {
                if (inTransaction) {
                    throw new IllegalStateException(
                            "Connection was closed within an active transaction for thread: " + current.getName());
                }
                threadConnections.remove(current);
                transactionFlags.remove(current);
            } else {
                return existing;
            }
        }

        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(true);
        threadConnections.put(current, connection);
        transactionFlags.put(current, false);
        return connection;
    }

    /** Начать транзакцию для текущего потока */
    public Connection beginTransaction() throws SQLException {
        Thread current = Thread.currentThread();
        Connection connection = getConnection();
        if (Boolean.TRUE.equals(transactionFlags.get(current))) {
            return connection; // уже в транзакции
        }
        connection.setAutoCommit(false);
        transactionFlags.put(current, true);
        return connection;
    }

    public void commitAndReset() throws SQLException {
        Thread current = Thread.currentThread();
        Connection connection = threadConnections.get(current);
        if (connection != null && !connection.isClosed()) {
            connection.commit();
            connection.setAutoCommit(true);
        }
        transactionFlags.put(current, false);
    }

    public void rollbackAndReset() throws SQLException {
        Thread current = Thread.currentThread();
        Connection connection = threadConnections.get(current);
        if (connection != null && !connection.isClosed()) {
            connection.rollback();
            connection.setAutoCommit(true);
        }
        transactionFlags.put(current, false);
    }

    /** Закрыть все коннекты при закрытии контекста */
    public void closeAll() {
        threadConnections.values().forEach(connection -> {
            try {
                if (!connection.isClosed()) connection.close();
            } catch (SQLException ignored) { }
        });
        threadConnections.clear();
        transactionFlags.clear();
    }
}