package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	Long id;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	String name;
	
	@NotNull
	@Size(min=5, message="Email must be at least 5 characters long")
	String email;
	
	public UserDto(Long id, String name, String email)
	{
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public UserDto()
	{
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
