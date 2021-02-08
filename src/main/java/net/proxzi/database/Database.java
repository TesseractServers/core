package net.proxzi.database;

import org.intellij.lang.annotations.Language;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class acts as a wrapper class for a MySQL connection.
 * @since Core 1.0
 * @author Tassilo
 */
public class Database {

	private final Connection connection;

	/**
	 * Creates a new {@link Database} object using the given underlying connection.
	 * @param connection the MySQL connection
	 */
	public Database(Connection connection) {
		this.connection = connection;
	}



	/**
	 * Prepares a new statement. For security reasons (mainly to avoid SQL injections)
	 * this should be used at all times, rather than using generic SQL queries.
	 * @param sql the query
	 * @return the created statement
	 * @throws SQLException if an SQL error occurs
	 */
	public Statement prepare(@Language("MySQL") String sql) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(sql);
		return new Statement(stmt);
	}



	/**
	 * Closes the underlying database connection.
	 * @throws SQLException if an SQL error occurs
	 */
	public void disconnect() throws SQLException {
		connection.close();
	}

}
