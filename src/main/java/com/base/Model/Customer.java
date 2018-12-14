package com.base.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "customer")
public class Customer {
 
	@Id
	
	private long id;
 
	@Column(name = "name")
	private String name;
 
	@Column(name = "age")
	private int age;
 
	@Column(name = "active")
	private boolean active;
 
	public Customer() {
	}
 
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
		this.active = false;
	}
 
	public Customer(long id, String name, int age,boolean active) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.active = active;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", active=" + active + "]";
	}
}