package dal.dal.interfases;

import dal.dal.models.Class;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Class, Long> {
}
