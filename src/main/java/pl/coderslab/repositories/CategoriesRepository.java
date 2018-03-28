package pl.coderslab.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Entity.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
	Category findById(Long id);
}
