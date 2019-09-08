package com.mx.simlb.dto;

import java.io.Serializable;
import java.util.List;

public class DomiciliosDTOList implements Serializable{

	private List<Domicilios> domiciliosList;

	public List<Domicilios> getDomiciliosList() {
		return domiciliosList;
	}

	public void setDomiciliosList(List<Domicilios> domiciliosList) {
		this.domiciliosList = domiciliosList;
	}
	
	

}
