package com.mx.simlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horarios_disponibles")
public class HorariosDisponibles 
implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_Horarios_Disponibles", nullable=false)
	private Long idHorariosDisponibles;
	
	@Column(name="horario", nullable=false)
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

