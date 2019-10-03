package com.mx.simlb.service;


import java.util.List;

import com.mx.simlb.vo.HorariosDisponiblesVO;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.PersonaVO;
import com.mx.simlb.vo.ReservacionesVO;

import mx.com.simlb.paginador.PageHibernate;



public interface BuscarService {

	
	public List<PersonaVO>  buscarPersona(PersonaVO personaVO)throws Exception;
	public List<HorariosDisponiblesVO> obtenerHorariosPorFecha(String fecha)throws Exception;		
	public List<HorariosDisponiblesVO> obtenerHorariosFinPorHoraIni(String hora,String fecha)throws Exception;
	public List<ReservacionesVO>  buscarDiaReservadoPorPersona(HorariosPivoteVO horariosPivoteVO)throws Exception;
	public List<ReservacionesVO>  buscarDiaReservadoPorFecha(HorariosPivoteVO horariosPivoteVO)throws Exception;
	public List<ReservacionesVO>  buscarAllReservaciones(HorariosPivoteVO horariosPivoteVO)throws Exception;
	public PageHibernate buscarReservacionesPager(String page, int resultsPerPage, String orderBy) throws Exception;

}
