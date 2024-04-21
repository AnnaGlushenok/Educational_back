package education.education.services.interfaces;

import java.util.List;

/**
 * @param <T> is return type
 * @param <U> is received type
 */
public interface Mapper<T, U> {
    T toDTO(U u);

    List<T> listToDTO(List<U> u);
}
