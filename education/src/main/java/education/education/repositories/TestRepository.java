package education.education.repositories;

import education.education.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This interface extends JpaRepository for managing Test entities.
 */
public interface TestRepository extends JpaRepository<Test, Integer> {
    /**
     * Retrieves an optional Test entity by its ID.
     *
     * @param id The ID of the test to retrieve.
     * @return An Optional containing the Test entity if found, otherwise empty.
     */
    Optional<Test> findById(int id);
}
