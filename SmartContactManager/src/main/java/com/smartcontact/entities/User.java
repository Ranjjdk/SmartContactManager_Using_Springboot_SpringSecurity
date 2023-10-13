package com.smartcontact.entities;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Users")
public class User {
	
	/*
	 *Here I am doing server side validation of parameters
	 * 
      */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Length(max = 25)
	private String name;
	
	@Column(unique =true)
	@Email
	private String email;
	
//	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,16}$",message = "password must contains uppercase,lowercase,special characters and numbers ")
	private String password;
	private boolean enabled;
	private String imageUrl;
	@Column(length=500)
	private String about;
	
	@ElementCollection(fetch= FetchType.EAGER)
	@CollectionTable(
			name="roles",
			joinColumns = @JoinColumn(name="user_id")
			)
	@Column(name="user_role")
	private List<String> roles;
	
//	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="user")
//	ArrayList<Contact> contacts=new ArrayList<Contact>();
//	
	
	public User() {
		
		super();
	}


	public int getId() {
		return id;
	}
	

//
//	public ArrayList<Contact> getContacts() {
//		return contacts;
//	}
//
//
//	public void setContacts(ArrayList<Contact> contacts) {
//		this.contacts = contacts;
//	}


	public void setId(int id) {
		this.id = id;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", enabled="
				+ enabled + ", imageUrl=" + imageUrl + ", about=" + about + ", roles=" + roles + "]";
	}


	


	

	
	

}