package com.mx.simlb.service;

import java.util.List;

import com.mx.simlb.dto.Domicilios;
import com.mx.simlb.dto.Municipios;
import com.mx.simlb.vo.MunicipiosVO;

public interface MunicipiosService {

	public List buscarMunicipiosActivos()throws Exception;
	public List buscarColoniaByLocalidad(MunicipiosVO municipiosVO)throws Exception;
	
}
