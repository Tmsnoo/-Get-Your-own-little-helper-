package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {

	public List<String> categories = new ArrayList<>();
	public CategoryList() {
		this.categories.add("Sprzatanie");
		this.categories.add("Malowanie");
		this.categories.add("Ogrodowe");
		this.categories.add("Remontowe");
		this.categories.add("Transportowe");
		this.categories.add("Inne");
	}
}
