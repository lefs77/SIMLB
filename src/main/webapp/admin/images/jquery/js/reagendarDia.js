$(function() {
	$("#datepicker2").datepicker({ minDate: 0 });
});

//formato de fecha 
$(function() {		
		
		$("#datepicker2").datepicker();						
		
		$('#datepicker2').datepicker('option', {
			dateFormat : 'yy/mm/dd'
		});
		
		
	});

//formato de fecha 
$(function() {		
		
		$("#datepicker").datepicker();						
		
		$('#datepicker').datepicker('option', {
			dateFormat : 'yy/mm/dd'
		});
		
		
	});

/*SECCION DE CONSULTAR PERSONA POR FECHA*/
$(document).ready(function(){
	
	
	$('#datepicker').change(function(){
		event.preventDefault();

		pickerBuscarPersonaViaAjax();
	});


});

function pickerBuscarPersonaViaAjax() {

	if( $("#datepicker").val().length < 1){
		
		alert("faltan datos");			
		
	}else{
		
		
		var buscarDiaReservadoPorFechaForm = {};
		buscarDiaReservadoPorFechaForm["fecha"] =  $("#datepicker").val().toUpperCase();				

		
		//Se limpia el formulario
		$(":text").each(function(){	
			$($(this)).val('');
		});							
					
		
		//Se limpia la tabla
		$('#tablaPersona tr td').remove();									
				
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "buscarDiaReservadoPorFecha",
					data : {buscarDiaReservadoPorFecha:JSON.stringify(buscarDiaReservadoPorFechaForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);		
					
						if(data ==""){
							
							alert("No existen datos con esa fecha, intenta con otra...");
							
						}else{
						
							$.each(data,function(index,value)
							{	  										
								//alert(value['idHorariosReservados']);
								
								var idReservaciones = value['idReservaciones'];		
								var idHorariosReservados = value['idHorariosReservados'];				
								var nombre = value['nombrePersona'];
								var fechaReservada = value['fechaReservada'];
								var motivo = value['motivo'];
								var horaIni = value['horaIni'];
								var horaFin = value['horaFin'];
															
								if(typeof idReservaciones === "undefined") {
									idReservaciones = "--";
								}							    						    						
								
								if(typeof nombre === "undefined") {
	    							 nombre = "--";
								}
								
								if(typeof fechaReservada === "undefined") {
									fechaReservada = "--";
								}
							
								if(typeof motivo === "undefined") {
									motivo = "--";
								}										
								
								if(typeof horaIni === "undefined") {
									horaIni = "--";
								}
								
								if(typeof horaFin === "undefined") {
									horaFin = "--";
								}																																		
																
												
								$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idReservaciones+"\",\""+idHorariosReservados+"\",\""+"\",\""+nombre+"\",\""+
										fechaReservada+"\",\""+motivo+"\")'>"+
													nombre+"</a></td>"+																												
													"<td>"+fechaReservada+"</td>"+													
													"<td>"+motivo+"</td>"+
													"<td>"+horaIni+"</td>"+
													"<td>"+horaFin+"</td></tr>");	  									
							});
						
						}
								
													
					},
					error : function(e) {
						alert("error");
						console.log("ERROR: ", e);
						display(e);
					}
				});

	}		

		

	}//Fin de la funcion
	
	
	
/*FIN SECCION DE CONSULTAR PERSONA POR FECHA*/

/*SECCION DE CONSULTAR TODAS LAS PERSONAS*/

//BOTON BUSCAR PERSONA
jQuery(document).ready(function($) {
	
	$("#buscarAllAgendas").click(function(event) {								
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		
		cargarAllDatosTablaPersona();

	});

});

