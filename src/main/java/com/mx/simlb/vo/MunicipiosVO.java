package com.mx.simlb.vo;

import java.io.Serializable;

public class MunicipiosVO implements Serializable{

	public Long idCatLocalidad;
	public String claveLocalidad;
	public String descripcionLocalidad;
	public String estatusLocalidad;
	public String fechaAlta;
	public String usuarioAlta;
	public String fechaActualizacion;
	public String usuarioActualizacion;
	
	public Long getIdCatLocalidad() {
		return idCatLocalidad;
	}
	public void setIdCatLocalidad(Long idCatLocalidad) {
		this.idCatLocalidad = idCatLocalidad;
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
