package com.mx.simlb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mx.simlb.dao.BuscarDAO;
import com.mx.simlb.dto.HorariosDisponibles;
import com.mx.simlb.dto.HorariosDisponiblesListVO;
import com.mx.simlb.dto.PersonaListDTO;
import com.mx.simlb.dto.Personas;
import com.mx.simlb.dto.Reservaciones;
import com.mx.simlb.dto.ReservacionesListVO;
import com.mx.simlb.vo.HorariosDisponiblesVO;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.HorariosReservadosVO;
import com.mx.simlb.vo.PersonaVO;
import com.mx.simlb.vo.ReservacionesVO;

import mx.com.simlb.paginador.PageHibernate;



@SuppressWarnings("deprecation")
@Repository
public class BuscarDAOImpl extends JdbcDaoSupport implements BuscarDAO{

	
	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public BuscarDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	public PersonaListDTO  buscarPersona(PersonaVO personaVO, Boolean parametro)throws Exception{
		
		PersonaListDTO personaListDTO = new PersonaListDTO();
		
		StringBuffer sql = new StringBuffer();
		List <Personas> allPersonas =null;
		
		try{
			
			sql.append("select p.id_persona, p.nombre_completo,p.nombre_uno,p.nombre_dos,p.ape_paterno,"
					+ "p.ape_materno,p.sexo,p.estatus_persona,p.telefono_uno,p.telefono_dos,p.rol_persona,"
					+ "p.fecha_alta,p.usuario_alta,p.fecha_actualizacion,p.usuario_actualizacion  "+
					"from personas p ");
			 if(parametro){
				 sql.append("where p.nombre_completo like ? ");
			 }else{
				 sql.append("where p.fecha_alta = ? ");
			 }					
			 sql.append("order by p.nombre_completo asc");
			
			 if(parametro){
				 allPersonas = getJdbcTemplate().query(sql.toString(),new Object[]{personaVO.getNombreCompleto()+"%"},
						   ParameterizedBeanPropertyRowMapper.newInstance(Personas.class));	 
			 }else{
				 allPersonas = getJdbcTemplate().query(sql.toString(),new Object[]{personaVO.getFechaAlta()},
						   ParameterizedBeanPropertyRowMapper.newInstance(Personas.class));
			 }									
			 
			 personaListDTO = this.copiarPersonasToVO(allPersonas,personaListDTO);						
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		return personaListDTO;
	}
	
	/*QUERY PARA OBTENER HORRARIOS DISPONIBLES POR FECHA*/
	public List<HorariosDisponiblesVO> obtenerHorariosPorFecha(String fecha)
			throws Exception{
				
				HorariosDisponiblesListVO horariosDisponiblesListVO = new HorariosDisponiblesListVO();
				
						
				String query="select hd1.id_horarios_disponibles,hd1.horario "+
							 "from horarios_disponibles hd1 "+
							 "where hd1.id_horarios_disponibles  not in   "+
							 "(SELECT distinct hd.id_horarios_disponibles "+ 
							 "from horarios_reservados as hr, horarios_disponibles as hd, reservaciones as r "+
							 "where hd.id_horarios_disponibles between  hr.id_horarios_disponibles_ini "+
							 "and hr.id_horarios_disponibles_fin  "+
							 "and hr.id_reservaciones = r.id_reservaciones "
							 + " and r.fecha_reservada = ?) "
							 + "order by hd1.horario asc ";
				try{
					
					List <HorariosDisponibles> hDisponibles= getJdbcTemplate().query(query,new Object[] { fecha },
							ParameterizedBeanPropertyRowMapper.newInstance(HorariosDisponibles.class));

					
					
					horariosDisponiblesListVO = copiarHorariosDisponiblesToVO(hDisponibles, horariosDisponiblesListVO);
				}catch(Exception ex){
					throw new Exception("Error : "+ex.getMessage());
				}
				
				return horariosDisponiblesListVO.getHorariosDisponiblesList();
			}

	
	
	public List<HorariosDisponiblesVO> obtenerHorariosFinPorHoraIni(String hora,String fecha)
			throws Exception{
				
			HorariosDisponiblesListVO horariosDisponiblesListVO = new HorariosDisponiblesListVO();
				
						
			String query="select hd1.id_horarios_disponibles,hd1.horario "+
					 "from horarios_disponibles hd1 "+
					 "where hd1.id_horarios_disponibles  not in   "+
					 "(SELECT distinct hd.id_horarios_disponibles "+ 
					 "from horarios_reservados as hr, horarios_disponibles as hd, reservaciones as r "+
					 "where hd.id_horarios_disponibles between  hr.id_horarios_disponibles_ini "+
					 "and hr.id_horarios_disponibles_fin  "+
					 "and hr.id_reservaciones = r.id_reservaciones "
					 + " and r.fecha_reservada = ?) "
					 + " and hd1.horario > ? "
					 + "order by hd1.horario asc ";
				try{
					
					List <HorariosDisponibles> hDisponibles= getJdbcTemplate().query(query,new Object[] { fecha , hora },
							ParameterizedBeanPropertyRowMapper.newInstance(HorariosDisponibles.class));

					horariosDisponiblesListVO = copiarHorariosDisponiblesToVO(hDisponibles, horariosDisponiblesListVO);
					

				}catch(Exception ex){
					throw new Exception("Error : "+ex.getMessage());
				}
				
				return horariosDisponiblesListVO.getHorariosDisponiblesList();
	}
	
	public ReservacionesListVO  buscarDiaReservadoPorPersona(HorariosPivoteVO horariosPivoteVO, Boolean parametro)throws Exception{
		
		ReservacionesListVO reservacionesListVO = new ReservacionesListVO();
		
		
		StringBuffer sql = new StringBuffer();
		List <Reservaciones> allReservaciones =null;
		
		try{
			
			sql.append("SELECT r.id_reservaciones,hr.id_horarios_reservados, r.nombre_persona,r.fecha_reservada,r.motivo, "
					+ "hd.horario horaIni,hd2.horario horaFin "
					+ "FROM horarios_reservados hr, horarios_disponibles hd, "+
					"horarios_disponibles hd2, reservaciones r "
					+ "where hr.id_reservaciones = r.id_reservaciones "
					+ " and hr.id_horarios_disponibles_ini = hd.id_horarios_disponibles "
					+ "and hr.id_horarios_disponibles_fin = hd2.id_horarios_disponibles ");
			 if(parametro){
				 sql.append("and r.nombre_persona like ? ");
			 }else{
				 sql.append("and r.fecha_reservada = ? ");
			 }					
			 sql.append("order by r.nombre_persona asc");
			
			 if(parametro){
				 allReservaciones = getJdbcTemplate().query(sql.toString(),new Object[]{horariosPivoteVO.getNombrePersona()+"%"},
						   ParameterizedBeanPropertyRowMapper.newInstance(Reservaciones.class));	 
			 }else{
				 allReservaciones = getJdbcTemplate().query(sql.toString(),new Object[]{horariosPivoteVO.getFecha()},
						   ParameterizedBeanPropertyRowMapper.newInstance(Reservaciones.class));
			 }									
			 
			 reservacionesListVO = this.copiarReservacionesToVO(allReservaciones,reservacionesListVO);						
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		return reservacionesListVO;
	}
	
	public ReservacionesListVO  buscarAllReservaciones(HorariosPivoteVO horariosPivoteVO)throws Exception{
		
		ReservacionesListVO reservacionesListVO = new ReservacionesListVO();
		
		
		StringBuffer sql = new StringBuffer();
		List <Reservaciones> allReservaciones =null;
		
		try{
			
			sql.append("SELECT r.id_reservaciones,hr.id_horarios_reservados, r.nombre_persona,r.fecha_reservada,r.motivo, "
					+ "hd.horario horaIni,hd2.horario horaFin "
					+ "FROM horarios_reservados hr, horarios_disponibles hd, "+
					"horarios_disponibles hd2, reservaciones r "
					+ "where hr.id_reservaciones = r.id_reservaciones "
					+ " and hr.id_horarios_disponibles_ini = hd.id_horarios_disponibles "
					+ "and hr.id_horarios_disponibles_fin = hd2.id_horarios_disponibles "
					+ "order by r.fecha_reservada desc");
			
			
				 allReservaciones = getJdbcTemplate().query(sql.toString(),
						   ParameterizedBeanPropertyRowMapper.newInstance(Reservaciones.class));
												
			 
			 reservacionesListVO = this.copiarReservacionesToVO(allReservaciones,reservacionesListVO);						
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		return reservacionesListVO;
	}
	
	public PersonaListDTO copiarPersonasToVO(List personaList,PersonaListDTO personaListDTO){
		
		
		Iterator ite = personaList.iterator();
		List personas = new ArrayList();
		PersonaVO personaVO = null;
		Personas persona = null;
		
		while(ite.hasNext()){
			
			personaVO = new PersonaVO();
			persona = (Personas)ite.next();
			
			personaVO.setIdPersona(String.valueOf(persona.getIdPersona()));
			personaVO.setNombreCompleto(persona.getNombreCompleto());
			personaVO.setSexo(persona.getSexo());
			personaVO.setEstatusPersona(persona.getEstatusPersona());
			personaVO.setTelefonoUno(persona.getTelefonoUno());
			personaVO.setTelefonoDos(persona.getTelefonoDos());
			personaVO.setRolPersona(persona.getRolPersona());
			personaVO.setFechaAlta(persona.getFechaAlta());
			personaVO.setUsuarioAlta(persona.getUsuarioAlta());
			personaVO.setFechaActualizacion(persona.getFechaActualizacion());
			personaVO.setUsuarioActualizacion(persona.getUsuarioActualizacion());
			
			personas.add(personaVO);
			
		}
		
		personaListDTO.setPersonaListVO(personas);
		
		return personaListDTO;
		
	}
	
	public HorariosDisponiblesListVO copiarHorariosDisponiblesToVO(List horariosDisponiblesList,HorariosDisponiblesListVO horariosDisponiblesListVO) {
		
		Iterator ite = horariosDisponiblesList.iterator();
		List horarios = new ArrayList();
		HorariosDisponiblesVO horariosDisponiblesVO = null;
		HorariosDisponibles horariosDisponibles = null;
		
		while(ite.hasNext()){
			
			horariosDisponiblesVO = new HorariosDisponiblesVO();
			horariosDisponibles = (HorariosDisponibles)ite.next();
			
			horariosDisponiblesVO.setIdHorariosDisponibles(horariosDisponibles.getIdHorariosDisponibles());
			horariosDisponiblesVO.setHorario(horariosDisponibles.getHorario());
			
			
			horarios.add(horariosDisponiblesVO);
			
		}
		
		horariosDisponiblesListVO.setHorariosDisponiblesList(horarios);
		
		return horariosDisponiblesListVO;
	}
	
	public ReservacionesListVO copiarReservacionesToVO(List <Reservaciones> allReserv, ReservacionesListVO reservacionesListVO){
			
			Iterator ite = allReserv.iterator();
			ReservacionesVO reservacionesVO = null;
			List <ReservacionesVO>reservacionList = new ArrayList<ReservacionesVO>();
			Reservaciones reservaciones = null;
			HorariosReservadosVO horariosReservadosVO = null;
			
			while(ite.hasNext()){


				reservacionesVO = new ReservacionesVO();
				
				reservaciones = (Reservaciones)ite.next();
				
				reservacionesVO.setIdHorariosReservados(reservaciones.getIdHorariosReservados());
				reservacionesVO.setIdReservaciones(reservaciones.getIdReservaciones());
				reservacionesVO.setNombrePersona(reservaciones.getNombrePersona());
				reservacionesVO.setMotivo(reservaciones.getMotivo());
				reservacionesVO.setHoraIni(reservaciones.getHoraIni());
				reservacionesVO.setHoraFin(reservaciones.getHoraFin());
				reservacionesVO.setFechaReservada(reservaciones.getFechaReservada());
							
				reservacionList.add(reservacionesVO);
				
			}
				
			reservacionesListVO.setReservacionesList(reservacionList);
			return reservacionesListVO;
		}
	
	public PageHibernate buscarReservacionesPager(String page, int resultsPerPage, String orderBy) throws Exception{
		
		try {
			
			
			String queryHQL = "SELECT r.idReservaciones, hr.idHorariosReservados, r.nombrePersona, "
					+ "r.fechaReservada,r.motivo,  hd.horario as horaIni, hd2.horario as horaFin " + 
					" FROM HorariosReservados hr, HorariosDisponibles hd, " + 
					" HorariosDisponibles hd2, Reservaciones r " + 
					" where hr.reservaciones.idReservaciones = r.idReservaciones " + 
					" and hr.horariosDisponiblesIni.idHorariosDisponibles = hd.idHorariosDisponibles " + 
					" and hr.horariosDisponiblesFin.idHorariosDisponibles = hd2.idHorariosDisponibles " + 
					" order by r.fechaReservada desc";
			
		    PageHibernate paginador = new PageHibernate(queryHQL, page, resultsPerPage);
	
		    hibernateTemplate.execute(paginador);
	
		    List<?> count = hibernateTemplate.find("SELECT count(*) " + 
					" FROM HorariosReservados hr, HorariosDisponibles hd, " + 
					" HorariosDisponibles hd2, Reservaciones r " + 
					" where hr.reservaciones.idReservaciones = r.idReservaciones " + 
					" and hr.horariosDisponiblesIni.idHorariosDisponibles = hd.idHorariosDisponibles " + 
					" and hr.horariosDisponiblesFin.idHorariosDisponibles = hd2.idHorariosDisponibles ");
	
		    paginador.setTotalCount(Integer.parseInt(count.get(0).toString()));
		    
		    Iterator ite = paginador.getResults().iterator();
			List <Reservaciones>reservacionList = new ArrayList<Reservaciones>();
			Object aux = null;
			Reservaciones reservaciones = null;
			
			while(ite.hasNext()){
				
				reservaciones = new Reservaciones();
				
				String object ="";
				String[] parts = null;
				
				aux = (Object)ite.next();

				Gson gson = new Gson();
				object = gson.toJson(aux);	
				object = object.replaceAll("[^,/:Ò—·ÈÌÛ˙¡…Õ”⁄ a-zA-Z0-9]", "");
				parts = object.split(",");
				
				reservaciones.setIdReservaciones(Long.valueOf(parts[0]));
				reservaciones.setIdHorariosReservados(Long.valueOf(parts[1]));
				reservaciones.setNombrePersona(parts[2]);
				reservaciones.setFechaReservada(parts[3]);
				reservaciones.setMotivo(parts[4]);
				reservaciones.setHoraIni(parts[5]);
				reservaciones.setHoraFin(parts[6]);
				
					
				reservacionList.add(reservaciones);
				
			}
				
			paginador.setReservaciones(reservacionList);
			
		    return paginador;
		    
		}catch(Exception ex) {
			throw new Exception("Error al obtener la lista : "+ ex.getMessage());
		}
	}
	
}

