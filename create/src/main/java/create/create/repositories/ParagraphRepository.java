package create.create.repositories;

import create.create.models.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * This interface extends the JpaRepository interface for managing Paragraph entities.
 */
public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
    /**
     * Retrieves an optional Paragraph entity by its ID.
     *
     * @param id The ID of the paragraph to retrieve.
     * @return An Optional containing the Paragraph entity if found, otherwise empty.
     */
    Optional<Paragraph> findById(int id);
}
