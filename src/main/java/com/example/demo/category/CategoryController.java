package com.example.demo.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController (CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping 
	public List<Category> getcategorys() {
		return categoryService.getCategories();
	}
	
	@PostMapping
	public void registerNewcategory (@RequestBody Category category) {
		categoryService.addNewCategory(category);
	}
	
	@DeleteMapping(path = "{categoryId}")
	public void deletecategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}

}
