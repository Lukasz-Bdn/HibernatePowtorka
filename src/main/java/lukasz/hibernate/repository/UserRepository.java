package lukasz.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lukasz.hibernate.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
