package com.tesseractservers.database;

import java.sql.SQLException;

/**
 * A data object basically represents a row in a database table.
 * @since Core 1.0
 * @author Tassilo
 */
public interface DataEntity {

	/**
	 * Creates this data object.
	 * @throws SQLException if an SQL error occurs
	 */
	void create() throws SQLException;

	/**
	 * Deletes this data object.
	 * @throws SQLException if an SQL error occurs
	 */
	void delete() throws SQLException;

	/**
	 * Updates a single column value.<br/>
	 * <b>Note:</b> This method should only be used internally.
	 * @param column the column name
	 * @param value the new value
	 * @param setter the function setter
	 * @param <T> the type
	 * @throws SQLException if an SQL error occurs
	 */
	<T> void updateColumn(String column, T value, FunctionalStatementSetter<T> setter) throws SQLException;

}
