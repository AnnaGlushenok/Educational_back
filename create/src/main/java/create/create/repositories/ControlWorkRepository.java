package create.create.repositories;

import create.create.models.ControlWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ControlWorkRepository extends JpaRepository<ControlWork, Integer> {

}
