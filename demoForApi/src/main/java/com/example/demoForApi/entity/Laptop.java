package com.example.demoForApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String laptopName;
	private Double laptopPrice;
	private String laptopDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public Double getLaptopPrice() {
		return laptopPrice;
	}
	public void setLaptopPrice(Double laptopPrice) {
		this.laptopPrice = laptopPrice;
	}
	public String getLaptopDescription() {
		return laptopDescription;
	}
	public void setLaptopDescription(String laptopDescription) {
		this.laptopDescription = laptopDescription;
	}
	
	
	public Laptop(int id, String laptopName, Double laptopPrice, String laptopDescription) {
		super();
		this.id = id;
		this.laptopName = laptopName;
		this.laptopPrice = laptopPrice;
		this.laptopDescription = laptopDescription;
	}
	
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", laptopName=" + laptopName + ", laptopPrice=" + laptopPrice
				+ ", laptopDescription=" + laptopDescription + "]";
	}
	
	
	
	
	

}
