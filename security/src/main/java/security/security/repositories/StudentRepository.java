package security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import security.security.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
