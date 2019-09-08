package com.mx.simlb.dto;

import java.io.Serializable;

public class Colonias implements Serializable {

	private Long idLocalidadDomicilio;
	private String claveLocalidad;
	private String descripcionLocalidad;
	private String estatusLocalidad;
	private String colonia;
	private String calle;
	private String estatusDomicilio;
	private String fechaAlta;
	private String usuarioAlta;
	private String fechaActualizacion;
	private String usuarioActualizacion;
	
	
	public Long getIdLocalidadDomicilio() {
		return idLocalidadDomicilio;
	}
	public void setIdLocalidadDomicilio(Long idLocalidadDomicilio) {
		this.idLocalidadDomicilio = idLocalidadDomicilio;
	}
	public String getClaveLocalidad() {
		return claveLocalidad;
	}
	public void setClaveLocalidad(String claveLocalidad) {
		this.claveLocalidad = claveLocalidad;
	}
	public String getDescripcionLocalidad() {
		return descripcionLocalidad;
	}
	public void setDescripcionLocalidad(String descripcionLocalidad) {
		this.descripcionLocalidad = descripcionLocalidad;
	}
	public String getEstatusLocalidad() {
		return estatusLocalidad;
	}
	public void setEstatusLocalidad(String estatusLocalidad) {
		this.estatusLocalidad = estatusLocalidad;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getEstatusDomicilio() {
		return estatusDomicilio;
	}
	public void setEstatusDomicilio(String estatusDomicilio) {
		this.estatusDomicilio = estatusDomicilio;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}	
}
