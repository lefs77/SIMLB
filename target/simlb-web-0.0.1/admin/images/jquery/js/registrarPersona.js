/**Luis eduardo Fernandez Samano
 *creado : 12/07//209
 *Descripcion: Registra a las personas
 */		
		/*function registrarViaAjax() {

			if( $("#nombre-form").val().length < 1 || $("#apellido-form").val().length < 1 ||
				$("#sexo-form").val().length < 1 || $("#rol-form").val().length < 1  ||	$("#telefono").val().length < 1||
				$("#codigoPostal-form").val().length < 1 || $("#colonia-form").val().length < 1 || $("#calle-form").val().length < 1){
				
				//Muestra la alerta de campos vacios
				document.getElementById("alerta-form-danger").style.display='block';
				
				//Oculta la alerta de infomacion
				document.getElementById("alerta-form-info").style.display='none';
				
			}else{
				
				
				var registrarPersonaForm = {};
				registrarPersonaForm["nombre"] =  $("#nombre-form").val().toUpperCase();
				registrarPersonaForm["segundoNombre"] =  $("#nombre2-form").val().toUpperCase();
				registrarPersonaForm["primerApellido"] =  $("#apellido-form").val().toUpperCase();
				registrarPersonaForm["segundoApellido"] =  $("#apellido2-form").val().toUpperCase();
				registrarPersonaForm["sexo"] = $("#sexo-form").val().toUpperCase();
				registrarPersonaForm["rol"] = $("#rol-form").val().toUpperCase();
				registrarPersonaForm["telefono"] = $("#telefono-form").val().toUpperCase();
				registrarPersonaForm["telefono2"] = $("#telefono2-form").val().toUpperCase();
				registrarPersonaForm["codigoPostal"] = $("#codigoPostal-form").val().toUpperCase();							
				registrarPersonaForm["municipio"] = $("#municipio-form").val().toUpperCase();
				registrarPersonaForm["colonia"] = $("#colonia-form").val().toUpperCase();
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
				
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "registrarPersona",
					data : {registrarPersona:JSON.stringify(registrarPersonaForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);	
						alert("Registro exitoso!");			
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
		
		
	function regresar(url){
		    document.getElementById("regresar-form").action = url;
		    document.forms[0].submit();
	}					
	
	//registrar persona
	
	jQuery(document).ready(function($) {
			
			$("#registrarPersona-form").submit(function(event) {								
				// Prevent the form from submitting via the browser.
				event.preventDefault();

				registrarViaAjax();

			});

		});*/