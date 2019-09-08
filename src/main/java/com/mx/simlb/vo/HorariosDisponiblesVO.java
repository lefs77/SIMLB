package com.mx.simlb.vo;

import java.io.Serializable;

public class HorariosDisponiblesVO implements Serializable{

	private Long idHorariosDisponibles;
	private String horario;
	
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
	
	
}
