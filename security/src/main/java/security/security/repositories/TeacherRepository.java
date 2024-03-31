package security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import security.security.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
