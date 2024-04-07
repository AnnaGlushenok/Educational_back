package education.education.repositories;

import education.education.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassRepository extends JpaRepository<Class, Integer> {
    Optional<Class> findById(int id);
}
