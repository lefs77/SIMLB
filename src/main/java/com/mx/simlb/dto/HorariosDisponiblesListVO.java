package com.mx.simlb.dto;

import java.io.Serializable;
import java.util.List;

import com.mx.simlb.vo.HorariosDisponiblesVO;

public class HorariosDisponiblesListVO implements Serializable{
	
	private List<HorariosDisponiblesVO> horariosDisponiblesList;

	public List<HorariosDisponiblesVO> getHorariosDisponiblesList() {
		return horariosDisponiblesList;
	}

	public void setHorariosDisponiblesList(List<HorariosDisponiblesVO> horariosDisponiblesList) {
		this.horariosDisponiblesList = horariosDisponiblesList;
	}

}
