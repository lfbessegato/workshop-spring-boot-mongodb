package com.example.workshopmongo.dto;

import java.io.Serializable;

import com.example.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{
	
	/**
	 * Serial -> para permitir tráfego de rede e gravar em arquivo
	 * Não precisa implementar o HashCode no DTO
	 */
	private static final long serialVersionUID = 1L;
	//Atributos Básicos
	private String id;
	private String name;
	
	//Construtores
	public AuthorDTO() {
	}
	
	public AuthorDTO(User obj) {
		//Copiar as informações
		id = obj.getId();
		name = obj.getName();
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
	
	

}
