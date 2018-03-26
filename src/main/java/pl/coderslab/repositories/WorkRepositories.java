package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Entity.Work;

public interface WorkRepositories extends JpaRepository<Work, Long> {
	

}
