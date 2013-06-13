Ext.onReady(function(){
	
	
	var foumularioLogin = new Ext.FormPanel({
	frame: true,
	title:'Login',
	width:300,
	monitorValid: true,
	items:[
	       {
	    	   xtype: 'textField',
	    	   fieldLabel: 'Usuario',
	    	   name: 'usr',
	    	   blankText: 'IngreseUsuario',
	    	   allowBlank:false //No permite vacios
	       },
	       {
	    	   xtype: 'textField',
	    	   fieldLabel: 'Contraseña',
	    	   inputType: 'password',
	    	   name: 'pwd',
	    	   blankText: 'Ingrese su contraseña',
	    	   allowBlank: false
	       }
	       
	       ]
	});
	
	formularioLogin.render('loginForm');
});