package spring.hateos.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hateos.test.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
