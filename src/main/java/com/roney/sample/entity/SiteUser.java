package com.roney.sample.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SiteUser {

	@Id
	@GeneratedValue
	private int userId;
	
	private String name;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<CustomerOrder> orders;
	
	public SiteUser() {
		// TODO Auto-generated constructor stub
	}
	

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SiteUser(int userId, String name, List<CustomerOrder> orders) {
		super();
		this.userId = userId;
		this.name = name;
		this.orders = orders;
	}
	
	

	
	
}
