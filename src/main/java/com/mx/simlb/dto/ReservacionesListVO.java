package com.mx.simlb.dto;

import java.io.Serializable;
import java.util.List;

import com.mx.simlb.vo.ReservacionesVO;

public class ReservacionesListVO implements Serializable{
	
	private List<ReservacionesVO> reservacionesList;

	public List<ReservacionesVO> getReservacionesList() {
		return reservacionesList;
	}

	public void setReservacionesList(List<ReservacionesVO> reservacionesList) {
		this.reservacionesList = reservacionesList;
	}
	
}
