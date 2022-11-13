package com.example.demo.category;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@SequenceGenerator(
			name = "category_sequence",
			sequenceName = "category_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "category_sequence"
	)
	private int category_id;
	
	private String name;
	private String img;
	
	@OneToMany(
			mappedBy = "category",
			targetEntity = Product.class,
			cascade = CascadeType.ALL
			)
	private List<Product> products = new ArrayList<>();
	
	
	
	public Category() {
	}


	public Category(String name, String img) {
		this.name = name;
		this.img = img;
	}


	public String getName() {
		return name;
	}


	public String getImg() {
		return img;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setImg(String img) {
		this.img = img;
	}

	
	
	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	@Override
	public String toString() {
		return "Category [id=" + category_id + ", name=" + name + ", img=" + img + "]";
	}
	
	
	
	
}
