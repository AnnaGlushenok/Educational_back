package education.education.services.interfaces;

/**
 * @param <T> is return type
 * @param <U> is received type
 */
public interface Mapper<T, U> {
    T toDTO(U u);
}
