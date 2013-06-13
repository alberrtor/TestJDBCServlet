function loginValidate(val, field){
	//Expresiones regulares
	//acepta un password alfanumerico que acepta numeros y caracteres minimo de 8 y maximo de 10
	var RegExPattern = /(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$/;
	
	//saca el componente con id=formLogin
//	var usr = document.forms["formLogin"]["usr"].value;
//	var pwd = document.forms["formLogin"]["pwd"].value;
	
//	var msg = "Ingresar usuario o password correctamente";
//	
//	//con match cargamos la expresion regular para que se ejecute en la cadena psw
//	if(usr == null || usr== "" || !pwd.match(RegExPattern)){
//		alert(msg);
//		
//		return false;
//	}
	
	var localVal = val;
	
	if (field.name === "usr" && localVal === ''){
		return false;
	}
	
	if (field.name === "pwd"){
		return localVal.match(RegExPattern);
	}
	
	return true;
	
}