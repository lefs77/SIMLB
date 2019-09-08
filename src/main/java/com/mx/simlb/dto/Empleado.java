package com.mx.simlb.dto;

import java.io.Serializable;

public class Empleado implements Serializable{

	private Long idCatEmpleado;
	private Long idCatLocalidad;
	private String claveEmpleado;
	private String estatusEmpleado;
	private String fechaAlta;
	private String usuarioAlta;
	private String fechaActualizacion;
	private String usuarioActualizacion;
	
	
	public Long getIdCatEmpleado() {
		return idCatEmpleado;
	}
	public void setIdCatEmpleado(Long idCatEmpleado) {
		this.idCatEmpleado = idCatEmpleado;
	}
	public Long getIdCatLocalidad() {
		return idCatLocalidad;
	}
	public void setIdCatLocalidad(Long idCatLocalidad) {
		this.idCatLocalidad = idCatLocalidad;
	}
	public String getClaveEmpleado() {
		return claveEmpleado;
	}
	public void setClaveEmpleado(String claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}
	public String getEstatusEmpleado() {
		return estatusEmpleado;
	}
	public void setEstatusEmpleado(String estatusEmpleado) {
		this.estatusEmpleado = estatusEmpleado;
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
