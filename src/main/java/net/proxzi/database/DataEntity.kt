package net.proxzi.database

import kotlin.Throws
import java.sql.SQLException
import net.proxzi.database.Database
import net.proxzi.database.FunctionalStatementSetter

/**
 * A data object basically represents a row in a database table.
 * @since Core 1.0
 * @author Tassilo
 */
interface DataEntity {
    /**
     * Creates this data object.
     * @param db the database
     * @throws SQLException if an SQL error occurs
     */
    @Throws(SQLException::class)
    fun create(db: Database?)

    /**
     * Deletes this data object.
     * @param db the database
     * @throws SQLException if an SQL error occurs
     */
    @Throws(SQLException::class)
    fun delete(db: Database?)

    /**
     * Updates a single column value.<br></br>
     * **Note:** This method should only be used internally.
     * @param db the database
     * @param column the column name
     * @param value the new value
     * @param setter the function setter
     * @param <T> the type
     * @throws SQLException if an SQL error occurs
    </T> */
    @Throws(SQLException::class)
    fun <T> updateColumn(db: Database?, column: String?, value: T, setter: FunctionalStatementSetter<T>?)
}
