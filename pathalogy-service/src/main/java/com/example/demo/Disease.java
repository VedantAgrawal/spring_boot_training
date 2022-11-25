package com.example.demo;

public class Disease {

	public Disease() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String description;
	private String Treatment;
	
	public Disease(String id, String description, String treatment) {
		super();
		this.id = id;
		this.description = description;
		Treatment = treatment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTreatment() {
		return Treatment;
	}

	public void setTreatment(String treatment) {
		Treatment = treatment;
	}

	@Override
	public String toString() {
		return "Disease [id=" + id + ", description=" + description + ", Treatment=" + Treatment + "]";
	}
	
	
	
}
