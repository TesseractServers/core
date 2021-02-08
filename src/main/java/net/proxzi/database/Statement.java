package net.proxzi.database;

import net.proxzi.Base16;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * This class represents a prepared statement.
 * It acts as a wrapper class for {@link PreparedStatement}, allowing more data types to be used.
 * @since Core 1.0
 * @author Tassilo
 * @see PreparedStatement
 */
public class Statement {

	private final PreparedStatement internal;
	private int index;

	/**
	 * Constructs a new Statement using the given underlying PreparedStatement.
	 * @param internal the prepared statement
	 */
	protected Statement(PreparedStatement internal) {
		this.internal = internal;
		this.index = 0;
	}



	/**
	 * Sets the {@link Boolean} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setBoolean(int index, boolean value) throws SQLException {
		this.index = index;
		internal.setInt(index, value ? 1 : 0);
	}

	/**
	 * Sets the {@link Integer} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setInt(int index, int value) throws SQLException {
		this.index = index;
		internal.setInt(index, value);
	}

	/**
	 * Sets the {@link Long} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setLong(int index, long value) throws SQLException {
		this.index = index;
		internal.setLong(index, value);
	}

	/**
	 * Sets the {@link String} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setString(int index, String value) throws SQLException {
		this.index = index;
		internal.setString(index, value);
	}

	/**
	 * Sets the {@link String} value at the given index.
	 * If the value is <code>null</code>, a NULL VARCHAR will be sent to the MySQL server.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setNullableString(int index, String value) throws SQLException {
		this.index = index;
		if (value != null) {
			internal.setString(index, value);
		} else {
			internal.setNull(index, Types.VARCHAR);
		}
	}

	/**
	 * Sets the {@link UUID} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see UUID#fromString(String)
	 * @see UUID#toString()
	 */
	public void setUUID(int index, UUID value) throws SQLException {
		this.index = index;
		internal.setString(index, value.toString());
	}

	/**
	 * Sets the {@link UUID} value at the given index.
	 * If the value is <code>null</code>, a NULL VARCHAR will be sent to the MySQL server.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see UUID#fromString(String)
	 * @see UUID#toString()
	 */
	public void setNullableUUID(int index, UUID value) throws SQLException {
		this.index = index;
		if (value != null) {
			internal.setString(index, value.toString());
		} else {
			internal.setNull(index, Types.VARCHAR);
		}
	}

	/**
	 * Sets the {@link Enum} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see Enum#valueOf(Class, String)
	 * @see Enum#name()
	 */
	public void setEnum(int index, Enum<?> value) throws SQLException {
		this.index = index;
		internal.setString(index, value.name());
	}

	/**
	 * Sets the {@link Date} value at the given index.
	 * @param index the index
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see Date#Date(long)
	 * @see Date#getTime()
	 */
	public void setDate(int index, Date value) throws SQLException {
		this.index = index;
		internal.setLong(index, value.getTime());
	}

	/**
	 * Sets the {@link DynamicDataEntity} at the given index.
	 * @param index the index
	 * @param entity the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void setEntity(int index, DynamicDataEntity entity) throws SQLException {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			entity.save(new DataOutputStream(out));

			this.index = index;
			internal.setString(index, Base16.encode(out.toByteArray()));
		} catch (IOException ex) {
			throw new SQLException("Failed to save DynamicDataEntity @ index " + index, ex);
		}
	}



	/**
	 * Appends a new {@link Boolean} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendBoolean(boolean value) throws SQLException {
		internal.setInt(++index, value ? 1 : 0);
	}

	/**
	 * Appends a new {@link Integer} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendInt(int value) throws SQLException {
		internal.setInt(++index, value);
	}

	/**
	 * Appends a new {@link Long} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendLong(long value) throws SQLException {
		internal.setLong(++index, value);
	}

	/**
	 * Appends a new {@link String} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendString(String value) throws SQLException {
		internal.setString(++index, value);
	}

	/**
	 * Appends a new {@link String} value.
	 * If the value is <code>null</code>, a NULL VARCHAR will be sent to the MySQL server.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendNullableString(String value) throws SQLException {
		if (value != null) {
			internal.setString(++index, value);
		} else {
			internal.setNull(++index, Types.VARCHAR);
		}
	}

	/**
	 * Appends a new {@link UUID} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see UUID#fromString(String)
	 * @see UUID#toString()
	 */
	public void appendUUID(UUID value) throws SQLException {
		internal.setString(++index, value.toString());
	}

	/**
	 * Appends a new nullable {@link UUID} value.
	 * If the value is <code>null</code>, a NULL VARCHAR will be sent to the MySQL server.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see UUID#fromString(String)
	 * @see UUID#toString()
	 */
	public void appendNullableUUID(UUID value) throws SQLException {
		if (value != null) {
			internal.setString(++index, value.toString());
		} else {
			internal.setNull(++index, Types.VARCHAR);
		}
	}

	/**
	 * Appends a new {@link Enum} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see Enum#valueOf(Class, String)
	 * @see Enum#name()
	 */
	public void appendEnum(Enum<?> value) throws SQLException {
		internal.setString(++index, value.name());
	}

	/**
	 * Appends a new {@link Date} value.
	 * @param value the value
	 * @throws SQLException if an SQL error occurs
	 * @see Date#Date(long)
	 * @see Date#getTime()
	 */
	public void appendDate(Date value) throws SQLException {
		internal.setLong(++index, value.getTime());
	}

	/**
	 * Appends the {@link DynamicDataEntity}.
	 * @param entity the value
	 * @throws SQLException if an SQL error occurs
	 */
	public void appendEntity(DynamicDataEntity entity) throws SQLException {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			entity.save(new DataOutputStream(out));
			internal.setString(++index, Base16.encode(out.toByteArray()));
		} catch (IOException ex) {
			throw new SQLException("Failed to save DynamicDataEntity @ index " + index, ex);
		}
	}



	/**
	 * Fetches, and interprets, the next result row.
	 * @param interpreter the interpreter to use
	 * @param <T> the type
	 * @return the interpreted row, or <code>null</code>
	 * @throws SQLException if an SQL error occurs
	 */
	public <T> T fetchObject(QueryResultInterpreter<T> interpreter) throws SQLException {
		ResultSet result = internal.executeQuery();
		if (result.next()) {
			T e = interpreter.interpret(new QueryResult(result));
			internal.close();
			return e;
		} else {
			internal.close();
			return null;
		}
	}

	/**
	 * Fetches, and interprets, all available result rows.
	 * @param interpreter the interpreter to use
	 * @param <T> the type
	 * @return the interpreted rows
	 * @throws SQLException if an SQL error occurs
	 */
	public <T> List<T> fetchObjects(QueryResultInterpreter<T> interpreter) throws SQLException {
		ResultSet result = internal.executeQuery();
		QueryResult queryResult = new QueryResult(result);
		List<T> list = new ArrayList<>();
		while (result.next()) {
			list.add(interpreter.interpret(queryResult));
		}
		internal.close();
		return list;
	}



	/**
	 * Executes the query.
	 * @throws SQLException if an SQL error occurs
	 */
	public void execute() throws SQLException {
		internal.execute();
	}

	/**
	 * Closes the statement.
	 * @throws SQLException if an SQL error occurs
	 */
	public void close() throws SQLException {
		internal.close();
	}

	/**
	 * Executes and closes the statement.
	 * @throws SQLException if an SQL error occurs
	 */
	public void executeAndClose() throws SQLException {
		internal.execute();
		internal.close();
	}

}
