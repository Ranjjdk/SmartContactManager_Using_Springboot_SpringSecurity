package com.smartcontact.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_passwd")
	private String password;
	
	@Column(name="user_email")
	private String email;
	
	@ElementCollection(fetch= FetchType.EAGER)
	@CollectionTable(
			name="roles",
			joinColumns = @JoinColumn(name="user_id")
			)
	@Column(name="user_role")
	private List<String> roles;
	
	public User() 
	{
		
	}
	

	public User(Integer id, String name, String password, String email, List<String> roles) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", roles=" + roles
				+ "]";
	}
	
	
	
	
	
}