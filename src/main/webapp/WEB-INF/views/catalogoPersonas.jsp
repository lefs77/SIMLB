<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<link type="text/css" rel="stylesheet" href="admin/images/bootstrap/css/bootstrap.min.new.css">
		
		<link type="text/css" rel="stylesheet" href="admin/images/jquery/js/confirm/dist/jquery-confirm.min.css">
		<script type="text/javascript" src="admin/images/jquery/js/confirm/dist/jquery-confirm.min.js"></script>   
	
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
	
	<!-- <div id="idOpcionesPersona">
			<select name="opcionesPersona" id="opcionesPersona" onchange="consultarOp(this)">
				<option value="0" selected>Selecciona la opcion deseada</option>
				<option value="1">Consultar Persona</option>
				<option value="2">Dar de alta Persona</option>				
			</select>
		</div>-->
	
	<div id="capaCuerpoPrincipal">		
		
		<div id="capaCuerpo">
				<center><h3><b>BUSCAR PERSONA</b></h3></center>
				<hr style="border-color:#585858; width:900px;">
				
				<!-- <div id="idBotonBsucar">
					<form id="searchbox" action="">
						<div id="posicionLabelParametros">Buscar por: <br>Fecha Alta / Nombre : </div>
						<div id="posicionDatepicker" class="pickerFondo"><input type="text" id="datepicker" name="datepicker" placeholder="aaaa/mm/dd" style="text-align: center" readonly="readonly"/></div>
						<input id="nombrePersona" type="text" placeholder="Nombre completo"  onkeyup="javascript:this.value=this.value.toUpperCase();"> 
						<input	id="buscarPersona" type="submit" value="Buscar" >			
					</form>
				</div>  -->   
				
				<div id="idBotonBsucarPersonas">
					<form id="searchboxConsultarPersonas" action="">
						<div id="posicionLabelParametros">Buscar por: <br>Fecha Alta / Nombre : </div>
						<div id="posicionDatepickerBuscarPersonas" class="pickerFondoBuscarPersonas"><input type="text" id="datepickerBuscarPersonas" name="datepickerBuscarPersonas" placeholder="aaaa/mm/dd" style="text-align: center" readonly="readonly"/></div>
						<input id="nombrePersonaBuscarPersonas" type="text" placeholder="Nombre completo"  onkeyup="javascript:this.value=this.value.toUpperCase();"> 
						<input	id="buscarPersonaBuscarPersonas" type="submit" value="Buscar" >							 		
					</form>
					
				</div>     
				<div id=idBotonAddPersonas>
					<button type="button" class="myButton">Alta Personas</button>
				</div>
				
				<div id="idTablaPersonas">
					<table id="tablaPersona" WIDTH="100%">
						<tr>
							<th id="tituloIni"width="35%">NOMBRE/APELLIDO</th>							
							<!--  <th id="titulo2">SEXO</th>-->
							<th id="titulo2">ESTATUS</th>
							<th id="titulo3">TELEFONOS</th>
							<th id="tituloFin">ROL</th>					
						</tr>
					</table>
				</div>
		 </div>
		 
		 <div id="capaCuerpo2">
				<center><h3>REGISTRAR PERSONA</h3></center>
				<hr style="border-color:#585858; width:900px;">							
				
				    	
        	
	        	 <form class="form-horizontal"  id="registrarPersona-form">
	        	
	        		<table id="idTablaRegistrarPersona">
	        			<tr>
	        				<td id="alerta-form-danger" style="display: none;">
	        					<div class="alert alert-danger" role="alert">Existen campos vacios!!</div>
	        				</td>
	        				<td id="alerta-form-danger-telefono" style="display: none;">
	        					<div class="alert alert-danger" role="alert">El telefono no puede ser menor a 10 digitos!!</div>
	        				</td>
	        				
	        		    	 <td id="alerta-form-info">
	        		    		<div class="alert alert-info" role="alert" style="display: block;"><b>Datos Generales</b></div>
	        		    	</td>
	        		    </tr> 
	        		    <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr>
	        		    <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 	
	        		 	<tr>
	        		    	<td>        		    		        		    	
	        		    		<input type="text" class="form-control" id="nombre-form" placeholder="Primer Nombre" maxlength="20" style="text-transform:uppercase;width:200px;" onkeyup="javascript:this.value=soloTexto(this.value);">
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    		<input type="text" class="form-control" id="nombre2-form" placeholder="Segundo Nombre" maxlength="20" style="text-transform:uppercase;" onkeyup="javascript:this.value=soloTexto(this.value);">
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    		<input type="text" class="form-control" id="apellido-form" placeholder="Apellido Paterno" maxlength="20" style="text-transform:uppercase;" onkeyup="javascript:this.value=soloTexto(this.value);">
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    		<input type="text" class="form-control" id="apellido2-form" placeholder="Apellido Materno" maxlength="20" style="text-transform:uppercase;" onkeyup="javascript:this.value=soloTexto(this.value);">
	        		    	</td>
	        		    </tr> 
	        		    <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 		
	        		     <tr>
	        		    	<td>        		    		        		    	
	        		    		<select id="sexo-form" name="sexo-form">
									<option value="0" selected="selected" >- SEXO -</option>
									<option value="M">MASCULINO</option>
									<option value="F">FEMENINO</option>
								</select> 
	        		    		
	        		    	</td>	        		    		        		    
							
							<td>        		    		        		    	
	        		    		<select id="rol-form" name="rol-form" onChange="habilitarCamposCliente();">
									<option value="0" selected="selected" >- ROL PERSONA -</option>
									<option value="U">USUARIO</option>
									<option value="C">CLIENTE</option>
									<option value="E">EMPLEADO</option>
								</select> 
	        		    		
	        		    	</td>
	        		    	<td id="idCamposCliente" style="display: none;">
	        		    		<input type="text" class="form-control" id="claveCliente-form" placeholder="Clave Cliente" maxlength="10" style="text-transform:uppercase;" onkeyup="javascript:this.value=NumText(this.value);">
	        		    	</td>
	        		    	<td id="idCamposEmpleado" style="display: none;">
	        		    		<input type="text" class="form-control" id="claveEmpleado-form" placeholder="Clave Empleado" maxlength="10" style="text-transform:uppercase;" onkeyup="javascript:this.value=NumText(this.value);">
	        		    	</td>
	        		    	<td id="idCamposUsuario" style="display: none;">
	        		    		<input type="text" class="form-control" id="codigoUsuario-form" placeholder="Codigo Usuario" maxlength="10" style="text-transform:uppercase;" onkeyup="javascript:this.value=NumText(this.value);">	        		    		
	        		    	</td>	        		   
	        		    	<td id="idCamposUsuario2" style="display: none; position:absolute;top:210px;right:32px;">
	        		    		<input type="text" class="form-control" id="puestoOcupado-form" placeholder="Puesto Ocupado" style="text-transform:uppercase;" onkeyup="javascript:this.value=soloTexto(this.value);" >
	        		    	</td>	
	        		    </tr> 
	        		    <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 
	        		    <tr>
	        		    	<td><input type="text" class="form-control"
								id="telefono-form" placeholder="Primer Telefono"
								maxlength="10"
								onkeyup="javascript:this.value=Numeros(this.value);">
							</td>
	        		    	
	        		    	<td><input type="text" class="form-control"
								id="telefono2-form" placeholder="Segundo Telefono"
								maxlength="10"
								onkeyup="javascript:this.value=Numeros(this.value);">
							</td>
							<td>        		    		        		    	
	        		    							      
							      <input type="text" class="form-control" id="codigoPostal-form" placeholder="Codigo Postal" maxlength="7"  onkeyup="javascript:this.value=Numeros(this.value);">
							   	  
	        		    	</td>
	        		    </tr>	
	        		    <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 	
	        		    <tr>
	        		    	<td>        		    		        		    	
	        		    		<select id="municipio-form" name="municipio-form" disabled onChange="cargarColonias();">
									<option value="0" selected="selected" >- SELECCIONA MUNICIPIO -</option>									
								</select> 						
	        		    		
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    		
	        		    		<select id="colonia-form" name="colonia-form" disabled onChange="cargarCalles();">
									<option value="0" selected="selected" >- SELECCIONA COLONIA -</option>									
								</select> 
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    		<input type="text" class="form-control" id="calle-form" maxlength="50" placeholder="Calle" style="text-transform:uppercase;" onkeyup="javascript:this.value=soloTexto(this.value);">
	        		    	</td>
	        		    </tr>
	        		     <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 		
	        		    <tr>	        		    	
	        		    	<td>        		    		        		    	
	        		    							      
							      <input type="text" class="form-control" id="numeroInt-form" placeholder="Numero Int." maxlength="5"  onkeyup="javascript:this.value=Numeros(this.value);">
							    
	        		    	</td>
	        		    	<td>        		    		        		    	
	        		    							      
							      <input type="text" class="form-control" id="numeroExt-form" placeholder="Numero Ext." maxlength="5"  onkeyup="javascript:this.value=Numeros(this.value);">
							   	  
	        		    	</td>
	        		    	
	        		    </tr> 
	        		   <tr>
	        		    	<td>
	        		    		&nbsp;&nbsp;&nbsp;
	        		    	</td>
	        		    </tr> 
	        		    
					    <tr>
	        		    	<td>
	        		    		<button type="submit" id="registrarPersona-form" style="position:absolute;top:430px;right:130px; width:170px;"class="btn btn-primary btn-lg" onclick="registrarPersona();">Registrar</button>
	        		    	
	        		    		<input type="button" value="Regresar" id="regresar-form" style="position:absolute;top:430px;right:35px;" class="btn btn-default btn-lg" onclick="regresar('/');" />
	        		    	        		    		  
	        		    	</td>
	        		    </tr>	
				   </table>
				    
	        	</form> 
        	
        	  
				
														
			</div>				
	</div> 		
	</div>	
	<!-- POPUP DETALLE PERSONAS -->
		
		<div id="popupDetallePersonas" style="display: none;">
		    <div class="content-popup">
		        <div class="close2"><a href="#" id="close2"><img src="admin/images/close.png"/></a></div>			        
		        
		       
		      
		      	<div style="position: relative; 
		      		 text-align:center; margin-bottom: 10px;
		      		 font-size: 20px;"
		      		 class="td2"><b>DETALLE DE LA PERSONA</b>
		      		 <center><hr style="border-color:#585858; width:300px;"></center>
		      	</div>
		      	
		           <div id="idTablaDetallePersona">          
						<table id="tablaPersona2" width="100%;" border="2px;">
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