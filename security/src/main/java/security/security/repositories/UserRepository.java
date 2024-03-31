package security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import security.security.models.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
