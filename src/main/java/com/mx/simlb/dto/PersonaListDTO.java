package com.mx.simlb.dto;


import java.io.Serializable;
import java.util.List;

import com.mx.simlb.vo.PersonaVO;

public class PersonaListDTO implements Serializable {

	private List<PersonaVO> personaListVO;

	public List<PersonaVO> getPersonaListVO() {
		return personaListVO;
	}

	public void setPersonaListVO(List<PersonaVO> personaListVO) {
		this.personaListVO = personaListVO;
	}


}
