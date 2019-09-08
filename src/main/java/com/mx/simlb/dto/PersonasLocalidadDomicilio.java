package com.mx.simlb.dto;

import java.io.Serializable;

public class PersonasLocalidadDomicilio implements Serializable{

	private Long idPersonasLocalidadDomicilio;
	private Long idPersona;
	private Long idLocalidadDomicilio;
	
	public Long getIdPersonasLocalidadDomicilio() {
		return idPersonasLocalidadDomicilio;
	}
	public void setIdPersonasLocalidadDomicilio(Long idPersonasLocalidadDomicilio) {
		this.idPersonasLocalidadDomicilio = idPersonasLocalidadDomicilio;
	}
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public Long getIdLocalidadDomicilio() {
		return idLocalidadDomicilio;
	}
	public void setIdLocalidadDomicilio(Long idLocalidadDomicilio) {
		this.idLocalidadDomicilio = idLocalidadDomicilio;
	}
	
	
	
}
