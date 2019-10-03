package com.mx.simlb.service;

import java.util.List;

import com.mx.simlb.vo.ReservacionesVO;

public interface ReservacionService {

	public Boolean reservarCita(ReservacionesVO reservacionesVO )throws Exception;
	public Boolean actualizarReservacion(ReservacionesVO reservacionesVO )throws Exception;
	public List<ReservacionesVO> cargarCitas()throws Exception;
	public Boolean eliminarCita(Long idHorarioReservado)throws Exception;
	public com.mx.simlb.entity.HorariosReservados obteberHorariosReservadosById(Long idHorarioReservado)throws Exception;
		
}
