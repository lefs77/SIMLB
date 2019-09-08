package com.mx.simlb.dto;

import java.io.Serializable;

public class LocalidadDomicilio implements Serializable{

	private String idLocalidadDomicilio;
	private String idCatLocalidad;
	private String idCatDomicilio;
	
	public String getIdLocalidadDomicilio() {
		return idLocalidadDomicilio;
	}
	public void setIdLocalidadDomicilio(String idLocalidadDomicilio) {
		this.idLocalidadDomicilio = idLocalidadDomicilio;
	}
	public String getIdCatLocalidad() {
		return idCatLocalidad;
	}
	public void setIdCatLocalidad(String idCatLocalidad) {
		this.idCatLocalidad = idCatLocalidad;
	}
	public String getIdCatDomicilio() {
		return idCatDomicilio;
	}
	public void setIdCatDomicilio(String idCatDomicilio) {
		this.idCatDomicilio = idCatDomicilio;
	}
	
	
}
