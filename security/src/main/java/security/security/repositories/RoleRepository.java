package security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import security.security.models.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
