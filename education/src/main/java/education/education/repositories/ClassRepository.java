package education.education.repositories;

import education.education.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {
}