function cargarAllDatosTablaPersona(){
	
	// Display the month, day, and year. getMonth() returns a 0-based number.
			var dt = new Date();
			var fechaActual ="";
			
			var month = dt.getMonth()+1;
			var monthAux = month.toString();
			
			var day = dt.getDate();
			var dayAux = day.toString();
			
			var year = dt.getFullYear();
			var yearAux = year.toString();
			
			
			if(dayAux.length <2){
				dayAux = "0"+day;
			}
			
			if(monthAux.length <2){
				monthAux = "0"+month;
			}
			
			fechaActual = yearAux + '/'+monthAux+'/' + dayAux;

			var buscarAllReservacionesForm = {};
						
			buscarAllReservacionesForm["fecha"] =  fechaActual;
		
							
	
	//Se limpia la tabla
	$('#tablaPersona tr td').remove();									
			
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "buscarAllReservaciones",
				data : {buscarAllReservaciones:JSON.stringify(buscarAllReservacionesForm)},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);		
				
					if(data ==""){
						
						alert("No existen datos con ese Nombre, intenta con otro...");
						
					}else{
					
						$.each(data,function(index,value)
						{	  										
							
							
							var idReservaciones = value['idReservaciones'];	
							var idHorariosReservados = value['idHorariosReservados'];			
							var nombre = value['nombrePersona'];
							var fechaReservada = value['fechaReservada'];
							var motivo = value['motivo'];
							
							var horaIni = value['horaIni'];
							var horaFin = value['horaFin'];
														
							if(typeof idReservaciones === "undefined") {
								idReservaciones = "--";
							}							    						    						
							
							if(typeof nombre === "undefined") {
    							 nombre = "--";
							}
							
							if(typeof fechaReservada === "undefined") {
								fechaReservada = "--";
							}
						
							if(typeof motivo === "undefined") {
								motivo = "--";
							}										
							
							if(typeof horaIni === "undefined") {
								horaIni = "--";
							}
							
							if(typeof horaFin === "undefined") {
								horaFin = "--";
							}																																		
															
											
							$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idReservaciones+"\",\""+idHorariosReservados+"\",\""+nombre+"\",\""+
									fechaReservada+"\",\""+motivo+"\")'>"+
												nombre+"</a></td>"+																												
												"<td>"+fechaReservada+"</td>"+													
												"<td>"+motivo+"</td>"+
												"<td>"+horaIni+"</td>"+
												"<td>"+horaFin+"</td></tr>");	  									
						});
					
					}
							
												
				},
				error : function(e) {
					alert("error");
					console.log("ERROR: ", e);
					display(e);
				}
			});
				
	
}

//FIN BUSCAR TODAS LAS PERSONAS

