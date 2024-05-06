package create.create.repositories;

import create.create.models.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository for managing Unit entities.
 */
public interface UnitRepository extends JpaRepository<Unit, Integer> {
    /**
     * Checks if a Unit entity with the specified name exists in the database.
     *
     * @param name The name of the Unit entity to check.
     * @return true if a Unit entity with the specified name exists in the database, otherwise false.
     */
    boolean existsByName(String name);

    /**
     * Checks if a Unit entity with the specified id exists in the database.
     *
     * @param id The id of the Unit entity to check.
     * @return true if a Unit entity with the specified id exists in the database, otherwise false.
     */
    boolean existsById(int id);
}
