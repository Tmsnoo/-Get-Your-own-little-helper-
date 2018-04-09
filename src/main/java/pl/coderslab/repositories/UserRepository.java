package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
    void delete(User user);
	User findOneByEmail(String email);

}
