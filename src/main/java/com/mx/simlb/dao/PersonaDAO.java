package com.mx.simlb.dao;

import com.mx.simlb.dto.Personas;
import com.mx.simlb.dto.PersonasLocalidadDomicilio;

public interface PersonaDAO {
	public Boolean registrarPersona(Personas personas,String localidadDomicilio)throws Exception;
}
