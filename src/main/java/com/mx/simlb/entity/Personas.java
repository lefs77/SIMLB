package com.mx.simlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reservaciones")
public class Personas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona", nullable=false)
	private Long idPersona;
	
	@Column(name="nombre_uno", nullable=false)
	private String nombreUno;
	
	@Column(name="nombre_dos", nullable=false)
	private String nombreDos;
	
	@Column(name="ape_paterno", nullable=false)
	private String apePaterno;
	
	@Column(name="ape_materno", nullable=false)
	private String apeMaterno;
	
	@Column(name="nombre_completo", nullable=false)
	private String nombreCompleto; 
	
	@Column(name="sexo", nullable=false)
	private String sexo;
	
	@Column(name="codigo_postal", nullable=false)
	private String codigoPostal;
	
	@Column(name="estatus_persona", nullable=false)
	private String estatusPersona;
	
	@Column(name="telefono_uno", nullable=false)
	private String telefonoUno;
	
	@Column(name="telefono_dos", nullable=false)
	private String telefonoDos;
	
	@Column(name="rol_persona", nullable=false)
	private String rolPersona;
	
	@Column(name="numero_int", nullable=false)
	private Long numeroInt;
	
	
}
