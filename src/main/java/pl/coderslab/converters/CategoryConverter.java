package pl.coderslab.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.Entity.Category;
import pl.coderslab.repositories.CategoriesRepository;

public class CategoryConverter implements Converter<String, Category>{

	@Autowired
	CategoriesRepository categRepo;
	@Override
	public Category convert(String id) {
		Category category = categRepo.findById(Long.parseLong(id));
		return category;
	}
}



