package com.tiendaOnline.rest.api.models.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Usuario implements Serializable{


	private static final long serialVersionUID = -139463164435329964L;
	
	
	@Id
	@Column(name = "nombreusuario",unique = true)
	private String nombreusuario;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	public Usuario() {
	}
	public Usuario(String nombreusuario, String password, String email) {
		this.nombreusuario = nombreusuario;
		this.password = password;
		this.email = email;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
