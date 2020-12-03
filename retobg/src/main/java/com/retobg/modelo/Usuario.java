package com.retobg.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;



//CREACION DEL MODELO DE LA BASE DE DATOS LLAMADA PRUEBASBG
//CREACION DEL ENTITY
@Entity
public class Usuario {

	@Id
	private Integer id;
	
	@Column
	private String nombre;

	//METODOS GET Y SET
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
