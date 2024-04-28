package education.education.repositories;

import education.education.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * This interface extends JpaRepository for managing Unit entities.
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    /**
     * Retrieves a list of Unit entities based on the given subject ID and class ID.
     *
     * @param subjectId The ID of the subject.
     * @param classId   The ID of the class.
     * @return A list of Unit entities that belong to the specified subject and class.
     */
    List<Unit> findAllBySubjectIdAndClassEntityId(int subjectId, int classId);
}
