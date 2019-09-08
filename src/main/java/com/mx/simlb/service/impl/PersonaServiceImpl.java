package com.mx.simlb.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.simlb.dao.PersonaDAO;
import com.mx.simlb.dto.Cliente;
import com.mx.simlb.dto.Empleado;
import com.mx.simlb.dto.Personas;
import com.mx.simlb.dto.RegistrarPersona;
import com.mx.simlb.dto.Usuarios;
import com.mx.simlb.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaDAO personaDAO;
	
public Boolean registrarPersona(RegistrarPersona registrarPersonaVO)throws Exception{
		
		Boolean regExitoso = false;
		
		try{					
			Personas persona = new Personas();
			
			Date fechaAlta = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			if(registrarPersonaVO.getNombre() !=null && !registrarPersonaVO.getNombre().equals("")) {
				persona.setNombreUno(registrarPersonaVO.getNombre());
			}
			
			if(registrarPersonaVO.getNombre2()!=null && !registrarPersonaVO.getNombre2().equals("")) {
				persona.setNombreDos(registrarPersonaVO.getNombre2());
			}
			
			if(registrarPersonaVO.getApellidoPaterno()!=null && !registrarPersonaVO.getApellidoPaterno().equals("")) {
				persona.setApePaterno(registrarPersonaVO.getApellidoPaterno());
			}
			
			if(registrarPersonaVO.getApellidoMaterno() !=null && !registrarPersonaVO.getApellidoMaterno().equals("")) {
				persona.setApeMaterno(registrarPersonaVO.getApellidoMaterno());
			}
			
			if(registrarPersonaVO.getNombreCompleto() !=null && !registrarPersonaVO.getNombreCompleto().equals("")) {
				persona.setNombreCompleto(registrarPersonaVO.getNombreCompleto());
			}
			
			if(registrarPersonaVO.getCodigoPostal()!=null && !registrarPersonaVO.getCodigoPostal().equals("")) {
				persona.setCodigoPostal(registrarPersonaVO.getCodigoPostal());
			}
			
			if(registrarPersonaVO.getSexo()!=null && !registrarPersonaVO.getSexo().equals("")) {
				persona.setSexo(registrarPersonaVO.getSexo());
			}			
			
			if(registrarPersonaVO.getTelefono()!= null && !registrarPersonaVO.getTelefono().equals("")) {
				persona.setTelefonoUno(registrarPersonaVO.getTelefono());
			}
			
			if(registrarPersonaVO.getTelefono2()!=null && !registrarPersonaVO.getTelefono2().equals("")) {
				persona.setTelefonoDos(registrarPersonaVO.getTelefono2());
			}
			
			if(registrarPersonaVO.getRol()!=null && !registrarPersonaVO.getRol().equals("")) {
				persona.setRolPersona(registrarPersonaVO.getRol());
			}
			
			if(registrarPersonaVO.getNumeroInt()!=null && !registrarPersonaVO.getNumeroInt().equals("")) {
				persona.setNumeroInt(Long.valueOf(registrarPersonaVO.getNumeroInt()));
			}
			
			if(registrarPersonaVO.getNumeroExt()!=null && !registrarPersonaVO.getNumeroExt().equals("")) {
				persona.setNumeroExt(Long.valueOf(registrarPersonaVO.getNumeroExt()));
			}					
			
			//campos de cliente
			if(registrarPersonaVO.getClaveCliente()!= null && !registrarPersonaVO.getClaveCliente().equals("")) {
				
				Cliente cliente = new Cliente();
				
				
				cliente.setClaveCliente(registrarPersonaVO.getClaveCliente());
				cliente.setEstatusCliente("A");
				cliente.setFechaAlta(sdf.format(fechaAlta));
				cliente.setUsuarioAlta("ADMIN");
				
				persona.setCliente(cliente);
			}
			//campos de empleado
			if(registrarPersonaVO.getClaveEmpleado()!=null && !registrarPersonaVO.getClaveEmpleado().equals("")) {
				
				Empleado empleado = new Empleado();
				
				empleado.setClaveEmpleado(registrarPersonaVO.getClaveEmpleado());
				empleado.setEstatusEmpleado("A");
				empleado.setFechaAlta(sdf.format(fechaAlta));
				empleado.setUsuarioAlta("ADMIN");
				
				persona.setEmpleado(empleado);
			}
			
			//campos de usuario
			if((registrarPersonaVO.getCodigoUsuario()!=null && !registrarPersonaVO.getCodigoUsuario().equals("")) &&
			   (registrarPersonaVO.getPuestoOcupado()!=null && !registrarPersonaVO.getPuestoOcupado().equals(""))) {
				
				Usuarios usuarios = new Usuarios();
				
				usuarios.setCodigoUsuario(registrarPersonaVO.getCodigoUsuario());
				usuarios.setPuestoOcupado(registrarPersonaVO.getPuestoOcupado());
				usuarios.setEstatusUsuario("A");
				usuarios.setFechaAlta(sdf.format(fechaAlta));
				usuarios.setUsuarioAlta("ADMIN");
				
				persona.setUsuarios(usuarios);
			}
			
			persona.setEstatusPersona("A");
			persona.setFechaAlta(sdf.format(fechaAlta));
			persona.setUsuarioAlta("ADMIN");
			
			
			regExitoso = personaDAO.registrarPersona(persona,registrarPersonaVO.getIdLocalidadDomicilio());
			
		}catch(Exception ex){
			throw new Exception("Service_Error :  registrarPersona() "+ex.getMessage());
		}
		
		return regExitoso;
	}
}
