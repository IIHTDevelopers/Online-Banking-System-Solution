package com.onlinebanking.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.onlinebanking.entity.Gender;

public class UserDTO {
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String username;
	
	@NotNull
	@Size(min = 3, max = 20)
	private String password;
	
	@NotNull
	@Min(18)
	@Max(99)
	private Integer age;
	
	@NotNull
	private Gender gender;

	public UserDTO() {
		super();
	}

	public UserDTO(Long id, @Size(min = 3, max = 20) String name, @Size(min = 3, max = 20) String username,
			@Size(min = 3, max = 20) String password, @Min(18) @Max(99) Integer age, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
