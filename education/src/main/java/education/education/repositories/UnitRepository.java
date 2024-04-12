package education.education.repositories;

import education.education.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Optional<Unit> findById(int id);

    List<Unit> findAllBySubjectIdAndClassEntityId(int subjectId, int classId);
}
