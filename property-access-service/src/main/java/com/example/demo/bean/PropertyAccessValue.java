package com.example.demo.bean;

public class PropertyAccessValue {

	public PropertyAccessValue() {
		// TODO Auto-generated constructor stub
	}
	
	String name;
	String description;
	public PropertyAccessValue(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	@Override
	public String toString() {
		return "propertyAccessValue [name=" + name + ", description=" + description + "]";
	}
	
	
}
