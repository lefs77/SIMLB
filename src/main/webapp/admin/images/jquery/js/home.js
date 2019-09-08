$(document).ready(function(){
	
					
		$('#id_datepicker').change(function(){
		event.preventDefault();

		pickerBuscarPersonaViaAjax();
	});
	
	
});
	
	
	//no permite seleccionar dias pasados
$(function() {
	$("#id_datepicker").datepicker({ minDate: 0 });
});

//formato de fecha 
 $(function() {		
 		
		$("#id_datepicker").datepicker();						
	
	$('#id_datepicker').datepicker('option', {
		dateFormat : 'yy/mm/dd'
	});
	
	
});