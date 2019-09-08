package com.mx.simlb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mx.simlb.dao.MunicipiosDAO;
import com.mx.simlb.dto.Domicilios;
import com.mx.simlb.dto.DomiciliosDTOList;
import com.mx.simlb.dto.Municipios;
import com.mx.simlb.dto.MunicipiosDTOList;
import com.mx.simlb.service.MunicipiosService;
import com.mx.simlb.vo.MunicipiosVO;

@Service
public class MunicipioServiceImpl implements MunicipiosService{

	@Autowired 
	private MunicipiosDAO municipiosDAO;
	
	public List buscarMunicipiosActivos()throws Exception{
		
		MunicipiosDTOList municipiosDTOList = new MunicipiosDTOList();
		
		try{
			
				municipiosDTOList.setMunicipiosList(municipiosDAO.buscarMunicipiosActivos());
																								
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarMunicipiosActivos() "+ex.getMessage());
		}
		
		return municipiosDTOList.getMunicipiosList();
	}
	
	
	public List buscarColoniaByLocalidad(MunicipiosVO municipiosVO)throws Exception{
		
		DomiciliosDTOList domiciliosDTOList = new DomiciliosDTOList();
		
		Long idCatLocalidad = 0l;
		
		try{
			idCatLocalidad = municipiosVO.getIdCatLocalidad();
			
			domiciliosDTOList.setDomiciliosList(municipiosDAO.buscarColoniaByLocalidad(idCatLocalidad));
																								
		}catch(Exception ex){
			throw new Exception("Service_Error :  buscarColoniaByLocalidad() "+ex.getMessage());
		}
		
		return domiciliosDTOList.getDomiciliosList();
	}
	
}
