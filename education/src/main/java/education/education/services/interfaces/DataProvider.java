package education.education.services.interfaces;

import java.util.List;

/**
 * The DataProvider interface provides methods for accessing data of a specific type T.
 * Classes implementing this interface provide functionality to retrieve a list of all objects of type T
 * and to find an object of type T by its identifier.
 *
 * @param <T> the type of objects that the DataProvider works with
 */
public interface DataProvider<T> {
    /**
     * Retrieves a list of all objects of type T.
     *
     * @return a list of all objects of type T
     */
    List<T> findAll();

    /**
     * Finds an object of type T by its identifier.
     *
     * @param id the identifier of the object of type T
     * @return the found object of type T, or null if the object is not found
     */
    T findById(int id);
}
