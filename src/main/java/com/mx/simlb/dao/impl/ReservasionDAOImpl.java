package com.mx.simlb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mx.simlb.dao.ReservasionDAO;
import com.mx.simlb.dto.HorariosDisponibles;
import com.mx.simlb.dto.HorariosReservados;
import com.mx.simlb.dto.Reservaciones;
import com.mx.simlb.vo.ReservacionesVO;

@SuppressWarnings("deprecation")
@Repository
public class ReservasionDAOImpl extends JdbcDaoSupport implements ReservasionDAO{

	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public ReservasionDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	
	public Boolean registrarReservacion(Reservaciones reservacion)throws Exception{
		
		try{
			Boolean registro=false;
			
			SimpleJdbcInsert simpleJdbcInsert = null;
			HorariosReservados horariosReservados = new HorariosReservados();
			HorariosDisponibles horariosDisponibles = new HorariosDisponibles();
			Long idHorarioDisponibleIni = 0l;
			Long idHorarioDisponibleFin = 0l;
			Long idHorariosReservados = 0l;
			
			String query="SELECT hd.id_horarios_disponibles "+
							"FROM horarios_disponibles as hd "+							
							"where hd.horario in (?,?) ";																					
			
			
			//obtiene el id del horario seleccionado
			List <HorariosDisponibles> idHorario= getJdbcTemplate().query(query,new Object[]{reservacion.getHoraIni(),reservacion.getHoraFin()},ParameterizedBeanPropertyRowMapper.newInstance(HorariosDisponibles.class));			
								
			horariosDisponibles = (HorariosDisponibles)idHorario.get(0);
			
			idHorarioDisponibleIni = horariosDisponibles.getIdHorariosDisponibles();
			
			horariosDisponibles = (HorariosDisponibles)idHorario.get(1);
			
			idHorarioDisponibleFin = horariosDisponibles.getIdHorariosDisponibles();
			
       
	        
	        final String SQL = "INSERT INTO reservaciones (nombre_persona, motivo, fecha_reservada) "
                    + " VALUES( :nombrePersona, :motivo, :fechaReservada)";
	        
			KeyHolder keyHolder = new GeneratedKeyHolder();
	        NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
	        SqlParameterSource parameters = new BeanPropertySqlParameterSource(reservacion);
	        int nb = namedJdbcTemplate.update(SQL, parameters, keyHolder, new String[]{"id_reservaciones"});
	        Long idReservaciones = keyHolder.getKey().longValue();
			
			
			horariosReservados.setIdHorariosDisponiblesIni(idHorarioDisponibleIni);
			horariosReservados.setIdHorariosDisponiblesFin(idHorarioDisponibleFin);
			horariosReservados.setIdReservaciones(idReservaciones);
			
			simpleJdbcInsert = new SimpleJdbcInsert(getDataSource()).withTableName("horarios_reservados");
			parameters = new BeanPropertySqlParameterSource(horariosReservados);
			idHorariosReservados = Long.valueOf(simpleJdbcInsert.execute(parameters));
			
			if(idHorariosReservados>0) {
				registro = true;
			}else {
				registro = false;
			}
			
			return registro;
			
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
	}
	
	public Boolean actualizarReservacion(Reservaciones reservacion)throws Exception{
		
		
		try{
			
			Boolean actualizacionExitosa =false;
			HorariosReservados horariosReservados = new HorariosReservados();
			
			horariosReservados.setIdHorariosDisponiblesIni(reservacion.getIdHorariosDisponiblesIni());
			horariosReservados.setIdHorariosDisponiblesFin(reservacion.getIdHorariosDisponiblesFin());
			horariosReservados.setIdReservaciones(reservacion.getIdReservaciones());
			horariosReservados.setIdHorariosReservados(reservacion.getIdHorariosReservados());
			
			String query = "UPDATE reservaciones SET nombre_persona = ?, motivo = ?, fecha_reservada = ? where id_reservaciones = ?";
			getJdbcTemplate().update(query, new Object[]{reservacion.getNombrePersona(),reservacion.getMotivo(),reservacion.getFechaReservada(),reservacion.getIdReservaciones()});					
			
			//ACTUALIZACION DE LOS HORARIOS RESERVADOS
			actualizacionExitosa = actualizarHorarioReservado(horariosReservados);
			
						
			return actualizacionExitosa;
		}catch(Exception ex){
			throw new Exception("Error en actualizarReservacion() : "+ex.getMessage());
		}
		
	}
	
	
	
	public Boolean actualizarHorarioReservado(HorariosReservados horariosReservados)throws Exception{
		
		
		try{
			
			Boolean actualizacionExitosa =false;
			
			String query = "UPDATE horarios_reservados SET id_horarios_disponibles_ini = ?, id_horarios_disponibles_fin = ?, id_reservaciones = ? where id_horarios_reservados = ?";
			getJdbcTemplate().update(query, new Object[]{horariosReservados.getIdHorariosDisponiblesIni(),horariosReservados.getIdHorariosDisponiblesFin(),horariosReservados.getIdReservaciones(),horariosReservados.getIdHorariosReservados()});					
			
			actualizacionExitosa = true;
			
			return actualizacionExitosa;
		}catch(Exception ex){
			throw new Exception("Error en actualizarHorarioReservado() : "+ex.getMessage());
		}
		
	}
	
	
	@Override
	public List<ReservacionesVO> cargarCitas()throws Exception{
		
		List<ReservacionesVO> reservacionList = new ArrayList<ReservacionesVO>();
		
		
		String query="select r.id_reservaciones, r.nombre_persona,    "+
					"r.motivo, r.fecha_reservada, hd.horario hora_ini, hd2.horario hora_fin "+
					"from reservaciones r, horarios_reservados hr, horarios_disponibles hd,horarios_disponibles hd2 "+
					"where r.id_reservaciones = hr.id_reservaciones "+
					"and hr.id_horarios_disponibles_ini = hd.id_horarios_disponibles "+
					"and hr.id_horarios_disponibles_fin = hd2.id_horarios_disponibles "+
					"order by r.fecha_reservada asc";				 
				 
		
		try{

			List <Reservaciones> allReserv= getJdbcTemplate().query(query,
					ParameterizedBeanPropertyRowMapper.newInstance(Reservaciones.class));

			reservacionList = copiarReservacionesToVO(allReserv,reservacionList);
					
			return reservacionList;
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		
	}
	
	
public List<ReservacionesVO> copiarReservacionesToVO(List <Reservaciones> allReserv, List <ReservacionesVO> reservacionList){
		
		Iterator ite = allReserv.iterator();
		ReservacionesVO reservacionesVO = null;
		Reservaciones reservaciones = null;
		
		while(ite.hasNext()){
			
			reservacionesVO = new ReservacionesVO();
			reservaciones = (Reservaciones)ite.next();
			reservacionesVO.setIdReservaciones(reservaciones.getIdReservaciones());
			reservacionesVO.setNombrePersona(reservaciones.getNombrePersona());
			reservacionesVO.setMotivo(reservaciones.getMotivo());
			reservacionesVO.setHoraIni(reservaciones.getHoraIni());
			reservacionesVO.setHoraFin(reservaciones.getHoraFin());
			reservacionesVO.setFechaReservada(reservaciones.getFechaReservada());
						
			reservacionList.add(reservacionesVO);
			
		}
			
		return reservacionList;
	}
}
