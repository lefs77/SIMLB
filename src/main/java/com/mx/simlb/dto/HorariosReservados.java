package com.mx.simlb.dto;

import java.io.Serializable;

public class HorariosReservados implements Serializable{

	private Long idHorariosReservados;
	private Long idHorariosDisponiblesIni;
	private Long idHorariosDisponiblesFin;
	private Long idReservaciones;
	
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
	public Long getIdReservaciones() {
		return idReservaciones;
	}
	public void setIdReservaciones(Long idReservaciones) {
		this.idReservaciones = idReservaciones;
	}
	
	
	
}
