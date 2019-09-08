package com.mx.simlb.dto;

import java.io.Serializable;

public class RegistrarPersona implements Serializable {

	private String nombre;
	private String nombre2;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombreCompleto;
	private String sexo;
	private String estatusPersona;
	private String rol;
	private String telefono;
	private String telefono2;
	private String codigoPostal; 
	private String municipio;
	private String idLocalidadDomicilio;
	private String calle;
	private String numeroInt;
	private String numeroExt;
	
	//campos de usuario
	private String codigoUsuario;
	private String puestoOcupado;
	
	//campos de cliente
	private String claveCliente;
	//campos de empleado
	private String claveEmpleado;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstatusPersona() {
		return estatusPersona;
	}
	public void setEstatusPersona(String estatusPersona) {
		this.estatusPersona = estatusPersona;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getIdLocalidadDomicilio() {
		return idLocalidadDomicilio;
	}
	public void setIdLocalidadDomicilio(String idLocalidadDomicilio) {
		this.idLocalidadDomicilio = idLocalidadDomicilio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroInt() {
		return numeroInt;
	}
	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}
	public String getNumeroExt() {
		return numeroExt;
	}
	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
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
	public String getClaveCliente() {
		return claveCliente;
	}
	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}
	public String getClaveEmpleado() {
		return claveEmpleado;
	}
	public void setClaveEmpleado(String claveEmpleado) {
		this.claveEmpleado = claveEmpleado;
	}
	
}
