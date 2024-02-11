package model;

import java.time.LocalDateTime;

public class User {
	int id;
	String name;
	String email;
	String password;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public User() {
		
	}

	public User(int id, String name,String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}
