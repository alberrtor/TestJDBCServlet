function goAction(param) {
	var menuItem = param;

	// triple = es exactamente igual
	if (menuItem === 'consultar') {
		document.forms["menuItems"].method = "get";
		document.forms["menuItems"].action = "../ServletConsultar";
	} else if (menuItem === 'eliminar') {
		document.forms["menuItems"].method = "get";
		document.forms["menuItems"].action = "../ServletEliminar";
	} else if (menuItem === 'nuevo') {
		document.forms["menuItems"].method = "get";
		document.forms["menuItems"].action = "../ServletNuevo";
	} else if (menuItem === 'buscar') {
		document.forms["menuItems"].method = "get";
		document.forms["menuItems"].action = "../ServletBuscar";
	}

	document.forms["menuItems"].submit();
}