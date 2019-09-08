package com.mx.simlb.dto;

import java.io.Serializable;

public class Usuarios implements Serializable{

	private Long idCatUsuarios;
	private String codigoUsuario;
	private String puestoOcupado;
	private String estatusUsuario;
	private String fechaAlta;
	private String usuarioAlta;
	private String fechaActualizacion;
	private String usuarioActualizacion;
	
	public Long getIdCatUsuarios() {
		return idCatUsuarios;
	}
	public void setIdCatUsuarios(Long idCatUsuarios) {
		this.idCatUsuarios = idCatUsuarios;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getPuestoOcupado() {
		return puestoOcupado;
	}
	public void setPuestoOcupado(String puestoOcupado) {
		this.puestoOcupado = puestoOcupado;
	}
	public String getEstatusUsuario() {
		return estatusUsuario;
	}
	public void setEstatusUsuario(String estatusUsuario) {
		this.estatusUsuario = estatusUsuario;
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
