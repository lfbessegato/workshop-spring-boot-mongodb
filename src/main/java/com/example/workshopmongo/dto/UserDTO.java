package com.example.workshopmongo.dto;

import java.io.Serializable;

import com.example.workshopmongo.domain.User;

public class UserDTO implements Serializable{
	
	/**
	 * Serial -> para permitir tráfego de rede e gravar em arquivo 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private String id;
	private String name;
	private String email;
	
	//Construtores
	public UserDTO() {
	}
	
	//Construtor para instanciar a partir do Objeto Entity
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	
	//Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	

}
