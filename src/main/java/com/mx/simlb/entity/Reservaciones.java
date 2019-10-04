/**
 * 
 */
package com.mx.simlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lefs_
 *
 */
@Entity
@Table(name="Reservaciones")
public class Reservaciones implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservaciones", nullable=false)
	private Long idReservaciones;
	
	
	@Column(name="nombre_persona", nullable=false)
	private String nombrePersona;
	
	@Column(name="fecha_reservada", nullable=true)
	private String fechaReservada;
	
	@Column(name="motivo", nullable=false)
	private String motivo;
	
	
	/**
	 * @return the id_reservaciones
	 */
	public Long getIdReservaciones() {
		return idReservaciones;
	}
	/**
	 * @param idReservaciones the idReservaciones to set
	 */
	public void setIdReservaciones(Long idReservaciones) {
		this.idReservaciones = idReservaciones;
	}
	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}
	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	/**
	 * @return the fechaReservada
	 */
	public String getFechaReservada() {
		return fechaReservada;
	}
	/**
	 * @param fechaReservada the fechaReservada to set
	 */
	public void setFechaReservada(String fechaReservada) {
		this.fechaReservada = fechaReservada;
	}
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
}
