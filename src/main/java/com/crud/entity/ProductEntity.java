package com.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntity {

	public static final String HttpStatus = null;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_description")
	private String description;
	
	@Column(name="product_price")
	private String price;
	
	@Column(name="product_status")
	private String status;

	@Column(name="status")
	private Boolean product_status;
	public ProductEntity() {
		super();
	}

	public ProductEntity(long id, String name, String description, String price, String status,Boolean product_status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.product_status=product_status;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public void setProduct_status(Boolean product_status) {
		this.product_status = product_status;
	}
	public Boolean getProduct_status() {
		return product_status;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", status=" + status + ", product_status=" + product_status + "]";
	}

	
	
	
}
