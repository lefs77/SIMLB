function regresar(url){
		    document.getElementById("reservarCita-form").action = url;
		    document.forms[0].submit();
		}
		
$(function() {
	$("#datepicker").datepicker({ minDate: 0 });
});
		//Carga la pagina de Reagendar Citas
		function reagendar(url){
		    document.getElementById("reagendarCita-form").action = url;
		    document.forms[1].submit();
		}
		
		
		
		jQuery(document).ready(function($) {
			
			$("#reservarCita-form").submit(function(event) {								
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				
				searchViaAjax();

			});

		});

		//formato de fecha 
		 $(function() {		
		 		
				$("#datepicker").datepicker();						
				
				$('#datepicker').datepicker('option', {
					dateFormat : 'yy/mm/dd'
				});
				
				
				
			});
		
		function searchViaAjax() {

			if( $("#nombre-form").val().length < 1 || $("#motivo-form").val().length < 1 ||
				$("#hora-form").val() < 1 || $("#hora-form2").val() < 1  ||	$("#datepicker").val().length < 1){
				
				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				//Muestra la alerta de campos vacios
				document.getElementById("alerta-form-danger2").style.display='block';
				
				//Oculta la alerta de infomacion
				document.getElementById("alerta-form-info2").style.display='none';
				
			}else{
				
				//alert($("#nombre-form").val()+", "+$("#motivo-form").val()+", "+$("#hora-form").val()+", "+$("#hora-form2").val()+", "+$("#datepicker").val());
				
				var horaIni = $("#hora-form option:selected").text();
				var horaFin = $("#hora-form2 option:selected").text();
				
				var reservacionForm = {};
				reservacionForm["nombrePersona"] =  $("#nombre-form").val().toUpperCase();
				reservacionForm["motivo"] = $("#motivo-form").val().toUpperCase();
				reservacionForm["horaIni"] = horaIni;
				reservacionForm["horaFin"] = horaFin;
				reservacionForm["fechaReservada"] = $("#datepicker").val().toUpperCase();

				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				//Oculta la alerta de campos vacios
				document.getElementById("alerta-form-danger2").style.display='none';
				
				//Muestra la alerta de infomacion
				document.getElementById("alerta-form-info2").style.display='block';
				
				//Se limpia el formulario
				$(":text").each(function(){	
					$($(this)).val('');
				});
				
				//Se limpia el combo de horas disponibles			
				this.borraHorario(false);
				this.borraHorario(true);
							
				
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "reservacion",
					data : {reservacion:JSON.stringify(reservacionForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						//console.log("SUCCESS: ", data);				
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
			
		
		function borraHorario(borrarIni) {
		
				if(!borrarIni){
					//$("#hora-form").remove($("#hora-form").length - 1);
					$('option', '#hora-form').remove();
					
					$("#hora-form").append("<option value='0' selected='selected' >Hora inicio...</option>");
					
				}else{
					
					$('option', '#hora-form2').remove();
					
					
					$("#hora-form2").append("<option value='0' selected='selected' >Hora fin...</option>");
				}
		
							
		}
					
		
			/*Siempre que se seleccione una fecha, estará mostrando la lista de horas disponibles para esa fecha*/									
			
			function habilitarHorario(){
				
				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				//Oculta la alerta de campos vacios
				document.getElementById("alerta-form-danger2").style.display='none';
				
				//Muestra la alerta de infomacion
				document.getElementById("alerta-form-info2").style.display='block';
				
				
				$("#hora-form").prop('disabled', false);
				$("#hora-form2").prop('disabled', true);
				this.borraHorario(false);
				this.borraHorario(true);
				cargarHoraAjax($("#datepicker").val());
			}					
			
			
		
			function obtenerHoraFin(){
				
				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				//Oculta la alerta de campos vacios
				document.getElementById("alerta-form-danger2").style.display='none';
				
				//Muestra la alerta de infomacion
				document.getElementById("alerta-form-info2").style.display='block';
				
				$("#hora-form2").prop('disabled', false);
				
				this.borraHorario(true);		//hora fin
				var horaIni = $("#hora-form option:selected").text();
				
				cargarHoraFinAjax(horaIni,$("#datepicker").val());
			}		
			
			function cargarHoraAjax(fecha) {
	
				var cargarHorarioForm = {};						
				cargarHorarioForm["fecha"] = fecha;						
									
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "cargarHorario",
					data : {cargarHorario:JSON.stringify(cargarHorarioForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						
						/* console.log("SUCCESS: ", data);*/				
						//display(data); 
						//alert(data.length);
						
						if(data.length <= 1){
							
							//Muestra la alerta de horarios no disponibles
							document.getElementById("alerta-form-danger-horarioDisp").style.display='block';
							
							//Oculta la alerta de campos vacios
							document.getElementById("alerta-form-danger2").style.display='none';
							
							//Muestra la alerta de infomacion
							document.getElementById("alerta-form-info2").style.display='none';
							
							$("#hora-form").prop('disabled', true);
							
						}else{
							
							$.each(data,function(index,value){
								
						  		$('#hora-form').append("<option value='"+value["idHorariosDisponibles"]+"'>"+value["horario"]+"</option>");	  				
						  				
						  	});
						}
						
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					}
				});
	
			}		
			
			
						
			function cargarHoraFinAjax(horaIni,fecha) {
				//alert("aaa");
				var cargarHoraFinForm = {};						
				cargarHoraFinForm["horaIni"] = horaIni;
				cargarHoraFinForm["fecha"] = fecha;
									
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "cargarHorarioFin",
					data : {cargarHorarioFin:JSON.stringify(cargarHoraFinForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						
						$.each(data,function(index,value)
			  			{	  													  				
			  				$('#hora-form2').append("<option value='"+value["idHorariosDisponibles"]+"'>"+value["horario"]+"</option>");	  				
			  			});
					},
					error : function(e) {
						console.log("ERROR: ", e);
						display(e);
					}
				});
	
			}		
			
			function soloTexto(string){//solo letras
			    var out = '';
			    //Se añaden las letras validas
			    var filtro = 'abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ ';//Caracteres validos
				
			    for (var i=0; i<string.length; i++)
			       if (filtro.indexOf(string.charAt(i)) != -1) 
				     out += string.charAt(i);
			    return out.toUpperCase();
			}
			
			function NumText(string){//solo letras y numeros
			    var out = '';
			    //Se añaden las letras validas
			    var filtro = 'abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ1234567890 ';//Caracteres validos
				
			    for (var i=0; i<string.length; i++)
			       if (filtro.indexOf(string.charAt(i)) != -1) 
				     out += string.charAt(i);
			    return out.toUpperCase();
			}
			
			function Numeros(string){//Solo numeros
			    var out = '';
			    var filtro = '1234567890';//Caracteres validos
				
			    //Recorrer el texto y verificar si el caracter se encuentra en la lista de validos 
			    for (var i=0; i<string.length; i++)
			       if (filtro.indexOf(string.charAt(i)) != -1) 
			             //Se añaden a la salida los caracteres validos
				     out += string.charAt(i);
				
			    //Retornar valor filtrado
			    return out;
			} 
			
			
			function adminAlertas(){
				
				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				//Oculta la alerta de campos vacios
				document.getElementById("alerta-form-danger2").style.display='none';
				
				//Muestra la alerta de infomacion
				document.getElementById("alerta-form-info2").style.display='block';
			}