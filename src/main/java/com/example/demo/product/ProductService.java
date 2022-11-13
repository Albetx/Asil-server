package com.example.demo.product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductById (long productId) {
		boolean exists = productRepository.existsById(productId);
		if (!exists)
			throw new IllegalStateException("Product with id " + productId + " does not exists");
		return productRepository.getById(productId);
	}
	
	public List<Product> getProductsByCategory(String category){
		return productRepository.findByCategory_nameOrderByCreateDate(category);

	}

	public void addNewProduct(Product product) {
		productRepository.save(product);
		
	}

	public void deleteproduct(Long productId) {
		boolean exists = productRepository.existsById(productId);
		if (!exists)
			throw new IllegalStateException("Product with id " + productId + " does not exists");
		productRepository.deleteById(productId);
	}
	
	@Transactional
	public void updateProduct(Long productId, String name, String content, Long likes) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("Product with id  " + productId + " does not exists"));
		
		if (name != null)
			product.setName(name);
		if (content != null)
			product.setContent(content);
		if (likes != null) 
			product.setLikes(likes);
		
	}
	
	
}
 