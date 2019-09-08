package com.mx.simlb.dao;

import java.util.List;

import com.mx.simlb.dto.Domicilios;
import com.mx.simlb.dto.Municipios;

public interface MunicipiosDAO {

	
	public List buscarMunicipiosActivos()throws Exception;
	public List buscarColoniaByLocalidad(Long idCatLocalidad)throws Exception;
	
}
