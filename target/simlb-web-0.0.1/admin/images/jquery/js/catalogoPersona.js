/**Luis eduardo Fernandez Samano
 *creado : 12/07//209
 *Descripcion: acceder al menu de personas
 */		

function consultarOp(op){
			
			if(typeof op.value !="undefined" && op.value!="0"){
				
				if(op.value=="1"){					
										
					$('#capaCuerpo').css("display", "block");
					$('#capaCuerpo2').css("display", "none");
					
				}else{
					
					
					$('#capaCuerpo').css("display", "none");
					$('#capaCuerpo2').css("display", "block");
					
					
					cargarMunicipios();
					
					
				}
			}
		}
	
	/*Devuelve la lista de municipios activos*/
	function cargarMunicipios(){
		
		$("#municipio-form").prop('disabled', false);
		$("#colonia-form").prop('disabled', true);
		
		
		this.borraListaMunicipios();
		this.borraListaColonias();
		
		cargarListaMunicipiosAjax();
	}
	
	/*Limpia la lista de municipios*/
	function borraListaMunicipios() {
		
		
		$('option', '#municipio-form').remove();
		
		$("#municipio-form").append("<option value='0' selected='selected' >- SELECCIONA MUNICIPIO -</option>");
	
					
	}

	function cargarListaMunicipiosAjax() {					
							
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "cargarMunicipiosActivos",
			//data : {cargarHorario:JSON.stringify(cargarHorarioForm)},
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				
				//habilitar combo colonias
				habilitarColonias();
				
				$.each(data,function(index,value)
	  			{	  					
					
	  				$('#municipio-form').append("<option value='"+value["idCatLocalidad"]+"'>"+value["descripcionLocalidad"]+"</option>");	  					  				
	  			});
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			}
		});

	}		
	
	function display(data) {
		alert("Respuesta : "+ JSON.stringify(data, null, 4));
		location.reload();					
	}
	
	//habilitar combo colonias
	function habilitarColonias(){
	
		$("#colonia-form").prop('disabled', false);
		
	}					
	
	/*Devuelve la lista de colonias activas ligadas a determinada localidad*/
	function cargarColonias(){
		
		//alert($("#municipio-form").val());
		
		var idLocalidad = $("#municipio-form").val();
		
		this.borraListaColonias();
		
		cargarListaColoniasAjax(idLocalidad);
	}
	
	/*Limpia la lista de colonias*/
	function borraListaColonias() {
		
		
		$('option', '#colonia-form').remove();
		
		$("#colonia-form").append("<option value='0' selected='selected' >- SELECCIONA COLONIA -</option>");
	
					
	}

	function cargarListaColoniasAjax(idLocalidad) {					
							
		var buscarColoniaByLocalidadForm = {};
		
				
		buscarColoniaByLocalidadForm["idCatLocalidad"] = idLocalidad;
		
		//alert(buscarColoniaByLocalidadForm["idCatLocalidad"]);
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "cargarColoniasActivas",
			data : {buscarColoniaByLocalidad:JSON.stringify(buscarColoniaByLocalidadForm)},
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				
				//habilitar combo colonias
				habilitarColonias();
				
				$.each(data,function(index,value)
	  			{	  					
										
	  				$('#colonia-form').append("<option value='"+value["idLocalidadDomicilio"]+"'>"+value["colonia"]+"</option>");	  					  				
	  			});
			},
				error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			}
		});

	}	
	
	
	function registrarPersona(){
		
		$("#registrarPersona-form").submit(function(event) {								
			// Prevent the form from submitting via the browser.
			event.preventDefault();

			registrarPersonaViaAjax();

		});
	}
	
	function registrarPersonaViaAjax() {

		if( $("#nombre-form").val().length < 1 || $("#apellido-form").val().length < 1 ||
			$("#sexo-form").val().length < 1 || $("#rol-form").val().length < 1  ||	$("#telefono-form").val().length < 1||
			$("#codigoPostal-form").val().length < 1 || $("#municipio-form").val().length < 1 || $("#colonia-form").val().length < 1 ){
			
			//Muestra la alerta de campos vacios
			document.getElementById("alerta-form-danger").style.display='block';
			
			//Oculta la alerta de infomacion
			document.getElementById("alerta-form-info").style.display='none';
			
		}else{
			var nombreCompleto = $("#nombre-form").val().toUpperCase()+ " "+$("#nombre2-form").val().toUpperCase()+
									" "+$("#apellido-form").val().toUpperCase()+" "+$("#apellido2-form").val().toUpperCase();
			var rol = "";
			var rolAux = "";
			var codigoUsuario="";//Campo de usuari
			var puestoOcupado="";//Campo de usuario
			var claveCliente = "";//campo de cliente
			var claveEmpleado = "";//campo de empleado
			
			var registrarPersonaForm = {};
			
			rol = $("#rol-form").val().toUpperCase();
			
			if(rol !="" && rol!= "0"){
				
				if(rol =="U"){
					
					rolAux ="USUARIO";
					codigoUsuario = $("#codigoUsuario-form").val().toUpperCase();
					puestoOcupado = $("#puestoOcupado-form").val().toUpperCase();
					
					registrarPersonaForm["codigoUsuario"] =codigoUsuario;
					registrarPersonaForm["puestoOcupado"] =puestoOcupado;
					
				}else if(rol =="C"){
					
					rolAux ="CLIENTE";
					claveCliente = $("#claveCliente-form").val().toUpperCase();
					registrarPersonaForm["claveCliente"] =claveCliente;
					
					
				}else if(rol =="E"){
					
					rolAux ="EMPLEADO";
					claveEmpleado = $("#claveEmpleado-form").val().toUpperCase();
					registrarPersonaForm["claveEmpleado"] =claveEmpleado;
				}
				
			}
			
			
			
			registrarPersonaForm["nombre"] =  $("#nombre-form").val().toUpperCase();
			registrarPersonaForm["nombre2"] =  $("#nombre2-form").val().toUpperCase();
			registrarPersonaForm["apellidoPaterno"] =  $("#apellido-form").val().toUpperCase();
			registrarPersonaForm["apellidoMaterno"] =  $("#apellido2-form").val().toUpperCase();
			registrarPersonaForm["nombreCompleto"] = nombreCompleto;
			registrarPersonaForm["sexo"] =  $("#sexo-form").val().toUpperCase();
			registrarPersonaForm["rol"] =  rolAux;
			registrarPersonaForm["telefono"] =  $("#telefono-form").val().toUpperCase();
			registrarPersonaForm["telefono2"] = $("#telefono2-form").val().toUpperCase();
			registrarPersonaForm["codigoPostal"] = $("#codigoPostal-form").val().toUpperCase();
			registrarPersonaForm["municipio"] = $("#municipio-form").val().toUpperCase();
			registrarPersonaForm["idLocalidadDomicilio"] = $("#colonia-form").val().toUpperCase();
			registrarPersonaForm["calle"] = $("#calle-form").val().toUpperCase();
			registrarPersonaForm["numeroInt"] = $("#numeroInt-form").val().toUpperCase();
			registrarPersonaForm["numeroExt"] = $("#numeroExt-form").val().toUpperCase();
			
			

			//Oculta la alerta de campos vacios
			document.getElementById("alerta-form-danger").style.display='none';
			
			//Muestra la alerta de infomacion
			document.getElementById("alerta-form-info").style.display='block';
			
			//Se limpia el formulario
			$(":text").each(function(){	
				$($(this)).val('');
			});
			
			//Se limpian el combos de municipios y colonias 			
			this.borraListaMunicipios();
			this.borraListaColonias();
						
			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "registrarPersona",
				data : {registrarPersona:JSON.stringify(registrarPersonaForm)},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					alert("registro exitoso");
					console.log("SUCCESS: ", data);				
					display(data);
				},
				error : function(e) {
					alert("error");
					console.log("ERROR: ", e);
					display(e);
				}
			});

		}		

		function display(data) {
			//alert("Respuesta : "+ JSON.stringify(data, null, 4));
			location.reload();					
		}

		}//Fin de la funcion
	
	//REGRESAR AL MENU PRINCIPAL DE PERSONAS
	function regresar(url){
	    document.getElementById("regresar-form").action = url;
	    document.forms[0].submit();
}	
	
	function habilitarCamposCliente(){
		
		
		//alert($("#rol-form option:selected").text());
		var rolPersona = "";
		
		rolPersona = $("#rol-form").val();
		
		if(rolPersona =="C"){
			$('#idCamposCliente').css("display", "block");
			$('#idCamposEmpleado').css("display", "none");
			$('#idCamposUsuario').css("display", "none");
			$('#idCamposUsuario2').css("display", "none");
		}else if(rolPersona =="E"){
			$('#idCamposEmpleado').css("display", "block");
			$('#idCamposCliente').css("display", "none");
			$('#idCamposUsuario').css("display", "none");
			$('#idCamposUsuario2').css("display", "none");
		}else if(rolPersona == "U"){
			$('#idCamposUsuario').css("display", "block");
			$('#idCamposUsuario2').css("display", "block");
			$('#idCamposCliente').css("display", "none");
			$('#idCamposEmpleado').css("display", "none");
		}
	}
