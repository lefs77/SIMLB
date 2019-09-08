package com.mx.simlb.vo;

import java.io.Serializable;

public class HorariosReservadosVO implements Serializable{

	private Long idHorariosReservados;
	private Long idHorariosDisponiblesIni;
	private Long idHorariosDisponiblesFin;
	private Long reservaciones;
	
	
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
	public Long getReservaciones() {
		return reservaciones;
	}
	public void setReservaciones(Long reservaciones) {
		this.reservaciones = reservaciones;
	}
	
	
}
