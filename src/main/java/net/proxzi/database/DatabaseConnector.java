package net.proxzi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This is a utility class for creating database connections.
 * @since Core 1.0
 * @author Tassilo
 */
public class DatabaseConnector {

	/**
	 * The URL format used for connecting.
	 */
	public static final String URL_FORMAT = "jdbc:mysql://%s:%d/%s?rewriteBatchedStatements=true&serverTimezone=UTC&autoReconnect=true";

	/**
	 * Tries to create a new database connection using the given credentials.
	 * @param hostname the hostname (e.g. 'localhost)
	 * @param port the port (by default 3306)
	 * @param database the database name
	 * @param username the username
	 * @param password the password
	 * @return the created connection
	 * @throws SQLException if an SQL error occurs
	 */
	public static Database connect(String hostname, int port, String database, String username, String password) throws SQLException {
		String url = String.format(URL_FORMAT, hostname, port, database);
		Connection connection = DriverManager.getConnection(url, username, password);
		return new Database(connection);
	}

	/**
	 * Tries to load the MySQL driver.
	 * @throws ClassNotFoundException if the driver couldn't be found
	 */
	public static void loadDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}

	/**
	 * Static class.
	 */
	private DatabaseConnector() {
	}

}
