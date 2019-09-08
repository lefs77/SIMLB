package com.mx.simlb.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mx.simlb.comun.Constantes;
import com.mx.simlb.comun.ReservacionMonth;
import com.mx.simlb.dto.Reservaciones;
import com.mx.simlb.service.BuscarService;
import com.mx.simlb.service.MunicipiosService;
import com.mx.simlb.service.PersonaService;
import com.mx.simlb.service.ReservacionService;
import com.mx.simlb.vo.HorariosPivoteVO;
import com.mx.simlb.vo.ReservacionesVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BuscarService buscarService;
	
	@Autowired
	ReservacionService reservacionService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println(request.getRemoteAddr());
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/cargarHorario", method = RequestMethod.GET)
	public List cargarHorario(@RequestParam ("cargarHorario")String cargarHorario)throws Exception {
			
		Gson gson = new Gson();
		HorariosPivoteVO horariosPivoteVO = gson.fromJson(cargarHorario, HorariosPivoteVO.class);				
		
		return buscarService.obtenerHorariosPorFecha(horariosPivoteVO.getFecha());		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cargarHorarioFin", method = RequestMethod.GET)
	public List cargarHorarioFin(@RequestParam ("cargarHorarioFin")String cargarHorarioFin)throws Exception {
			
		Gson gson = new Gson();
		HorariosPivoteVO horariosPivoteVO = gson.fromJson(cargarHorarioFin, HorariosPivoteVO.class);				
		
		return buscarService.obtenerHorariosFinPorHoraIni(horariosPivoteVO.getHoraIni(),horariosPivoteVO.getFecha());		
	}
	
	@ResponseBody
	@RequestMapping(value = "/actualizarReservacion", method = RequestMethod.GET)
	public Boolean actualizarReservacion(@RequestParam ("actualizarReservacion")String actualizarReservacion)throws Exception {
			
		Gson gson = new Gson();
		ReservacionesVO reservacionesVO = gson.fromJson(actualizarReservacion, ReservacionesVO.class);				
		
		return reservacionService.actualizarReservacion(reservacionesVO);		
	}

	
	@ResponseBody
	@RequestMapping(value = "/reservacion", method = RequestMethod.GET)
	public Boolean reservacion(@RequestParam ("reservacion")String reservacion)throws Exception {
			
		Gson gson = new Gson();
		ReservacionesVO reservacionesVO = gson.fromJson(reservacion, ReservacionesVO.class);				
		
		return reservacionService.reservarCita(reservacionesVO);		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/cargarRerservaciones", method = RequestMethod.GET)
	public String cargarRerservaciones(@RequestParam ("cargarRerservaciones")String cargarRerservaciones) throws Exception {
		
		Gson gson = new Gson();
		Constantes constantes = new Constantes();
		
		//String json = "{\"monthly\":[{\"id\":1,\"name\":\"This is a JSON event\",\"startdate\":\"2016-9-15\",\"enddate\":\"2016-9-15\",\"starttime\":\"12:00\",\"endtime\":\"2:00\",\"color\":\"#FFB128\",\"url\":\"\"}]}";     
		
		
		List reservacionList = new ArrayList();
		List reservacionMonthList = new ArrayList();
		ReservacionesVO reservacion = null;
		ReservacionMonth reservacionMonth = null;
		
		reservacionList = reservacionService.cargarCitas();
		
		 Map<String,List<ReservacionMonth>> map=new HashMap<String,List<ReservacionMonth>>();			 		
		 		 
		 boolean fechasIguales= false;
		 boolean fechasIguales2= false;
		 boolean entrar= true;
		 Random  rnd = new Random();
		 
		 String fechaAnt = "";
		 int colorOP=0;
		 
		 Iterator ite = reservacionList.iterator();
		 
		 while(ite.hasNext()){
			 reservacion = new ReservacionesVO();
			 reservacionMonth = new ReservacionMonth();
			 
			 reservacion = (ReservacionesVO)ite.next();
			 
			 //Entrará solo la primera iteracion
			 if(!fechasIguales){
				 fechaAnt = reservacion.getFechaReservada();	
				 fechasIguales = true;
			 }
			 
			 //Entrará a partir de la segunda iteracion
			 if(fechasIguales2){
				 
				 if(fechaAnt.equals(reservacion.getFechaReservada())){
					 
					 reservacionMonth.setColor(Constantes.elegirColor(colorOP));
					 
				 }else{
					 
					// colorOP = (int)Math.random()*18+1;
					 colorOP =(int) rnd.nextInt(18)+1;
					 
					 reservacionMonth.setColor(Constantes.elegirColor(colorOP)); 
				 }
				 
				 fechaAnt = reservacion.getFechaReservada();
			 }
			 
			 String pattern = "yyyy-MM-dd";		
		 	 Date initDate = new SimpleDateFormat("yyyy/MM/dd").parse(reservacion.getFechaReservada());
		 	 
		     SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		     String parsedDate = formatter.format(initDate);
			 
			 reservacionMonth.setId(reservacion.getIdReservaciones());
			 reservacionMonth.setName(reservacion.getNombrePersona()+" : "+reservacion.getMotivo());
			 reservacionMonth.setStartdate(parsedDate);
			 reservacionMonth.setEnddate(parsedDate);
			 reservacionMonth.setStarttime(reservacion.getHoraIni());
			 reservacionMonth.setEndtime(reservacion.getHoraFin());
			 
			 
			 if(fechaAnt.equals(reservacion.getFechaReservada()) && entrar){

				 //Generacion aleatoria del numero del 1 al 18
				// colorOP = (int)(Math.random()*18+1);
				 colorOP =(int) rnd.nextInt(18)+1;
				 
				 reservacionMonth.setColor(Constantes.elegirColor(colorOP)); 
				 
				 fechasIguales2 = true;//se enciende bandera para comparar fechaAnt con FechaNueva
				 
				 entrar = false;//se apaga la bandera para que ya no entre a esta condicion
			 }
			 	
			 reservacionMonth.setUrl("");
			 
			 reservacionMonthList.add(reservacionMonth);
		 }
			 
		 map.put("monthly", reservacionMonthList);
		
		
		 String mapJson = gson.toJson(map);
		
		return mapJson;
	}
	
	
	@RequestMapping("/reagendarCita")
	public String reagendarCita(){
			
						
		
		return "reagendarCita";		
	}
	
	@RequestMapping("/catalogoPersonas")
	public String catalogoPersonas() {
		
		return "catalogoPersonas";
	}
	
	@RequestMapping("/consultaPersonas")
	public String consultaPersonas() {
		
		return "consultaPersonas";
	}
	
	@RequestMapping("/catalogoClientes")
	public String catalogoClientes() {
		
		return "catalogoClientes";
	}
	
	@RequestMapping("/catalogoEmpleados")
	public String catalogoEmpleados() {
		
		return "catalogoEmpleados";
	}
	
	@RequestMapping("/catalogoUsuarios")
	public String catalogoUsuarios() {
		
		return "catalogoUsuarios";
	}
	
	@RequestMapping("/catalogoProveedores")
	public String catalogoProveedores() {
		
		return "catalogoProveedores";
	}
}
