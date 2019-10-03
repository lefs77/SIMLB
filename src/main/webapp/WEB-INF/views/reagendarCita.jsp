<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

		<script type="text/javascript" src="admin/images/jquery/js/jquery.js"></script>
    	<script type="text/javascript" src="admin/images/jquery/js/jquery.min.js"></script>
    	<script type="text/javascript" src="admin/images/bootstrap/js/bootstrap.min.js"></script>                 
    	<script type="text/javascript" src="admin/images/jquery/js/bootstrap-datetimepicker.js"></script>
    	<script type="text/javascript" src="admin/images/jquery/js/bootstrap-datetimepicker.min.js"></script>
    	<script type="text/javascript" src="admin/images/jquery/js/jquery-ui-timepicker-addon.js"></script>
    	<script type="text/javascript" src="admin/images/jquery/js/jquery.timepicker.js"></script>
    	<script type="text/javascript" src="admin/images/picker.js"></script>
        <script type="text/javascript" src="admin/images/bootstrap/js/bootstrap.min.js"></script>
        
        
        
        <link type="text/css" rel="stylesheet" href="admin/images/css/principal.css">  
        <link type="text/css" rel="stylesheet" href="admin/images/css/jquery.timepicker.css">        
        <link type="text/css" rel="stylesheet" href="admin/images/css/bootstrap-datetimepicker.css">
        <link type="text/css" rel="stylesheet" href="admin/images/jquery/css/jquery.timepicker.css">
		
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap-responsive.min.css">


        <link type="text/css" rel="stylesheet" href="admin/images/css/bootstrap-datetimepicker.min.css"/>  
            
         <link rel="stylesheet"	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		
		 <script type="text/javascript"	src="images/jquery/js/jquery.ui.datepicker.validation.js"></script>
		 <script type="text/javascript" src="images/jquery/js/jquery.modal.js" charset="utf-8"></script>
		 <link type="text/css" rel="stylesheet" href="admin/images/jquery/css/jquery.modal.css">     
         <link rel="SHORTCUT ICON" href="admin/images/favicon.gif">              
      	
      	
      	
      	<link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" rel="stylesheet" type="text/css">
		
		<link type="text/css" rel="stylesheet" href="admin/images/css/botonBuscar.css">
		<link type="text/css" rel="stylesheet" href="admin/images/css/tablaPersonas.css">
		<link type="text/css" rel="stylesheet" href="admin/images/css/popupPersona.css">
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.css">
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.min.new.css">
		
		<link type="text/css" rel="stylesheet" href="admin/images/jquery/js/confirm/dist/jquery-confirm.min.css">
		<script type="text/javascript" src="admin/images/jquery/js/confirm/dist/jquery-confirm.min.js"></script>   
	
		<link rel="stylesheet" href="admin/images/jquery/css/monthly.css">	
			     		  
		
		<!--inicio Requeridos para el modal -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">  
 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 		<script type="text/javascript" src="admin/images/jquery/js/catalogoPersona.js"></script>      
        <script type="text/javascript" src="admin/images/jquery/js/reagendarDia.js"></script>
        <script type="text/javascript" src="admin/images/jquery/js/registrarPersona.js"></script>
        <script type="text/javascript" src="admin/images/jquery/js/paginador.js"></script>
        
		<meta charset="ISO-8859-1">
		<title>SIMLB</title>
				
