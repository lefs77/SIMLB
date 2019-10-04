package com.mx.simlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "horarios_reservados")
public class HorariosReservados implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horarios_reservados", nullable=false)
	private Long idHorariosReservados;
	
	@ManyToOne
	@JoinColumn(name="id_horarios_disponibles_ini", nullable=false)
	private HorariosDisponibles horariosDisponiblesIni;
	
	@ManyToOne
	@JoinColumn(name="id_horarios_disponibles_fin", nullable=false)
	private HorariosDisponibles horariosDisponiblesFin;
	
	@ManyToOne
	@JoinColumn(name="id_reservaciones", nullable=false)
	private Reservaciones reservaciones;
	
	
	
	
	public Long getIdHorariosReservados() {
		return idHorariosReservados;
	}
	public void setIdHorariosReservados(Long idHorariosReservados) {
		this.idHorariosReservados = idHorariosReservados;
	}
	/**
	 * @return the horariosDisponiblesIni
	 */
	public HorariosDisponibles getHorariosDisponiblesIni() {
		return horariosDisponiblesIni;
	}
	/**
	 * @param horariosDisponiblesIni the horariosDisponiblesIni to set
	 */
	public void setHorariosDisponiblesIni(HorariosDisponibles horariosDisponiblesIni) {
		this.horariosDisponiblesIni = horariosDisponiblesIni;
	}
	/**
	 * @return the horariosDisponiblesFin
	 */
	public HorariosDisponibles getHorariosDisponiblesFin() {
		return horariosDisponiblesFin;
	}
	/**
	 * @param horariosDisponiblesFin the horariosDisponiblesFin to set
	 */
	public void setHorariosDisponiblesFin(HorariosDisponibles horariosDisponiblesFin) {
		this.horariosDisponiblesFin = horariosDisponiblesFin;
	}
	/**
	 * @return the reservaciones
	 */
	public Reservaciones getReservaciones() {
		return reservaciones;
	}
	/**
	 * @param reservaciones the reservaciones to set
	 */
	public void setReservaciones(Reservaciones reservaciones) {
		this.reservaciones = reservaciones;
	}
		
}

