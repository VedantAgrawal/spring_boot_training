package com.example.demo.pojo;

import java.util.Date;;

public class User {

	private int id;
	private String name;
	private Date d;
	
	public User(int id, String name, Date d) {
		super();
		this.id = id;
		this.name = name;
		this.d = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	
}
