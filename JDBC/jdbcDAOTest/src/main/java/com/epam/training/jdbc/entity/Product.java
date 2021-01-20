package com.epam.training.jdbc.entity;

import java.util.Date;

public class Product {
	private long id;
	private String name;
	private String description;
	private int amount;
	private double price;
	private long categoryId;
	private Date createDate;
	private Date lastUpdate;

	static public Product createProduct(String name, int amount, double price) {
		Product p = new Product();
		p.setName(name);
		p.setAmount(amount);
		p.setPrice(price);
		return p;
	}

	public long getId() {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount
				+ ", price=" + price + ", categoryId=" + categoryId + ", create_date=" + createDate
				+ ", last_update=" + lastUpdate + "]";
	}

}
