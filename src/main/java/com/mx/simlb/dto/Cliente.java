package com.mx.simlb.dto;

import java.io.Serializable;

public class Cliente implements Serializable{

	private Long idCatCliente;
	private Long idCatEmpleado;
	private String claveCliente;
	private String estatusCliente;
	private String fechaAlta;
	private String usuarioAlta;
	private String fechaActualizacion;
	private String usuarioActualizacion;
	
	public Long getIdCatCliente() {
		return idCatCliente;
	}
	public void setIdCatCliente(Long idCatCliente) {
		this.idCatCliente = idCatCliente;
	}
	public Long getIdCatEmpleado() {
		return idCatEmpleado;
	}
	public void setIdCatEmpleado(Long idCatEmpleado) {
		this.idCatEmpleado = idCatEmpleado;
	}
	public String getClaveCliente() {
		return claveCliente;
	}
	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}
	public String getEstatusCliente() {
		return estatusCliente;
	}
	public void setEstatusCliente(String estatusCliente) {
		this.estatusCliente = estatusCliente;
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
