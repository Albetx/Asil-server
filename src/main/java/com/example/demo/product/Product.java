package com.example.demo.product;

import java.time.LocalDate;

import com.example.demo.category.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table
public class Product {
	@Id
	@SequenceGenerator(
			name = "product_sequence",
			sequenceName = "product_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence"
	)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	private String name;
	private double price;
	private LocalDate createDate;
	private int creatorId;
	private Long likes;
	private String content;
	private String img;
	private String link;
	private String cupon;
	
	

	public Product(Category category, String name, double price, LocalDate createDate, int creatorId, Long likes,
			String content, String img, String link, String cupon) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.createDate = createDate;
		this.creatorId = creatorId;
		this.likes = likes;
		this.content = content;
		this.img = img;
		this.link = link;
		this.cupon = cupon;
	}




	public String getLink() {
		return link;
	}




	public String getCupon() {
		return cupon;
	}




	public void setLink(String link) {
		this.link = link;
	}




	public void setCupon(String cupon) {
		this.cupon = cupon;
	}




	public Category getCategory() {
		return category;
	}




	public String getContent() {
		return content;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public Product() {
	}

	

	
	public int getCreatorId() {
		return creatorId;
	}


	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}


	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public Long getLikes() {
		return likes;
	}
	public String getImg() {
		return img;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public void setImg(String img) {
		this.img = img;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + ", createDate="
				+ createDate + ", creatorId=" + creatorId + ", likes=" + likes + ", content=" + content + ", img=" + img
				+ ", link=" + link + ", cupon=" + cupon + "]";
	}





	
	

	
	
	
	
}
