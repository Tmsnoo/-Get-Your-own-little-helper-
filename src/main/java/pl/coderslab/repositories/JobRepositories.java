package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Entity.Job;

public interface JobRepositories extends JpaRepository<Job, Long> {
	

}
