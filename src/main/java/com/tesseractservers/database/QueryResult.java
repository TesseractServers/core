package com.tesseractservers.database;

import com.tesseractservers.Base16;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

/**
 * This class represents the result of an SQL query.
 * This is more or less a wrapper class for {@link ResultSet}.
 * @since Core 1.0
 * @author Tassilo
 * @see ResultSet
 */
public class QueryResult {

	private final ResultSet internal;

	/**
	 * Constructs a new QueryResult using the given underlying ResultSet.
	 * @param internal the result set
	 */
	protected QueryResult(ResultSet internal) {
		this.internal = internal;
	}

	/**
	 * Returns the boolean at the given index. A boolean is determined by an int-value, where
	 * <code>false</code> is represented by a zero and <code>true</code> is represented by non-zero values.
	 * @param index the index
	 * @return the boolean value
	 * @throws SQLException if an SQL error occurs
	 */
	public boolean getBoolean(int index) throws SQLException {
		return internal.getInt(index) != 0;
	}

	/**
	 * Returns the integer at the given index.
	 * @param index the index
	 * @return the integer value
	 * @throws SQLException if an SQL error occurs
	 */
	public int getInt(int index) throws SQLException {
		return internal.getInt(index);
	}

	/**
	 * Returns the long at the given index.
	 * @param index the index
	 * @return the long value
	 * @throws SQLException if an SQL error occurs
	 */
	public long getLong(int index) throws SQLException {
		return internal.getLong(index);
	}

	/**
	 * Returns the string at the given index.
	 * @param index the index
	 * @return the string value
	 * @throws SQLException if an SQL error occurs
	 */
	public String getString(int index) throws SQLException {
		return internal.getString(index);
	}

	/**
	 * Returns the UUID at the given index. This essentially calls {@link #getString(int)} and then
	 * runs {@link UUID#fromString(String)}.
	 * @param index the index
	 * @return the UUID value
	 * @throws SQLException if an SQL error occurs
	 * @see UUID#fromString(String)
	 * @see UUID#toString()
	 */
	public UUID getUUID(int index) throws SQLException {
		String str = internal.getString(index);
		return str != null ? UUID.fromString(str) : null;
	}

	/**
	 * Returns the enum value at the given index. The enum value itself is stored as a string.
	 * @param index the index
	 * @param valueOf this should be <code>YourEnumClass::valueOf</code>
	 * @param <T> the enum
	 * @return the enum value
	 * @throws SQLException if an SQL error occurs
	 * @see Enum#valueOf(Class, String)
	 * @see Enum#name()
	 */
	public <T extends Enum<T>> T getEnum(int index, Function<String, T> valueOf) throws SQLException {
		String str = internal.getString(index);
		return str != null ? valueOf.apply(str) : null;
	}

	/**
	 * Returns the date value at the given index. The date value itself is stored as a long.
	 * @param index the index
	 * @return the date
	 * @throws SQLException if an SQL error occurs
	 * @see Date#Date(long)
	 * @see Date#getTime()
	 */
	public Date getDate(int index) throws SQLException {
		return new Date(internal.getLong(index));
	}

	/**
	 * Loads the data stored at the given index into the entity.
	 * @param index the index
	 * @param entity the entity
	 * @return the entity
	 * @throws SQLException if an SQL error occurs
	 */
	public DynamicDataEntity getEntity(int index, DynamicDataEntity entity) throws SQLException {
		byte[] data = Base16.decode(internal.getString(index));
		try {
			entity.load(new DataInputStream(new ByteArrayInputStream(data)));
		} catch (IOException ex) {
			throw new SQLException("Failed to load DynamicDataEntity @ index " + index, ex);
		}
		return entity;
	}

}