</head>
<body>
<div id="fondoTransparente" >
		<div id="capaTituloAPP">SIMLB(Sistema Inventario Muebleria y Linea Blanca)</div>
	<div id="capaMenuGral">
		<p align="center"><font size="4">Menu Principal</font></p>
		<ul>
			<li type="square"><a href="./." style="color:#FFFFFF;"><font size="1">Inicio</font></a></li>
			<li type="square"><a href="catalogoPersonas" style="color:#FFFFFF;"><font size="1">Catalogo de Personas</font></a></li>
			<ol>
				<li type="circle"><a href="catalogoClientes" style="color:#FFFFFF;"><font size="1">Clientes</font></a></li>
				<li type="circle"><a href="catalogoEmpleados" style="color:#FFFFFF;"><font size="1">Empleados</font></a></li>
				<li type="circle"><a href="catalogoUsuarios" style="color:#FFFFFF;"><font size="1">Usuarios</font></a></li>
			</ol>
			<li type="circle"><a href="catalogoProveedores" style="color:#FFFFFF;"><font size="1">Catalogo de Proveedores</font></a></li>			
			
		</ul>
	</div>
	
	
	<div id="capaCuerpoPrincipal">		
		
		<div id="capaCuerpo3">
				<center><h3><b>REAGENDAR DIA</b></h3></center>
				<hr style="border-color:#585858; width:900px;">
				
				<div id="idBotonBsucarReagendar">
					<form id="searchboxReagendar" action="">
						<div id="posicionLabelParametros">Buscar por: <br>Todo / Fecha / Nombre  </div>
						<div id="posicionDatepickerReagendar" class="pickerFondoReagendar"><input type="text" id="datepickerReagendar" name="datepicker" placeholder="aaaa/mm/dd" style="text-align: center" readonly="readonly"/></div>
						<input id="nombrePersonaReagendar" type="text" placeholder="Nombre completo"  onkeyup="javascript:this.value=soloTexto(this.value);"> 
						<input	id="buscarPersonaReagendar" type="submit" value="Buscar" >			
					</form>
				</div>     
				
				<div id="idBotonBuscarTodo">
					<form id="searchbox2" action="">
						<input	id="buscarAllAgendas" type="checkbox" >			
					</form>
				</div>
				
				</div>
				<div id="capaCuerpoReagendar">
				<div id="idTablaPersonas">
					
					<div class="container" id="tablaPersona">
					<div class="panel panel-primary">
							<!-- <div class="panel-heading">
								<c:out value="${titulo}" />
							</div>-->
							<div class="panel-body">
								<div class="container">
									<div class="row">
				
										<table  id="tablaReagendar" style="width:900px;"
											class="table table-striped table-hover table-bordered">
											
												<tr>
													<th id="tituloIni"width="35%">NOMBRE/APELLIDO</th>							
													<th id="titulo2">FECHA RESERVACION</th>
													<th id="titulo3">MOTIVO</th>
													<th id="titulo3">HORA INICIO</th>
													<th id="titulo3">HORA FIN</th>
													<th id="titulo3">EDITAR</th>
													<th id="tituloFin">ELIMINAR</th>		
												</tr>
											
												<c:forEach items="${reservaciones}" var="reservacion">
													<tr>
														<td><c:out value="${reservacion.nombrePersona}" /></td>
														<td><c:out value="${reservacion.fechaReservada}" /></td>
														<td><c:out value="${reservacion.motivo}" /></td>
														<td><c:out value="${reservacion.horaIni}" /></td>
														<td><c:out value="${reservacion.horaFin}" /></td>
														
														<td><a class="btn-xs btn-primary" 
															href="<c:url value="/editarCita.htm?id=${reservacion.idHorariosReservados}"/>">editar</a></td>
														<td><a class='btn-xs btn-danger' onclick="eliminarCitaJsp(${reservacion.idHorariosReservados});" href='#'>eliminar</a></td></tr>
													</tr>
												</c:forEach>
												
										</table>
										<div id="paginadorReagendar">${pager}</div>
									</div>
								</div>
							</div>
						</div>
						</div><!-- FIN CONTENEDOR -->
				</div>
		 </div>
	</div> 		
	</div>	
	<!-- POPUP ACTUALIZAR RESERVACION -->
		
		 <div id="popupDetallePersonas" style="display: none;">
		    <div class="content-popup">
		        <div class="close2"><a href="#" id="close2"><img src="admin/images/close.png"/></a></div>			        
		        
		       
		      
		      	<div style="position: relative; 
		      		 text-align:center; margin-bottom: 10px;
		      		 font-size: 20px;"
		      		 class="td2"><b>ACTUALIZAR RESERVACION</b>
		      		 <center><hr style="border-color:#585858; width:300px;"></center>
		      	</div>
		      	
		      	<div id="alerta-form-danger-horarioDisp" style="display: none;">
					<div class="alert alert-danger" role="alert"><strong>Horarios agotados para esta fecha!!</strong></div>
				</div>
		
		      	<div class="alert alert-success" role="alert" id="alerta-reagendar-exito" style="display: none;">
 					   Reservacion <strong>actualizada!</strong>
				</div>
				<div class="alert alert-danger" role="alert" id="alerta-reagendar-error" style="display: none;"> 					 
 					  Existen campos <strong>vacios!</strong>
				</div>
		      	
		          <div>        	
        	
        	 <form class="form-horizontal"  id="reagendarCita-form">
        	
        	
        				
        		   	
        		<table id="tabla">
        			
        		 	
        		    <tr>
        		    	<td>        		    		        		    	
        		    		<input type="text" class="form-control" id="nombre-form" placeholder="Nombre" style="text-transform:uppercase; width:250px; height:30px;" onkeyup="javascript:this.value=soloTexto(this.value);">
        		    	</td>
        		   
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		   
        		    	<td>        		    		        		    	
        		    		<input type="text" class="form-control" id="motivo-form" placeholder="Motivo" style="text-transform:uppercase;width:250px; height:30px;" onkeyup="javascript:this.value=NumText(this.value);">
        		    		
        		    		
        		    	</td>
        		   
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		            		    
        		    	<td>        		    		
        		    		<input type="text" class="form-control" id="datepicker2" style="width:210px; height:30px;" placeholder="aaaa/mm/dd" readonly="readonly" onChange="habilitarHorario();"/>
        		    	</td>
        		    </tr>	
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr> 			    		    	  
 					<tr>     
        		    	<td>		    
        		 											
							<select id="hora-form" name="hora-form" style="width:265px; height:40px;"  disabled onChange="obtenerHoraFin();">
								<option value="0" selected="selected" >Hora inicio...</option>
							</select> 
						</td>								
        		    
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		        
        		    	<td>		    														
							 <select id="hora-form2" name="hora-form2" style="width:265px; height:40px;" disabled onChange="adminAlertas();">
								<option value="0" selected="selected" >Hora fin...</option>
							</select> 
						</td>								
        		   
        		   	    <td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    
        		    	<td>
        		    		<button type="submit" id="reservarCita-form" class="btn btn-success btn-lg" style="width:230px; height:40px;"><strong>Reagendar</strong></button>
        		    	           		    	        		    		  
        		    	</td>
        		    </tr>
        		    
			   </table>
			    <div id="idHorariosReservados" style="display: none;">
			    </div>
			     <div id="idReservaciones" style="display: none;">
			    </div>
        	</form> 
        	
        	</div>  
		      	        
		      	</div>
			    			           	        	        

		</div> 	 	
</body>
</html>