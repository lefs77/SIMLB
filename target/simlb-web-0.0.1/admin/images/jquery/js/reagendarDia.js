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
								
								
								var idReservaciones = value['idReservaciones'];								
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
																
												
								$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idReservaciones+"\",\""+nombre+"\",\""+
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
							
								if(data ==""){
									
									alert("No existen datos con ese Nombre, intenta con otro...");
									
								}else{
								
									$.each(data,function(index,value)
									{	  										
										
										
										var idReservaciones = value['idReservaciones'];								
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
																		
														
										$('#tablaPersona').append("<tr><td width='35%'><a href='#' id='open' onclick='editarPopup(\""+idReservaciones+"\",\""+nombre+"\",\""+
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
			
			
			
				
				//FUNCION PARA CARGAR DATOS EN EL MODAL
				function editarPopup(idPersona,nombre,fechaAlta, usuarioAlta, fechaActualizacion, usuarioActualizacion){								
									
					$('#fondoTransparente').css('opacity', '0.5');
					$('#popupDetallePersonas').fadeIn('slow');				
					
									
					document.getElementById("fondoTransparente").disable =true;
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
							
							
							document.getElementById("fondoTransparente").disable =true;
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