/*SECCION DE CONSULTAR PERSONA POR NOMBRE*/
			
			//BOTON BUSCAR PERSONA
			jQuery(document).ready(function($) {
				
				$("#searchbox").submit(function(event) {								
					// Prevent the form from submitting via the browser.
					event.preventDefault();
					
					searchViaAjax();

				});

			});

			
			function searchViaAjax() {

				if( $("#nombrePersona").val().length < 1){
					
					alert("faltan datos");			
					
				}else{
										
					var nombrePersona = $("#nombrePersona").val().toUpperCase();
					
					//Se limpia el formulario
					$(":text").each(function(){	
						$($(this)).val('');
					});							
								
					
					cargarDatosTablaPersona(nombrePersona,true);							
				}						
		
				}//Fin de la funcion
				
			
			function cargarDatosTablaPersona(nombrePersona,tipoBusqueda){
				
				// Display the month, day, and year. getMonth() returns a 0-based number.
						var dt = new Date();
						var fechaActual ="";
						
						var month = dt.getMonth()+1;
						var day = dt.getDate();
						var year = dt.getFullYear();									
						
						fechaActual = day + '/'+month+'/' + year;

						var buscarDiaReservadoForm = {};
						
						if(!tipoBusqueda){
							buscarDiaReservadoForm["fecha"] =  fechaActual;
						}else{
							buscarDiaReservadoForm["nombrePersona"] =  nombrePersona;//todo el back ya esta, falta ajustar esta parte
						}		
										
				
				//Se limpia la tabla
				$('#tablaPersona tr td').remove();									
						
						$.ajax({
							type : "GET",
							contentType : "application/json",
							url : "buscarDiaReservado",
							data : {buscarDiaReservado:JSON.stringify(buscarDiaReservadoForm)},
							dataType : 'json',
							timeout : 100000,
							success : function(data) {
								
								console.log("SUCCESS: ", data);		
								
								var contador = 0;
								
								if(data ==""){
									
									alert("No existen datos con ese Nombre, intenta con otro...");
									
								}else{
								
									$.each(data,function(index,value)
									{	  										
										contador = contador+1
										
										var idReservaciones = value['idReservaciones'];	
										var idHorariosReservados = value['idHorariosReservados'];			
										var nombre = value['nombrePersona'];
										var fechaReservada = value['fechaReservada'];
										var motivo = value['motivo'];
										
										var horaIni = value['horaIni'];
										var horaFin = value['horaFin'];
																	
										if(typeof idReservaciones === "undefined") {
											idReservaciones = "--";
										}							    						    						
										
										if(typeof nombre === "undefined") {
			    							 nombre = "--";
										}
										
										if(typeof fechaReservada === "undefined") {
											fechaReservada = "--";
										}
									
										if(typeof motivo === "undefined") {
											motivo = "--";
										}										
										
										if(typeof horaIni === "undefined") {
											horaIni = "--";
										}
										
										if(typeof horaFin === "undefined") {
											horaFin = "--";
										}																																		
																		
														
										$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idReservaciones+"\",\""+idHorariosReservados+"\",\""+nombre+"\",\""+
												fechaReservada+"\",\""+motivo+"\")'>"+
															nombre+"</a><p id='idReservAux' style='display:none;'>"+idReservaciones+"</p></td>"+																												
															"<td>"+fechaReservada+"<p id='idHReservAux' style='display:none;'>"+idHorariosReservados+"</p></td>"+													
															"<td>"+motivo+"</td>"+
															"<td>"+horaIni+"</td>"+
															"<td>"+horaFin+"</td></tr>");	  									
									});
								
								}
										
															
							},
							error : function(e) {
								alert("error");
								console.log("ERROR: ", e);
								display(e);
							}
						});
							
				
			}
			
			
			
				
				//FUNCION PARA CARGAR DATOS EN EL MODAL
				function editarPopup(idReservacion,idHorariosReservados,nombre,fechaReservada, motivo){								
				
					//alert(idReservacion+","+nombre+","+fechaReservada+","+motivo);
					//alert(idHorariosReservados);
					$('#fondoTransparente').css('opacity', '0.5');
					$('#popupDetallePersonas').fadeIn('slow');				
					
									
					document.getElementById("fondoTransparente").disabled =true;
										
					
					//CODIGO PARA AGREGAR FILAS A LA TABLA;
		           
					/*var n = $('tr:last td', $("#tabla")).length;										
							
					var tds = '<tr id="filaAux">';
					
					
					 
					  tds += '<td id="idReservacion" style="display: none;"">'+idReservacion+'</td>';
					  tds += '<td id="idHorariosReservados" style="display: none;"">'+idHorariosReservados+'</td>';
					
					
					tds += '</tr>';
					
					$("#tabla").append(tds);	*/
					
					//CODIGO PARA GUARDAR DATOS EN DIVS
					$("#idReservaciones").data("Reservaciones",idReservacion);
					$("#idHorariosReservados").data("HorariosReservados",idHorariosReservados);
				}
				
				
				//FUNCION PARA CERRAR MODAL
				 $(document).ready(function(){
					
						
						$('#close2').click(function(){
							
							$('#popupDetallePersonas').fadeOut('slow');					
							$('#fondoTransparente').css('opacity', '1');																										
							
							
							document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
							document.getElementById("alerta-reagendar-error").style.display='none';
							document.getElementById("alerta-reagendar-exito").style.display='none';
							
							//Se limpia el combo de horas disponibles			
							borraHorario(false);
							borraHorario(true);
							$("#hora-form").prop('disabled', true);
							$("#hora-form2").prop('disabled', true);

							//limpiar popup
							 $('input[type="text"]').val('');
							 
							//limpiar filaAux
							 //$("#filaAux").remove();
							 
							 //limpiar Data()
							 $("#idReservaciones").removeData("Reservaciones");
							 $("#idHorariosReservados").removeData("HorariosReservados");
							 
							document.getElementById("fondoTransparente").disabled =false;

							return false;
						});
						
						
					});			
					
					
					
					
				 	
		//ocultar cuerpo y mostrar solo combo de opciones
		jQuery(document).ready(function($) {
				
				$('#capaCuerpo').css("display", "none");
				$('#capaCuerpo2').css("display", "none");

		});
		
		/*FIN DE CONSULTAR PERSONA POR NOMBRE*/
		
		/*Siempre que se seleccione una fecha, estará mostrando la lista de horas disponibles para esa fecha*/									
		
		function habilitarHorario(){
			
			//Muestra la alerta de horarios no disponibles
			document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
			
			//Oculta la alerta de campos vacios
			document.getElementById("alerta-reagendar-error").style.display='none';
			
			//Muestra la alerta de infomacion
			document.getElementById("alerta-reagendar-exito").style.display='none';
			
			
			$("#hora-form").prop('disabled', false);
			$("#hora-form2").prop('disabled', true);
			
			this.borraHorario(false);
			this.borraHorario(true);
			
			cargarHoraAjax($("#datepicker2").val());
		}
		
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
					
					if(data.length <= 1){
						
						//Muestra la alerta de horarios no disponibles
						document.getElementById("alerta-form-danger-horarioDisp").style.display='block';
						
						//Oculta la alerta de campos vacios
						document.getElementById("alerta-reagendar-error").style.display='none';
						
						//Muestra la alerta de infomacion
						document.getElementById("alerta-reagendar-exito").style.display='none';
						
						$("#hora-form").prop('disabled', true);
						
					}else{
						
					}
					
					$.each(data,function(index,value)
		  			{	  						
		  				$('#hora-form').append("<option value='"+value["idHorariosDisponibles"]+"'>"+value["horario"]+"</option>");	  				
		  				
		  			});
				},
				error : function(e) {
					console.log("ERROR: ", e);
					display(e);
				}
			});

		}		
		
		
		function obtenerHoraFin(){
			
			//Muestra la alerta de horarios no disponibles
			document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
			
			//Oculta la alerta de campos vacios
			document.getElementById("alerta-reagendar-error").style.display='none';
			
			//Muestra la alerta de infomacion
			document.getElementById("alerta-reagendar-exito").style.display='none';
			
			$("#hora-form2").prop('disabled', false);
			
			this.borraHorario(true);		//hora fin
			var horaIni = $("#hora-form option:selected").text();
			
			cargarHoraFinAjax(horaIni,$("#datepicker2").val());
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
		
		
		jQuery(document).ready(function($) {
			
			$("#reagendarCita-form").submit(function(event) {								
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				
				reagendarCitaViaAjax();

			});

		});
		
		
		function reagendarCitaViaAjax() {

			if( $("#nombre-form").val().length < 1 || $("#motivo-form").val().length < 1 ||
				$("#hora-form").val() < 1 || $("#hora-form2").val() < 1  ||	$("#datepicker2").val().length < 1){
				
				//Muestra la alerta de horarios no disponibles
				document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
				
				
				//Muestra la alerta de campos vacios
				document.getElementById("alerta-reagendar-error").style.display='block';
				
				//Oculta la alerta de infomacion
				document.getElementById("alerta-reagendar-exito").style.display='none';
				
			}else{
				
				var horaIni = $("#hora-form option:selected").text();
				var horaFin = $("#hora-form2 option:selected").text();
				var idHorariosReservados = $("#idHorariosReservados").data("HorariosReservados");
				var idReservaciones = $("#idReservaciones").data("Reservaciones");
				var idHorariosDisponiblesIni = $("#hora-form").val();
				var idHorariosDisponiblesFin = $("#hora-form2").val();
				/*alert(idReservaciones);
				alert(idHorariosReservados);
				alert(idHorariosDisponiblesIni);
				alert(idHorariosDisponiblesFin);*/
				
				var actualizarReservacionForm = {};
				actualizarReservacionForm["idReservaciones"] =  idReservaciones;
				actualizarReservacionForm["nombrePersona"] =  $("#nombre-form").val().toUpperCase();
				actualizarReservacionForm["motivo"] = $("#motivo-form").val().toUpperCase();
				actualizarReservacionForm["horaIni"] = horaIni;
				actualizarReservacionForm["horaFin"] = horaFin;
				actualizarReservacionForm["fechaReservada"] = $("#datepicker2").val().toUpperCase();
				actualizarReservacionForm["idHorariosReservados"] = idHorariosReservados;
				actualizarReservacionForm["idHorariosDisponiblesIni"] = idHorariosDisponiblesIni;
				actualizarReservacionForm["idHorariosDisponiblesFin"] = idHorariosDisponiblesFin;

				
				
				
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
					url : "actualizarReservacion",
					data : {actualizarReservacion:JSON.stringify(actualizarReservacionForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						
						//Muestra la alerta de horarios no disponibles
						document.getElementById("alerta-form-danger-horarioDisp").style.display='none';
												
						//Oculta la alerta de campos vacios
						document.getElementById("alerta-reagendar-error").style.display='none';
						
						//Muestra la alerta de infomacion
						document.getElementById("alerta-reagendar-exito").style.display='block';
						
						//console.log("SUCCESS: ", data);				
						//display(data);
						
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