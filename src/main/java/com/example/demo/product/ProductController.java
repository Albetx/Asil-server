package com.example.demo.product;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(path = "api/v1/products")

public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController (ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping 
	public List<Product> getproducts() {
		return productService.getProducts();
	}
	
	@GetMapping(path = "{id}")
	public Product getProductById(@PathVariable("id") String id){
	    return productService.getProductById(Long.parseLong(id));
	}
	
	@GetMapping(path = "/category/{category}")
	public List<Product> getProductsByCategory(@PathVariable("category") String category){
	    return productService.getProductsByCategory(category);
	}
	
	@PostMapping
	public void registerNewproduct (@RequestBody Product product) {
		productService.addNewProduct(product);
	}
	
	@DeleteMapping(path = "{productId}")
	public void deleteproduct(@PathVariable("productId") Long productId) {
		productService.deleteproduct(productId);
	}
	
	@CrossOrigin
	@PutMapping(path = "{productId}")
	public void updateproduct (@RequestBody Product product) {
		productService.updateProduct(product.getId(),product.getName() , product.getContent(), product.getLikes());
	}
	
	
}
