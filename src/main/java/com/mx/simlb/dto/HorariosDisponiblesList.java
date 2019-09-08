package com.mx.simlb.dto;

import java.io.Serializable;
import java.util.List;


public class HorariosDisponiblesList 
implements Serializable{

	private List<HorariosDisponibles> horariosDisponiblesList;

	public List<HorariosDisponibles> getHorariosDisponiblesList() {
		return horariosDisponiblesList;
	}

	public void setHorariosDisponiblesList(
			List<HorariosDisponibles> horariosDisponiblesList) {
		this.horariosDisponiblesList = horariosDisponiblesList;
	}
	
	
}