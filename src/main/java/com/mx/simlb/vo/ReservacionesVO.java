package com.mx.simlb.vo;

import java.io.Serializable;

public class ReservacionesVO  implements Serializable{

	private Long idReservaciones;
	private String nombrePersona;
	private String fechaReservada;
	private String motivo;
	private String horaIni;
	private String horaFin;
	private Long idHorariosReservados;
	private Long idHorariosDisponiblesIni;
	private Long idHorariosDisponiblesFin;
		
	public Long getIdReservaciones() {
		return idReservaciones;
	}
	public void setIdReservaciones(Long idReservaciones) {
		this.idReservaciones = idReservaciones;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getFechaReservada() {
		return fechaReservada;
	}
	public void setFechaReservada(String fechaReservada) {
		this.fechaReservada = fechaReservada;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public Long getIdHorariosReservados() {
		return idHorariosReservados;
	}
	public void setIdHorariosReservados(Long idHorariosReservados) {
		this.idHorariosReservados = idHorariosReservados;
	}
	public Long getIdHorariosDisponiblesIni() {
		return idHorariosDisponiblesIni;
	}
	public void setIdHorariosDisponiblesIni(Long idHorariosDisponiblesIni) {
		this.idHorariosDisponiblesIni = idHorariosDisponiblesIni;
	}
	public Long getIdHorariosDisponiblesFin() {
		return idHorariosDisponiblesFin;
	}
	public void setIdHorariosDisponiblesFin(Long idHorariosDisponiblesFin) {
		this.idHorariosDisponiblesFin = idHorariosDisponiblesFin;
	}
}
