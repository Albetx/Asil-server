package com.example.demo.product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.category.Category;
import com.example.demo.category.CategoryRepository;

@Configuration
public class ProductConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository repositry, CategoryRepository cat_repo) {
		return args -> {
			
			Category cat = new Category("Mult", "img");
			
			Product hondaMultimedia1 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			Product hondaMultimedia2 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			Product hondaMultimedia3 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			Product hondaMultimedia4 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			Product hondaMultimedia5 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			Product hondaMultimedia6 = new Product(cat, "Honda Civic 8 2005 - 2012 Multimedia", 81.53, LocalDate.of(2000, Month.AUGUST, 5), 1, 0L,"Honda Civic 8 2005 - 2012 Multimedia", "assets/images/honda.JPG", "ali.baba", "abcde");
			
			
			repositry.saveAll(List.of(hondaMultimedia1, hondaMultimedia2, hondaMultimedia3, hondaMultimedia4, hondaMultimedia5, hondaMultimedia6));
		};
	}

}
