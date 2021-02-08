package net.proxzi.database;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * A dynamic data entity is an object that is converted to a byte array, which is directly
 * stored in a single column in an SQL database. This does not allow for making selective
 * queries with respect to properties of a dynamic data entity, but allows for different
 * dynamic data entities to be used on a per-row basis.<br/><br/>
 *
 * <b>Note:</b> Unlike DataEntities, DynamicDataEntities are stored in a single
 * <strong>column</strong> and not a single <strong>row</strong>.
 *
 * @since Core 1.0
 * @author Tassilo
 */
public interface DynamicDataEntity {

	/**
	 * Reads the data of this entity from the {@link DataInputStream}.
	 *
	 * @param in the input stream
	 * @throws IOException if an I/O error occurs, this shouldn't ever happen, however
	 * methods of {@link DataInputStream} are able to throw IOExceptions per specification.
	 */
	void load(DataInputStream in) throws IOException;

	/**
	 * Writes the data of this entity to the {@link DataOutputStream}.
	 *
	 * @param out the output stream
	 * @throws IOException if an I/O error occurs, this shouldn't ever happen, however
	 * methods of {@link DataInputStream} are able to throw IOExceptions per specification.
	 */
	void save(DataOutputStream out) throws IOException;



	/**
	 * Represents an empty data set.
	 */
	interface IEmpty extends DynamicDataEntity {

		@Override
		default void load(DataInputStream dataInputStream) {
		}

		@Override
		default void save(DataOutputStream dataOutputStream) {
		}

	}



	/**
	 * Represents an empty data set.
	 */
	class Empty implements IEmpty {
	}

	/**
	 * Represents an empty data set.
	 */
	Empty EMPTY = new Empty();

}
