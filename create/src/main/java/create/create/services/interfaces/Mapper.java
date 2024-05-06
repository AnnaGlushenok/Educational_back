package create.create.services.interfaces;

import java.util.List;

/**
 * The Mapper interface defines methods for mapping objects of type U to DTOs (Data Transfer Objects) of type T.
 *
 * @param <T> is return type
 * @param <U> is received type
 */
public interface Mapper<T, U> {
    /**
     * Maps an object of type U to a DTO of type T.
     *
     * @param u the object of type U to be mapped to a DTO
     * @return the DTO of type T representing the object
     */
    T toDTO(U u);

    /**
     * Maps a list of objects of type U to a list of DTOs of type T.
     *
     * @param list the list of objects of type U to be mapped to DTOs
     * @return a list of DTOs of type T representing the objects
     */
    List<T> listToDTO(List<U> list);

    /**
     * Maps an object of type T to an Entity of type U.
     *
     * @param t the object of type T to be mapped to an Entity
     * @return the Entity of type U representing the DTO
     */
    U toEntity(T t);

    /**
     * Maps a list of objects of type T to a list of Entities of type U.
     *
     * @param list the list of objects of type T to be mapped to Entities
     * @return a list of Entities of type U representing the objects
     */
    List<U> listToEntity(List<T> list);
}
