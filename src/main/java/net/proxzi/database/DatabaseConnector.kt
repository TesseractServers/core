package net.proxzi.database

import java.sql.DriverManager
import java.sql.SQLException

/**
 * This is a utility class for creating database connections.
 * @since Core 1.1
 * @author Tassilo
 */
object DatabaseConnector {

	/**
	 * The URL format used for connecting.
	 */
	private const val URL_FORMAT: String = "jdbc:mysql://%s:%d/%s?rewriteBatchedStatements=true&serverTimezone=UTC&autoReconnect=true"

	/**
	 * Tries to create a new database connection using the given credentials.
	 * @param hostname the hostname (e.g. 'localhost)
	 * @param database the database name
	 * @param username the username
	 * @param password the password
	 * @param port the port (by default 3306)
	 * @return the created connection
	 * @throws SQLException if an SQL error occurs
	 */
	@Throws(SQLException::class)
	fun connect(hostname: String, database: String, username: String, password: String, port: Int = 3306): Database {
		val url = URL_FORMAT.format(hostname, port, database)
		val connection = DriverManager.getConnection(url, username, password)
		return Database(connection)
	}

	/**
	 * Tries to load the MySQL driver.
	 * @throws ClassNotFoundException if the driver couldn't be found
	 */
	@Throws(ClassNotFoundException::class)
	fun loadDriver() {
		Class.forName("com.mysql.jdbc.Driver")
	}

}
