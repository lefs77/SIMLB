package com.mx.simlb.vo;

import java.io.Serializable;

public class HorariosPivoteVO implements Serializable{

	private Long idHorariosDisponibles;
	private String horario;
	private String nombrePersona;
	private String fecha;
	private String horaIni;
	private String horaFin;
	
	public Long getIdHorariosDisponibles() {
		return idHorariosDisponibles;
	}
	public void setIdHorariosDisponibles(Long idHorariosDisponibles) {
		this.idHorariosDisponibles = idHorariosDisponibles;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	
}
