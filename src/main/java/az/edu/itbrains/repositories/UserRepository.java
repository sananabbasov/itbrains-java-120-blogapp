package az.edu.itbrains.repositories;

import az.edu.itbrains.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
