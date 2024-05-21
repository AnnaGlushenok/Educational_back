package create.create.repositories;

import create.create.dtos.ParagraphDTO;
import create.create.models.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends the JpaRepository interface for managing Paragraph entities.
 */
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
    /**
     * Checks if a Paragraph entity with the specified id exists in the database.
     *
     * @param id The id of the Paragraph entity to check.
     * @return true if a Paragraph entity with the specified id exists in the database, otherwise false.
     */
    boolean existsById(int id);
}
