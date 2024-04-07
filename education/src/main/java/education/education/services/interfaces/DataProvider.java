package education.education.services.interfaces;

import java.util.List;

public interface DataProvider<T> {
    List<T> findAll();

    T findById(int id);
}
