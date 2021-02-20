package net.proxzi.database

import kotlin.Throws
import java.io.IOException
import java.io.DataInputStream
import java.io.DataOutputStream

/**
 * A dynamic data entity is an object that is converted to a byte array, which is directly
 * stored in a single column in an SQL database. This does not allow for making selective
 * queries with respect to properties of a dynamic data entity, but allows for different
 * dynamic data entities to be used on a per-row basis.<br></br><br></br>
 *
 * **Note:** Unlike DataEntities, DynamicDataEntities are stored in a single
 * **column** and not a single **row**.
 *
 * @since Core 1.1
 * @author Tassilo
 */
interface DynamicDataEntity {

    /**
     * Reads the data of this entity from the [DataInputStream].
     *
     * @param in the input stream
     * @throws IOException if an I/O error occurs, this shouldn't ever happen, however
     * methods of [DataInputStream] are able to throw IOExceptions per specification.
     */
    @Throws(IOException::class)
    fun load(input: DataInputStream)

    /**
     * Writes the data of this entity to the [DataOutputStream].
     *
     * @param out the output stream
     * @throws IOException if an I/O error occurs, this shouldn't ever happen, however
     * methods of [DataInputStream] are able to throw IOExceptions per specification.
     */
    @Throws(IOException::class)
    fun save(out: DataOutputStream)

}
