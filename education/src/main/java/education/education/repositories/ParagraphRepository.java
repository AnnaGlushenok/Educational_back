package education.education.repositories;

import education.education.models.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParagraphRepository extends JpaRepository<Paragraph, Integer> {
    Optional<Paragraph> findById(int id);
}
