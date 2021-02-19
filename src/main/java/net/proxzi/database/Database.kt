package net.proxzi.database

import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.SQLException

/**
 * Creates a new {@link Database} object using the given underlying connection.
 * @param connection the MySQL connection
 * @since Core 1.1
 * @author Tassilo
 */
class Database(private val connection: Connection) {

	/**
	 * Prepares a new statement. For security reasons (mainly to avoid SQL injections)
	 * this should be used at all times, rather than using generic SQL queries.
	 * @param sql the query
	 * @return the created statement
	 * @throws SQLException if an SQL error occurs
	 */
	@Throws(SQLException::class)
	fun prepare(@Language("MySQL") sql: String): Statement {
		return Statement(connection.prepareStatement(sql))
	}

	/**
	 * Closes the underlying database connection.
	 * @throws SQLException if an SQL error occurs
	 */
	@Throws(SQLException::class)
	fun disconnect() {
		connection.close()
	}

}
