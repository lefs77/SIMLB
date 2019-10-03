package com.mx.simlb.dao;

import java.util.List;

import com.mx.simlb.dto.PersonaListDTO;
import com.mx.simlb.dto.ReservacionesListVO;
import com.mx.simlb.vo.HorariosDisponiblesVO;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.PersonaVO;
import com.mx.simlb.vo.ReservacionesVO;

import mx.com.simlb.paginador.PageHibernate;

public interface BuscarDAO {

	public PersonaListDTO buscarPersona(PersonaVO personaVO, Boolean parametro)throws Exception;
	public List<HorariosDisponiblesVO> obtenerHorariosPorFecha(String fecha)throws Exception;	
	public List<HorariosDisponiblesVO> obtenerHorariosFinPorHoraIni(String hora,String fecha)throws Exception;
	public ReservacionesListVO  buscarDiaReservadoPorPersona(HorariosPivoteVO horariosPivoteVO,Boolean parametro)throws Exception;
	public ReservacionesListVO  buscarAllReservaciones(HorariosPivoteVO horariosPivoteVO)throws Exception;
	public PageHibernate buscarReservacionesPager(String page, int resultsPerPage, String orderBy) throws Exception;
	
}
