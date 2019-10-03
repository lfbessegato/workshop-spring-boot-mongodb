package com.example.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	
	/**
	 * Serial -> para permitir tráfego de rede e gravar em arquivo 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Atributos Básicos
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	//Construtores
	public StandardError() {
	}

	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	//Getters and Setters
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
