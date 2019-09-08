package com.mx.simlb.dto;

import java.io.Serializable;

public class Personas implements Serializable {

	private Long idPersona;
	private String nombreUno;
	private String nombreDos;
	private String apePaterno;
	private String apeMaterno;
	
	private String nombreCompleto;
	private String codigoPostal;
	private String sexo;
	private Long numeroInt;
	private Long numeroExt;
	private String estatusPersona;
	private String telefonoUno;
	private String telefonoDos;
	private String rolPersona;
	private String fechaAlta;
	private String usuarioAlta;
	private String fechaActualizacion;
	private String usuarioActualizacion;
	
	private Cliente cliente;
	private Empleado empleado;
	private Usuarios usuarios;
	
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombreUno() {
		return nombreUno;
	}
	public void setNombreUno(String nombreUno) {
		this.nombreUno = nombreUno;
	}
	public String getNombreDos() {
		return nombreDos;
	}
	public void setNombreDos(String nombreDos) {
		this.nombreDos = nombreDos;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Long getNumeroInt() {
		return numeroInt;
	}
	public void setNumeroInt(Long numeroInt) {
		this.numeroInt = numeroInt;
	}
	public Long getNumeroExt() {
		return numeroExt;
	}
	public void setNumeroExt(Long numeroExt) {
		this.numeroExt = numeroExt;
	}
	public String getEstatusPersona() {
		return estatusPersona;
	}
	public void setEstatusPersona(String estatusPersona) {
		this.estatusPersona = estatusPersona;
	}
	public String getTelefonoUno() {
		return telefonoUno;
	}
	public void setTelefonoUno(String telefonoUno) {
		this.telefonoUno = telefonoUno;
	}
	public String getTelefonoDos() {
		return telefonoDos;
	}
	public void setTelefonoDos(String telefonoDos) {
		this.telefonoDos = telefonoDos;
	}
	public String getRolPersona() {
		return rolPersona;
	}
	public void setRolPersona(String rolPersona) {
		this.rolPersona = rolPersona;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}
	
}
