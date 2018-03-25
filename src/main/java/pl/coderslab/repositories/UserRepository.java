package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);

}
