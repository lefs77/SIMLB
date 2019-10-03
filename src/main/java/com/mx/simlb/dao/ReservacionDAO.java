package com.mx.simlb.dao;

import java.util.List;

import com.mx.simlb.dto.HorariosReservados;
import com.mx.simlb.dto.Reservaciones;
import com.mx.simlb.vo.ReservacionesVO;

public interface ReservacionDAO {

	public Boolean registrarReservacion(Reservaciones reservacion)throws Exception;
	public Boolean actualizarReservacion(Reservaciones reservaciones )throws Exception;
	public List<ReservacionesVO> cargarCitas()throws Exception;
	public Boolean eliminarCita(Long idHorarioReservado)throws Exception;
	public com.mx.simlb.entity.HorariosReservados obteberHorariosReservadosById(Long idHorarioReservado)throws Exception;
	public com.mx.simlb.entity.Reservaciones obteberReservacionById(Long idReservacion)throws Exception;
}
