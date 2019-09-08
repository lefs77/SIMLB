/**Luis eduardo Fernandez Samano
 *creado : 12/07//209
 *Descripcion: Consulta a las persona que estan registradas
 */
/*SECCION DE CONSULTAR PERSONA POR FECHA*/

$(document).ready(function(){
	
					
					$('#datepicker').change(function(){
						event.preventDefault();

						pickerBuscarPersonaViaAjax();
					});
					
					
				});
		
		
		//no permite seleccionar dias pasados
		/*$(function() {
			$("#datepicker").datepicker({ minDate: 0 });
		});*/
		
		//formato de fecha 
		 $(function() {		
		 		
				$("#datepicker").datepicker();						
				
				$('#datepicker').datepicker('option', {
					dateFormat : 'yy/mm/dd'
				});
				
				
				
			});
			
		
				
		function pickerBuscarPersonaViaAjax() {

			if( $("#datepicker").val().length < 1){
				
				alert("faltan datos");			
				
			}else{
				
				
				var buscarPersonaFechaForm = {};
				buscarPersonaFechaForm["fechaAlta"] =  $("#datepicker").val().toUpperCase();				

				
				//Se limpia el formulario
				$(":text").each(function(){	
					$($(this)).val('');
				});							
							
				
				//Se limpia la tabla
				$('#tablaPersona tr td').remove();
				
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "buscarPersona",
					data : {buscarPersona:JSON.stringify(buscarPersonaFechaForm)},
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						console.log("SUCCESS: ", data);		
						
						if(data ==""){
							
							alert("No existen datos con esa fecha, intenta con otra...");
							
						}else{
						
							$.each(data,function(index,value)
							{	  										
								
								
								var idPersona = value['idPersona'];								
								var nombre = value['nombreCompleto'];
								var sexo = value['sexo'];
								var estatusPersona = value['estatusPersona'];
								var telefonos ="";
								var telefonoUno = value['telefonoUno'];
								var telefonoDos = value['telefonoDos'];
								var rol = value['rolPersona'];
								var fechaAlta = value['fechaAlta'];
								var usuarioAlta = value['usuarioAlta'];
								var fechaActualizacion = value['fechaActualizacion'];
								var usuarioActualizacion = value['usuarioActualizacion'];								
															    						    						
								
								if(jQuery.type(telefonoUno) === "undefined") {
	    							 telefonoUno = "--";
								}
								
								
								if(jQuery.type(telefonoDos) === "undefined") {
	    							 telefonoDos = "--";
								}
							
							    telefonos = telefonoUno+ " "+telefonoDos;
							    
								if(typeof nombre === "undefined") {
	    							 nombre = "--";
								}
								
								if(typeof sexo === "undefined") {
									sexo = "--";
								}
							
								if(typeof estatusPersona === "undefined") {
									estatusPersona = "--";
								}else{
									if(estatusPersona=="A"){
										estatusPersona ="ACTIVO";
									}else if(estatusPersona=="B"){
										estatusPersona="BLOQUEADO";
									}else if(estatusPersona=="I"){
										estatusPersona="INACTIVO";
									}
								}
								
								
								if(typeof telefonos === "undefined") {
									telefonos = "--";
								}
								
								if(typeof rol === "undefined") {
									rol = "--";
								}
								
								if(typeof fechaAlta === "undefined") {
									fechaAlta = "--";
								}
								
								if(typeof usuarioAlta === "undefined") {
									usuarioAlta = "--";
								}
								
								if(typeof fechaActualizacion === "undefined") {
									fechaActualizacion = "--";
								}
								
								if(typeof usuarioActualizacion === "undefined") {
									usuarioActualizacion = "--";
								}																
																
												
								$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idPersona+"\",\""+nombre+"\",\""+
																														fechaAlta+"\",\""+usuarioAlta+"\",\""+
																														fechaActualizacion+"\",\""+usuarioActualizacion+"\")'>"+
													nombre+"</a></td>"+													
													//"<td>"+sexo+"</td>"+
													"<td>"+estatusPersona+"</td>"+													
													"<td>"+telefonos+"</td>"+
													"<td>"+rol+"</td></tr>");
													/*"<td>"+fechaAlta+"</td>"+
													"<td>"+usuarioAlta+"</td>"+
													"<td>"+fechaActualizacion+"</td>"+
													"<td>"+usuarioActualizacion+"</td></tr>");*/	  									
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
			
			function display(data) {
					alert("Respuesta : "+ JSON.stringify(data, null, 4));
					//location.reload();					
				}
			
	/*FIN SECCION DE CONSULTAR PERSONA POR FECHA*/
			
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
								
					
					//Se limpia la tabla
					//$('#tablaDatos tr td').remove();
					
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

						var buscarPersonaForm = {};
						
						if(!tipoBusqueda){
							buscarPersonaForm["fechaRegistro"] =  fechaActual;
						}else{
							buscarPersonaForm["nombreCompleto"] =  nombrePersona;
						}		
										
				
				//Se limpia la tabla
				$('#tablaPersona tr td').remove();									
						
						$.ajax({
							type : "GET",
							contentType : "application/json",
							url : "buscarPersona",
							data : {buscarPersona:JSON.stringify(buscarPersonaForm)},
							dataType : 'json',
							timeout : 100000,
							success : function(data) {
								console.log("SUCCESS: ", data);		
							
								if(data ==""){
									
									alert("No existen datos con ese Nombre, intenta con otro...");
									
								}else{
								
									$.each(data,function(index,value)
									{	  										
										
										
										var idPersona = value['idPersona'];								
										var nombre = value['nombreCompleto'];
										var sexo = value['sexo'];
										var estatusPersona = value['estatusPersona'];
										var telefonos ="";
										var telefonoUno = value['telefonoUno'];
										var telefonoDos = value['telefonoDos'];
										var rol = value['rolPersona'];
										var fechaAlta = value['fechaAlta'];
										var usuarioAlta = value['usuarioAlta'];
										var fechaActualizacion = value['fechaActualizacion'];
										var usuarioActualizacion = value['usuarioActualizacion'];								
																	    						    						
										
										if(jQuery.type(telefonoUno) === "undefined") {
			    							 telefonoUno = "--";
										}
										
										
										if(jQuery.type(telefonoDos) === "undefined") {
			    							 telefonoDos = "--";
										}
									
									    telefonos = telefonoUno+ " "+telefonoDos;
									    
										if(typeof nombre === "undefined") {
			    							 nombre = "--";
										}
										
										if(typeof sexo === "undefined") {
											sexo = "--";
										}
									
										if(typeof estatusPersona === "undefined") {
											estatusPersona = "--";
										}else{
											if(estatusPersona=="A"){
												estatusPersona ="ACTIVO";
											}else if(estatusPersona=="B"){
												estatusPersona="BLOQUEADO";
											}else if(estatusPersona=="I"){
												estatusPersona="INACTIVO";
											}
										}
										
										
										if(typeof telefonos === "undefined") {
											telefonos = "--";
										}
										
										if(typeof rol === "undefined") {
											rol = "--";
										}
										
										if(typeof fechaAlta === "undefined") {
											fechaAlta = "--";
										}
										
										if(typeof usuarioAlta === "undefined") {
											usuarioAlta = "--";
										}
										
										if(typeof fechaActualizacion === "undefined") {
											fechaActualizacion = "--";
										}
										
										if(typeof usuarioActualizacion === "undefined") {
											usuarioActualizacion = "--";
										}																
																		
														
										$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idPersona+"\",\""+nombre+"\",\""+
																																fechaAlta+"\",\""+usuarioAlta+"\",\""+
																																fechaActualizacion+"\",\""+usuarioActualizacion+"\")'>"+
															nombre+"</a></td>"+													
															//"<td>"+sexo+"</td>"+
															"<td>"+estatusPersona+"</td>"+													
															"<td>"+telefonos+"</td>"+
															"<td>"+rol+"</td></tr>");
															/*"<td>"+fechaAlta+"</td>"+
															"<td>"+usuarioAlta+"</td>"+
															"<td>"+fechaActualizacion+"</td>"+
															"<td>"+usuarioActualizacion+"</td></tr>");*/	  									
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
				function editarPopup(idPersona,nombre,fechaAlta, usuarioAlta, fechaActualizacion, usuarioActualizacion){								
									
					$('#fondoTransparente').css('opacity', '0.5');
					$('#popupDetallePersonas').fadeIn('slow');				
					
					document.getElementById("opcionesPersona").disabled =true;				
					document.getElementById("fondoTransparente").disabled =true;
					$('#idTablaDetallePersona').css('pointer-events','none');
																																																							
					
					//Se limpia la tabla
					$('#tablaPersona2 tr td').remove();									
					
																				
																
					
					$('#tablaPersona2').append("<tr><td width='30%' align='center' class='td2'><b><u>" +
										nombre+"</u></b></td>"+													
										"<td class='td2' align='center'><b><u>"+fechaAlta+"</u></b></td>"+
										"<td class='td2' align='center'><b><u>"+usuarioAlta+"</u></b></td>"+
										"<td class='td2' align='center'><b><u>"+fechaActualizacion+"</u></b></td>"+
										"<td class='td2' align='center'><b><u>"+usuarioActualizacion+"</u></b></td></tr>");													
							
																							
				}
				
				
				//FUNCION PARA CERRAR MODAL
				 $(document).ready(function(){
					
						
						$('#close2').click(function(){
							
							$('#popupDetallePersonas').fadeOut('slow');					
							$('#fondoTransparente').css('opacity', '1');																										
							
							
							document.getElementById("opcionesPersona").disabled =false;
							document.getElementById("fondoTransparente").disabled =false;
							$('#idTablaDetallePersona').css('pointer-events','auto');
							return false;
						});
						
						
					});			
					
					
					
					
				 	
		//ocultar cuerpo y mostrar solo combo de opciones
		jQuery(document).ready(function($) {
				
				$('#capaCuerpo').css("display", "none");
				$('#capaCuerpo2').css("display", "none");

		});
		
		/*FIN DE CONSULTAR PERSONA POR NOMBRE*/