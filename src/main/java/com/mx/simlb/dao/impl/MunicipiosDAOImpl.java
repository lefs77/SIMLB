package com.mx.simlb.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.mx.simlb.dao.MunicipiosDAO;
import com.mx.simlb.dto.Colonias;
import com.mx.simlb.dto.Domicilios;
import com.mx.simlb.dto.DomiciliosDTOList;
import com.mx.simlb.dto.Municipios;
import com.mx.simlb.dto.MunicipiosDTOList;
import com.mx.simlb.vo.MunicipiosVO;

@SuppressWarnings("deprecation")
@Repository
public class MunicipiosDAOImpl extends JdbcDaoSupport implements MunicipiosDAO{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public MunicipiosDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	public List buscarMunicipiosActivos()throws Exception{
		
		MunicipiosDTOList municipiosDTOList = new MunicipiosDTOList();
		
		StringBuffer sql = new StringBuffer();
		List <Municipios> allMunicipios = new ArrayList ();
		List <MunicipiosVO> allMunicipiosVO= new ArrayList ();
		
		try{
			
				sql.append("select cl.id_cat_localidad, cl.clave_localidad ,cl.descripcion_localidad,cl.estatus_localidad, "
					+ "cl.fecha_alta,cl.usuario_alta,cl.fecha_actualizacion,cl.usuario_actualizacion "
					+ " from cat_localidad cl "
					+ " where cl.estatus_localidad  = ? ");
			 
			
			
			 	allMunicipios = getJdbcTemplate().query(sql.toString(),new Object[]{"A"},
					   ParameterizedBeanPropertyRowMapper.newInstance(Municipios.class));	 							
			 
			
			 	
			 	if(allMunicipios.size()>0) {
			 		
			 		allMunicipiosVO = this.copiarMunicipiosToVO(allMunicipios, allMunicipiosVO);
			 		
			 	}else {
			 		
					throw new Exception("No existen registros con esos parametros...");
				}
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		return allMunicipiosVO;
	}
	
	
	public List buscarColoniaByLocalidad(Long idCatLocalidad)throws Exception{
		
		StringBuffer sql = new StringBuffer();
		List <Domicilios> allDomicilios =new ArrayList();
		List <Colonias> allColonias= new ArrayList<Colonias>();
		
		try{
			
				sql.append("select ld.id_localidad_domicilio,cl.clave_localidad, "
					+ "cl.descripcion_localidad,cl.estatus_localidad, "
					+ "cd.colonia,cd.calle,cd.estatus estatus_domicilio "
					+ "FROM localidad_domicilio ld, cat_localidad cl,cat_domicilio cd "
					+ "where ld.id_cat_localidad = cl.id_cat_localidad "
					+ "and ld.id_cat_domicilio = cd.id_cat_domicilio "
					+ "and cd.estatus = ? "
					+ "and cl.id_cat_localidad = ? ");
			 
			
			
				allDomicilios = getJdbcTemplate().query(sql.toString(),new Object[]{"A", idCatLocalidad},
					   ParameterizedBeanPropertyRowMapper.newInstance(Domicilios.class));	
				
				if(allDomicilios.size()>0) {
					
					allColonias = this.copiarDomiciliosToColonias(allDomicilios,allColonias);
					
				}else {
					
					throw new Exception("No existen registros con esos parametros...");
				}
			 
			 	
			 	
			
		}catch(Exception ex){
			throw new Exception("Error : "+ex.getMessage());
		}
		
		return allColonias;
	}
	
	public List<MunicipiosVO> copiarMunicipiosToVO(List<Municipios> allMunicipios,List<MunicipiosVO> municipiosVOList){
		
		
		Iterator ite = allMunicipios.iterator();
		MunicipiosVO municipiosVO = null;
		Municipios municipio = null;
		
		while(ite.hasNext()){
			
			municipiosVO = new MunicipiosVO();
			municipio = (Municipios)ite.next();
			
			municipiosVO.setIdCatLocalidad(municipio.getIdCatLocalidad());
			municipiosVO.setClaveLocalidad(municipio.getClaveLocalidad());
			municipiosVO.setDescripcionLocalidad(municipio.getDescripcionLocalidad());
			municipiosVO.setEstatusLocalidad(municipio.getEstatusLocalidad());
			municipiosVO.setFechaAlta(municipio.getFechaAlta());
			municipiosVO.setUsuarioAlta(municipio.getUsuarioAlta());
			municipiosVO.setFechaActualizacion(municipio.getFechaActualizacion());
			municipiosVO.setUsuarioActualizacion(municipio.getUsuarioActualizacion());
			
			
			municipiosVOList.add(municipiosVO);
			
		}
		
		return municipiosVOList;
		
	}
	
	public List<Colonias> copiarDomiciliosToColonias(List <Domicilios> allDomicilios, List <Colonias> allColonias){
		
		Iterator ite = allDomicilios.iterator();
		Colonias colonias = null;
		Domicilios domicilios = null;
		
		while(ite.hasNext()){
			
			colonias = new Colonias();
			domicilios = (Domicilios)ite.next();
			colonias.setIdLocalidadDomicilio(domicilios.getIdLocalidadDomicilio());
			colonias.setCalle(domicilios.getCalle());
			colonias.setClaveLocalidad(domicilios.getClaveLocalidad());
			colonias.setColonia(domicilios.getColonia());
			colonias.setDescripcionLocalidad(domicilios.getDescripcionLocalidad());
			colonias.setEstatusDomicilio(domicilios.getEstatus());
			colonias.setEstatusLocalidad(domicilios.getEstatusLocalidad());
			
			
			allColonias.add(colonias);
			
		}
			
		return allColonias;
	}
}
