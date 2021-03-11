package com.tiendaOnline.rest.api.models.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigoproducto",unique = true)
	private Integer codigoproducto;
	
	@Column(name = "nombretitulo")
	private String nombretitulo;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "precio")
	private double precio;
	
	
	public Producto() {
	}


	public Producto(Integer codigoproducto, String nombretitulo, String imagen, double precio) {

		this.codigoproducto = codigoproducto;
		this.nombretitulo = nombretitulo;
		this.imagen = imagen;
		this.precio = precio;
	}


	public Integer getCodigoproducto() {
		return codigoproducto;
	}


	public void setCodigoproducto(Integer codigoproducto) {
		this.codigoproducto = codigoproducto;
	}


	public String getNombretitulo() {
		return nombretitulo;
	}


	public void setNombretitulo(String nombretitulo) {
		this.nombretitulo = nombretitulo;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}