package com.example.demo.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public void addNewCategory(Category category) {
		categoryRepository.save(category);
		
	}

	public void deleteCategory(Long categoryId) {
		boolean exists = categoryRepository.existsById(categoryId);
		if (!exists)
			throw new IllegalStateException("category with id " + categoryId + " does not exists");
		categoryRepository.deleteById(categoryId);
	}
	

}
