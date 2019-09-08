package com.mx.simlb.dto;

import java.io.Serializable;
import java.util.List;

import com.mx.simlb.vo.MunicipiosVO;


public class MunicipiosDTOList implements Serializable{

	private List<Municipios> municipiosList;

	public List<Municipios> getMunicipiosList() {
		return municipiosList;
	}

	public void setMunicipiosList(List<Municipios> municipiosList) {
		this.municipiosList = municipiosList;
	}

	
	
	
}
