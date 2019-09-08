package com.mx.simlb.dao;

import java.util.List;

import com.mx.simlb.dto.Reservaciones;
import com.mx.simlb.vo.ReservacionesVO;

public interface ReservasionDAO {

	public Boolean registrarReservacion(Reservaciones reservacion)throws Exception;
	public Boolean actualizarReservacion(Reservaciones reservaciones )throws Exception;
	public List<ReservacionesVO> cargarCitas()throws Exception;
}
