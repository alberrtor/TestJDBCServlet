
Ext.onReady(function () {
	
	Ext.apply(Ext.form.VTypes, {
		regexp     : loginValidate,
	    userText : 'Usuario o password incorrecto'
	});
	
	var formularioLogin = new Ext.FormPanel({
		frame: true,
		title: 'Login',
		width: 300,
		monitorValid: true,
		items: [ {
					xtype: 'textfield',
					fieldLabel: 'Usuario',
					name: 'usr',
					vtype:'regexp',
					blankText:'Ingrese su usuario',
					allowBlank: false //No permite vacios
				} , {
					xtype: 'textfield',
					fieldLabel: 'Contraseña',
					inputType:'password',
					name: 'pwd',
					vtype:'regexp',
					blankText:'Ingrese su contraseña',
					allowBlank: false //No permite vacios
				}
		],
		buttons : [ {
						text: 'Entrar',
						handler: function(boton, evento) {
							formularioLogin.getForm().submit({
								url: 'ServletLogin',
								method:'POST',
								action:'ServletLogin',
								formBind: true,
								failure: function(form, action) {
									Ext.MessageBox.show({
										title: 'Error',
										msg: 'Usuario o password incorrecto',
										buttons: Ext.MessageBox.OK,
										icons: Ext.MessageBox.ERROR
									});
								},
								success: function(form, request) {
									var redirect = 'jsp/AdministrarClientes.jsp'; 
			                        window.location = redirect;
								}
							});
						}
					}
		           ]
	});
	formularioLogin.render('loginForm');
});


 