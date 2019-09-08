<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap-responsive.css">
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.css"/>
        <link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.min.css"/>
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
 		<script type="text/javascript" src="admin/images/jquery/js/catalogoPersona.js"></script>      
        <script type="text/javascript" src="admin/images/jquery/js/consultarPersona.js"></script>
        <script type="text/javascript" src="admin/images/jquery/js/registrarPersona.js"></script>
        
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
		
		<div id="capaCuerpo">
				<center><h3>BUSCAR CLIENTE</h3></center>
				<hr style="border-color:#585858; width:900px;">
				
				<div id="idBotonBsucar">
					<form id="searchbox" action="">
						<div id="posicionLabelParametros">Buscar por: <br>Fecha Alta / Clave / Nombre : </div>
						<div id="posicionDatepicker" class="pickerFondo"><input type="text" id="datepicker" name="datepicker" placeholder="aaaa/mm/dd" style="text-align: center" readonly="readonly"/></div>
						<input id="nombreCliente" type="text" placeholder="Nombre completo"  onkeyup="javascript:this.value=this.value.toUpperCase();"> 
						<br>
						<input id="claveCliente" type="text" placeholder="Clave"  onkeyup="javascript:this.value=this.value.toUpperCase();">
						<input	id="buscarCliente" type="submit" value="Buscar" >			
					</form>
				</div>     
				
				
				
				
				<div id="idTablaClientes">
					<table id="tablaCliente" WIDTH="100%">
						<tr>
							<th id="tituloIni"width="35%">NOMBRE/APELLIDO</th>							
							<th id="titulo2">CLAVE</th>
							<th id="titulo2">ESTATUS</th>			
						</tr>
					</table>
				</div>
		 </div>
	</div> 		
	</div>	
	<!-- POPUP DETALLE PERSONAS -->
		
		<div id="popupDetalleClientes" style="display: none;">
		    <div class="content-popup">
		        <div class="close2"><a href="#" id="close2"><img src="admin/images/close.png"/></a></div>			        
		        
		       
		      
		      	<div style="position: relative; 
		      		 text-align:center; margin-bottom: 10px;
		      		 font-size: 20px;"
		      		 class="td2"><b>DETALLE DEL CLIENTE</b>
		      		 <center><hr style="border-color:#585858; width:300px;"></center>
		      	</div>
		      	
		           <div id="idTablaDetalleCliente">          
						<table id="tablaCliente2" width="100%;" border="2px;">
							<tr>  
								<th id="tituloIniDos" width="20%">NOMBRE</th>					
								<th id="tituloDos">FECHA ALTA</th>
								<th id="tituloDos">USUARIO ALTA</th>	
								<th id="tituloDos">FECHA ACTUALIZACION</th>																		
								<th id="tituloFinDos">USUARIO ACTUALIZACION</th>
							</tr>						
						</table>
					</div>        
		      	        
		      	</div>
						    			           	        	        

		</div> 		
</body>
</html>