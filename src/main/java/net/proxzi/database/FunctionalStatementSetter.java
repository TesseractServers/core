package net.proxzi.database;

import java.sql.SQLException;

/**
 * This functional interface is solely used by utility functions.
 * Example usage:<br/>
 * <code>Statement::setString</code>
 * @param <T> the type
 * @since Core 1.0
 * @author Tassilo
 */
@FunctionalInterface
public interface FunctionalStatementSetter<T> {

	void set(Statement stmt, int index, T value) throws SQLException;

}
