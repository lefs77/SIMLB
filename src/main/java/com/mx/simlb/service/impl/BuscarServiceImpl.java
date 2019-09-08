package com.mx.simlb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.simlb.dao.BuscarDAO;
import com.mx.simlb.dto.HorariosDisponibles;
import com.mx.simlb.dto.HorariosDisponiblesList;
import com.mx.simlb.dto.HorariosDisponiblesListVO;
import com.mx.simlb.dto.PersonaListDTO;
import com.mx.simlb.dto.ReservacionesListVO;
import com.mx.simlb.service.BuscarService;
import com.mx.simlb.vo.HorariosDisponiblesVO;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.PersonaVO;
import com.mx.simlb.vo.ReservacionesVO;

@Service
public class BuscarServiceImpl implements BuscarService{

	@Autowired 
	private BuscarDAO buscarDAO;
	
	public List<PersonaVO>  buscarPersona(PersonaVO personaVO)throws Exception{
		
		PersonaListDTO personaListDTO = new PersonaListDTO();
		
		try{
			
			if(personaVO.getNombreCompleto()!= null && !personaVO.getNombreCompleto().equals("")){
				
				personaListDTO = buscarDAO.buscarPersona(personaVO,true);
				
			}else{
				
				personaListDTO = buscarDAO.buscarPersona(personaVO,false);
			}																		
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarPersona() "+ex.getMessage());
		}
		
		return personaListDTO.getPersonaListVO();
	}
	
	@Override
	public List<HorariosDisponiblesVO> obtenerHorariosPorFecha(String fecha)throws Exception{
		
		HorariosDisponiblesListVO horariosDisponiblesListVO = new HorariosDisponiblesListVO();
		
		try{
			
			horariosDisponiblesListVO.setHorariosDisponiblesList(buscarDAO.obtenerHorariosPorFecha(fecha));					
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  obtenerHorariosPorFecha() "+ex.getMessage());
		}
		
		return horariosDisponiblesListVO.getHorariosDisponiblesList();
	}
	
	
	public List<HorariosDisponiblesVO> obtenerHorariosFinPorHoraIni(String hora,String fecha)throws Exception{
		
		HorariosDisponiblesListVO horariosDisponiblesList = new HorariosDisponiblesListVO();
		
		try{
			
			horariosDisponiblesList.setHorariosDisponiblesList(buscarDAO.obtenerHorariosFinPorHoraIni(hora,fecha));					
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  obtenerHorariosPorFecha() "+ex.getMessage());
		}
		
		return horariosDisponiblesList.getHorariosDisponiblesList();
		
	}
	
	public List<ReservacionesVO>  buscarDiaReservadoPorPersona(HorariosPivoteVO horariosPivoteVO)throws Exception{
		
		ReservacionesListVO reservacionesListVO = new ReservacionesListVO();
		
		try{
			
				reservacionesListVO = buscarDAO.buscarDiaReservadoPorPersona(horariosPivoteVO,true);
																
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarDiaReservadoPorPersona() "+ex.getMessage());
		}
		
		return reservacionesListVO.getReservacionesList();
	}
	
	public List<ReservacionesVO>  buscarDiaReservadoPorFecha(HorariosPivoteVO horariosPivoteVO)throws Exception{
		
		ReservacionesListVO reservacionesListVO = new ReservacionesListVO();
		
		try{
			
				reservacionesListVO = buscarDAO.buscarDiaReservadoPorPersona(horariosPivoteVO,false);
																				
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarDiaReservadoPorFecha() "+ex.getMessage());
		}
		
		return reservacionesListVO.getReservacionesList();
	}
	
	public List<ReservacionesVO>  buscarAllReservaciones(HorariosPivoteVO horariosPivoteVO)throws Exception{
		
		ReservacionesListVO reservacionesListVO = new ReservacionesListVO();
		
		try{
			
				reservacionesListVO = buscarDAO.buscarAllReservaciones(horariosPivoteVO);
																
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarDiaReservadoPorPersona() "+ex.getMessage());
		}
		
		return reservacionesListVO.getReservacionesList();
	}
}
