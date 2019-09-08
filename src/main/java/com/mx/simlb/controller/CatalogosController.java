package com.mx.simlb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.simlb.dto.RegistrarPersona;
import com.mx.simlb.service.BuscarService;
import com.mx.simlb.service.MunicipiosService;
import com.mx.simlb.service.PersonaService;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.MunicipiosVO;
import com.mx.simlb.vo.PersonaVO;



@Controller
@RequestMapping("/")
public class CatalogosController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogosController.class);
	
	@Autowired
	BuscarService buscarService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	MunicipiosService municipiosService;
	
	
	@ResponseBody
	@RequestMapping(value = "/buscarPersona", method = RequestMethod.GET)
	public List buscarPersonas(@RequestParam ("buscarPersona")String buscarPersona)throws Exception {
			
		Gson gson = new Gson();
		PersonaVO personaVO = gson.fromJson(buscarPersona, PersonaVO.class);				
		
		//Para seccionar el nombre completo en partes
		//String []  nombreCompleto = buscarPersona.split(" ");		    			
		
		return buscarService.buscarPersona(personaVO);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cargarMunicipiosActivos", method = RequestMethod.GET)
	public List cargarMunicipiosActivos()throws Exception {								
				
		
		return municipiosService.buscarMunicipiosActivos();		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cargarColoniasActivas", method = RequestMethod.GET)
	public List cargarColoniasActivas(@RequestParam ("buscarColoniaByLocalidad")String buscarColoniaByLocalidad)throws Exception {								
		
		Gson gson = new Gson();
		MunicipiosVO municipiosVO = gson.fromJson(buscarColoniaByLocalidad, MunicipiosVO.class);	
		
		return municipiosService.buscarColoniaByLocalidad(municipiosVO);		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/registrarPersona", method = RequestMethod.GET)
	public boolean registrarPersona(@RequestParam ("registrarPersona")String registrarPersona)throws Exception {								
		
		boolean registroPersona =false;
		
		Gson gson = new Gson();
		RegistrarPersona registrarPersonaVO = gson.fromJson(registrarPersona, RegistrarPersona.class);	
		
		registroPersona = personaService.registrarPersona(registrarPersonaVO);
		
		return registroPersona;		
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarDiaReservado", method = RequestMethod.GET)
	public List buscarDiaReservadoPorPersona(@RequestParam ("buscarDiaReservado")String buscarDiaReservado)throws Exception {
			
		Gson gson = new Gson();
		HorariosPivoteVO horariosPivoteVO = gson.fromJson(buscarDiaReservado, HorariosPivoteVO.class);				   			
		
		return buscarService.buscarDiaReservadoPorPersona(horariosPivoteVO);		
	}
	
	@ResponseBody
	@RequestMapping(value = "/buscarDiaReservadoPorFecha", method = RequestMethod.GET)
	public List buscarDiaReservadoPorFecha(@RequestParam ("buscarDiaReservadoPorFecha")String buscarDiaReservadoPorFecha)throws Exception {
			
		Gson gson = new Gson();
		HorariosPivoteVO horariosPivoteVO = gson.fromJson(buscarDiaReservadoPorFecha, HorariosPivoteVO.class);				   			
		
		return buscarService.buscarDiaReservadoPorFecha(horariosPivoteVO);		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/buscarAllReservaciones", method = RequestMethod.GET)
	public List buscarAllReservaciones(@RequestParam ("buscarAllReservaciones")String buscarAllReservaciones)throws Exception {
			
		Gson gson = new Gson();
		HorariosPivoteVO horariosPivoteVO = gson.fromJson(buscarAllReservaciones, HorariosPivoteVO.class);				   			
		
		return buscarService.buscarAllReservaciones(horariosPivoteVO);		
	}
}
