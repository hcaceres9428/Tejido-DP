package com.edu.sena.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuario")
public class Usuario {
	@Id
	@Column(name= "id_user")
	private Long id;
	
	@Column(name= "nom_user")
	private String username;
	
	@Column(name= "cont_user")
	
	private String password;

	public Usuario(Long id, String username, String password) {
	
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Usuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
