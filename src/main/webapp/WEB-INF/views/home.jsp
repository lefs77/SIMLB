<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

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
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap-responsive.css">
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.css"/>
        <link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="admin/images/css/bootstrap-datetimepicker.min.css"/>  
            
        
         <link rel="stylesheet"	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		 <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		
		 <script type="text/javascript"	src="admin/images/jquery/js/jquery.ui.datepicker.validation.js"></script>
		 <script type="text/javascript" src="admin/images/jquery/js/jquery.modal.js" charset="utf-8"></script>
		 <link type="text/css" rel="stylesheet" href="admin/images/jquery/css/jquery.modal.css">     
         <link rel="SHORTCUT ICON" href="admin/images/favicon.gif">              
      	
      	
      	
      	<link href="https://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" rel="stylesheet" type="text/css">
		
		<link type="text/css" rel="stylesheet" href="admin/images/css/botonBuscar.css">
		<link type="text/css" rel="stylesheet" href="admin/images/css/tablaPersonas.css">
		<link type="text/css" rel="stylesheet" href="admin/images/css/popupPersona.css">
		<link type="text/css" rel="stylesheet" href="admin/images/css/plantillaPicker.css">
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.css">
	
		<link rel="stylesheet" href="admin/images/jquery/css/monthly.css">		     		  
		
		<!--inicio Requeridos para el modal -->
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">  
 		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 		<script type="text/javascript" src="admin/images/jquery/js/catalogoPersona.js"></script>   
        <script type="text/javascript" src="admin/images/jquery/js/registrarPersona.js"></script>
        <script type="text/javascript" src="admin/images/jquery/js/calendarioSIMLB.js"></script>
        <script type="text/javascript" src="admin/images/jquery/js/monthly.js"></script>
      
        <script type="text/javascript" src="admin/images/jquery/js/agendarDia.js"></script>
       
		<meta charset="ISO-8859-1">
		
		<title>SIMLB</title>
	</head>
    <body>       
        <div id="capaTituloAPP">SIMLB(Sistema Inventario Muebleria y Linea Blanca)</div>
			<div id="capaMenuGral">
			<p align="center"><font size="4">Menu Principal</font></p>
			<ul>
				<li type="square"><a href="catalogoPersonas" style="color:#FFFFFF;"><font size="1">Catalogo de Personas</font></a></li>
				<ol>
					<li type="circle"><a href="catalogoClientes" style="color:#FFFFFF;"><font size="1">Clientes</font></a></li>
					<li type="circle"><a href="catalogoEmpleados" style="color:#FFFFFF;"><font size="1">Empleados</font></a></li>
					<li type="circle"><a href="catalogoUsuarios" style="color:#FFFFFF;"><font size="1">Usuarios</font></a></li>
				</ol>
				<li type="circle"><a href="catalogoProveedores" style="color:#FFFFFF;"><font size="1">Catalogo de Proveedores</font></a></li>			
				
			</ul>
		</div>
		
		<div id="calendario">
				
				<div style="display:inline-block;">
					<div class="monthly" id="mycalendar"></div>
				</div>				
		</div>		
				
		<div id="alerta-form-danger-horarioDisp" style="display: none;">
			<div class="alert alert-danger" role="alert">Horarios agotados para esta fecha!!</div>
		</div>
			
		<div id="alerta-form-danger2" style="display: none;">
			<div class="alert alert-danger" role="alert">Existen campos vacios!!</div>
		</div>
		
	  	<div id="alerta-form-info2">
	  		<div class="alert alert-info" role="alert"><b>Agendar d&iacute;a</b></div>
	  	</div>
		 <div id="page2">        	
        	
        	 <form class="form-horizontal"  id="reservarCita-form">
        	
        	
        				
        		   	
        		<table >
        			
        		 	
        		    <tr>
        		    	<td>        		    		        		    	
        		    		<input type="text" class="form-control" id="nombre-form" placeholder="Nombre" style="text-transform:uppercase; width:250px; height:30px;" onkeyup="javascript:this.value=soloTexto(this.value);">
        		    	</td>
        		    </tr> 
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr> 		
        		     <tr>
        		    	<td>        		    		        		    	
        		    		<input type="text" class="form-control" id="motivo-form" placeholder="Motivo" style="text-transform:uppercase;width:250px; height:30px;" onkeyup="javascript:this.value=NumText(this.value);">
        		    		
        		    		
        		    	</td>
        		    </tr> 
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr>          		    		   
        		    <tr>        		    
        		    	<td>        		    		
        		    		<input type="text" class="form-control" id="datepicker" style="width:250px; height:30px;" placeholder="aaaa/mm/dd" readonly="readonly" onChange="habilitarHorario();"/>
        		    	</td>
        		    </tr>	
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr> 			    		    	  
 					<tr>     
        		    	<td>		    
        		 											
							<select id="hora-form" name="hora-form" disabled onChange="obtenerHoraFin();">
								<option value="0" selected="selected" >Hora inicio...</option>
							</select> 
						</td>								
        		    </tr>	
        		     <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr>		
        		    <tr>     
        		    	<td>		    														
							 <select id="hora-form2" name="hora-form2" disabled onChange="adminAlertas();">
								<option value="0" selected="selected" >Hora fin...</option>
							</select> 
						</td>								
        		    </tr>		
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr>				    	    
				    <tr>
        		    	<td>
        		    		<button type="submit" id="reservarCita-form" class="btn btn-primary btn-lg">Agendar</button>
        		    	           		    	        		    		  
        		    	</td>
        		    </tr>
        		    <tr>
        		    	<td>
        		    		&nbsp;&nbsp;&nbsp;
        		    	</td>
        		    </tr> 	
        		    <!-- <tr>
        		    	<td>
        		    		<input type="button" value="Regresar" id="regresar-form" class="btn btn-default btn-lg" onclick="regresar('/');" />
        		    	</td>
        		    </tr>	-->
			   </table>
			    
        	</form> 
        	
        	</div>  
        	<div id="page3">        	
        	
	        	 <form class="form-horizontal"  id="reagendarCita-form">
	        	
	        		<table >
	        			<tr>
	        				<td id="alerta-form-info">
	        		    		 <button type="button" id="id_btn-warning" class="btn btn-warning" onclick="reagendar('reagendarCita');"><strong>Reagendar d&iacute;a</strong></button>
	        		    		<!--  <a class="btn btn-warning" href="reagendarCita" role="button"><strong>Reagendar d&iacute;a</strong></a> -->
	        		    	</td>
	        		    </tr> 	
	        		</table>
	        		
				 </form>
				 
			</div>     		
    </body>
</html>
