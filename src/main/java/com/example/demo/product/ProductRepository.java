package com.example.demo.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.category.Category;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory_nameOrderByCreateDate (String category);
}
