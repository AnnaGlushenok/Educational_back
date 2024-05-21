package create.create.repositories;

import create.create.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /**
     * Checks if a Question entity with the specified question exists in the database.
     *
     * @param question The question of the Question entity to check.
     * @return true if a Question entity with the specified name exists in the database, otherwise false.
     */
    boolean existsByQuestion(String question);

    /**
     * Checks if a Question entity with the specified id exists in the database.
     *
     * @param id The id of the Question entity to check.
     * @return true if a Question entity with the specified id exists in the database, otherwise false.
     */
    boolean existsById(int id);
}
