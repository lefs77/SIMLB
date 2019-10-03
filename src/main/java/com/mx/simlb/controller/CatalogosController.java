package com.mx.simlb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.simlb.dto.RegistrarPersona;
import com.mx.simlb.service.BuscarService;
import com.mx.simlb.service.MunicipiosService;
import com.mx.simlb.service.PersonaService;
import com.mx.simlb.service.ReservacionService;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.MunicipiosVO;
import com.mx.simlb.vo.PersonaVO;

import mx.com.simlb.paginador.Page;
import mx.com.simlb.utils.PagerRender;



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
	
	@Autowired
	ReservacionService reservacionService;
	
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
	@RequestMapping(value = "/reagendarCita.htm", method = RequestMethod.GET)
	public ModelMap buscarAllReservaciones(@RequestParam(value="page", required=false) String page, ModelMap modelo)throws Exception {
							   			
		
		Page pager = buscarService.buscarReservacionesPager(page, 4, "");
		
		PagerRender pagerRender = pager.getRender("Bootstrap");
		pagerRender.setRequestUri("reagendarCita.htm");
		pagerRender.render();
		
		modelo.addAttribute("reservaciones", pager.getReservaciones());
		modelo.addAttribute("pager", pagerRender.getOutput());
		modelo.addAttribute("titulo", "Listado de Reservaciones con Paginador");
		
		return modelo;		
	}
	
	@RequestMapping(value = "/eliminarCita.htm", method = RequestMethod.GET)
	public String eliminarCita(@RequestParam("id") Long id) throws Exception {
		

		try {
			
			reservacionService.eliminarCita(id);
			
		}catch(Exception ex) {
			throw new Exception("Error al eliminarCita() : "+ex.getMessage());
		}
			
		return "redirect:reagendarCita.htm";
	}
	
	@RequestMapping(value = "/editarCita.htm", method = RequestMethod.GET)
	public String editarCita(Model model,@RequestParam("id") Long id) throws Exception {
		

		try {
			
				com.mx.simlb.entity.HorariosReservados horariosReserv = null;
			
				horariosReserv = reservacionService.obteberHorariosReservadosById(id);
			
				model.addAttribute("horariosReserv", horariosReserv);
				return "editarCita";
			
		}catch(Exception ex) {
			throw new Exception("Error al eliminarCita() : "+ex.getMessage());
		}
			
	}
}
