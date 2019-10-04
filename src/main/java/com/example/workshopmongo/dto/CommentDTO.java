package com.example.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
	
	/**
	 * Serial -> para permitir tráfego de rede e gravar em arquivo
	 * Não precisa implementar o HashCode no DTO
	 */
	
	private static final long serialVersionUID = 1L;
	//Atributos Básicos
	private String text;
	private Date date;
	private AuthorDTO author;
	
	//Construtores
	public CommentDTO() {
	}

	public CommentDTO(String text, Date date, AuthorDTO author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	//Getters and Setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	

}
