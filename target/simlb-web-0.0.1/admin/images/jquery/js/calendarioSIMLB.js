$(window).load( function() {
					
	$('#mycalendar').monthly({
		mode: 'event',
		//jsonUrl: 'images/json/events.json',										
		dataType: 'json'					
		//xmlUrl: 'images/xml/events.xml'
	});
	
	switch(window.location.protocol) {
		case 'http:':
		case 'https:':
		// running on a server, should be good.
		break;
		case 'file:':
			alert('Just a heads-up, events will not work when run locally.');
	}
});