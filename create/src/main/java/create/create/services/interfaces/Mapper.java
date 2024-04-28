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
}
