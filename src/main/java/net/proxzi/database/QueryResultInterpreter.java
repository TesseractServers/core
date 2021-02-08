package net.proxzi.database;

import java.sql.SQLException;

/**
 * A functional interface used for getting an object (e.g. an account) out of a {@link QueryResult},
 * @param <T> the object type
 * @since Core 1.0
 * @author Tassilo
 */
@FunctionalInterface
public interface QueryResultInterpreter<T> {

	/**
	 * Parses the given query result and returns the created object.
	 * @param result the query result
	 * @return the object
	 * @throws SQLException if an SQL error occurs
	 */
	T interpret(QueryResult result) throws SQLException;

}
