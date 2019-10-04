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
	
		<link rel="stylesheet" href="admin/images/jquery/css/monthly.css">	
			     		  
		
		<!--inicio Requeridos para el modal -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">  
 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>     
        <script type="text/javascript" src="admin/images/jquery/js/reagendarDia.js"></script>
        
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
	
	
	<!-- POPUP ACTUALIZAR RESERVACION -->
		
		 <div id="popupEditarCita">
		    <div class="content-popup"> 
		       
		      	<div id="popupEditarCitaTitulo">
		      		 <center><h3><b>REAGENDAR CITA</b></h3></center>
		      		
		      		
		      	</div>
		      	 <center><hr style="border-color:#585858; width:900px;"></center>
		      	<div id="alerta-form-danger-horarioDisp" style="display: none;">
					<div class="alert alert-danger" role="alert"><strong>Horarios agotados para esta fecha!!</strong></div>
				</div>
		
		      	<div class="alert alert-success" role="alert" id="alerta-reagendar-exito" style="display: none;">
 					   Reservacion <strong>actualizada!</strong>
				</div>
				<div class="alert alert-danger" role="alert" id="alerta-reagendar-error" style="display: none;"> 					 
 					  Existen campos <strong>vacios!</strong>
				</div>
		      	
		    <div id="centrarFormulario"> 
		       
		          	<div class="form-group col-2">
           							 <hr style="width:500px; position:absolute;top:100px;border-color:#D4D2D2;">
   				 	</div>    	
        	
        	 <form class="form-horizontal"  id="reagendarCita-form">
        	
        	
        				
        		   	
        		<table id="tablaEditarCita">
        			
        		 	
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr>
        		    <tr>
        		    	<td>        		    		        		    	
        		    		<label style="text-transform:uppercase;">Nombre :</label><input type="text" class="form-control" id="nombre-form" placeholder="Nombre" style="text-transform:uppercase; width:250px; height:30px; font-size: 15px;font-family: arial;" onkeyup="javascript:this.value=soloTexto(this.value);" value="${horariosReserv.reservaciones.nombrePersona}">
        		    	</td>
        		   
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		   
        		    	<td>        		    		        		    	
        		    		<label style="text-transform:uppercase;">Motivo :</label><input type="text" class="form-control" id="motivo-form" placeholder="Motivo" style="text-transform:uppercase;width:250px; height:30px; font-size: 15px;font-family: arial;" onkeyup="javascript:this.value=NumText(this.value);" value="${horariosReserv.reservaciones.motivo}">
        		    		
        		    		
        		    	</td>
        		    	
        		    
        		   
        		   </tr>
        		   <tr>
        		   		
        		   		<td>
        		   			<br><br> 
        		   		    <div class="form-check" >
  								<input class="form-check-input position-static" type="checkbox" id="idEditarFechayHora" value="0" aria-label="..." onclick="habilitarFechaReservada();"> <p style="font-size: 15px; display:inline;">CAMBIAR FECHA Y HORARIOS </p>
							</div>							
        		   		</td>
        		   		
        		   </tr>
        		  
        		    <tr>       		    
        		    	<td>  
        		    		<br><br>      		    		
        		    		<label style="text-transform:uppercase;">Fecha a Agendar :</label><input type="text" class="form-control" id="datepicker2" style="width:250px; height:30px; text-transform:uppercase;" placeholder="aaaa/mm/dd" readonly="readonly" disabled onChange="habilitarHorario();"/>
        		    	</td>
        		   	
        		    
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		        
        		    	<td>		
        		    		<br>	<br>    
        		 				<label style="text-transform:uppercase;">Hora inicio :</label>		
							<select id="hora-form" name="hora-form" style="width:265px; height:40px; font-size: 15px;font-family: arial;text-transform:uppercase;"  disabled onChange="obtenerHoraFin();">
								<option value="0" selected="selected" >Seleccionar Hora...</option>
							</select> 
						</td>								
        		    </tr> 			    		    	  
 					<tr> 
        		    	
        		        
        		    	<td>		
        		    		<br><br>        		
        		    				
        		 			<label style="text-transform:uppercase;">Hora fin :</label>							
							 <select id="hora-form2" name="hora-form2" style="width:265px; height:40px; font-size: 15px;font-family: arial;text-transform:uppercase;" disabled onChange="adminAlertas();">
								<option value="0" selected="selected" >Seleccionar Hora...</option>	
							</select> 
						</td>								
        		   
        		   	    <td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		   
        		    	<td>
        		    		<br><br>    
        		    		<label style="color:white;">Reagendar</label>	
        		    		<button type="submit" id="reagendarCita-form" class="btn btn-success" style="width:265px; height:40px; font-weight: lighter;text-align:center;font-size: 18px;"><b>Actualizar</b></button>
        		    	    		    	        		    		  
        		    	</td>
        		    </tr>
        		    
			   </table>
			   
			   
			   
			   <p>
					<a class="btn btn-primary" style="position:absolute;top:47px;left:590px; width:100px;height:29px; font-size: 15px; " class="btn btn-primary" href="<c:url value="/reagendarCita"/>" role="button"><b>Regresar</b></a>
			   </p>
			   
			   
			    <div id="idHorariosReservados" style="display: none;">
			    ${horariosReserv.idHorariosReservados}
			    </div>
			     <div id="idReservaciones" style="display: none;">
			     ${horariosReserv.reservaciones.idReservaciones}
			    </div>
        	</form> 
        	
        	</div>  
		      	        
		      	</div>
			    			           	        	        

		</div> 	 
		
	</div>	
</body>
</html>