Ext.onReady(function(){
	
	
	Ext.define('ClienteModel', {
		extend: 'Ext.data.Model',
		fields: [{name:'idbanco', type:'int'},
		         {name:'edad', type:'int'},
		         {name:'amaterno', type:'string'},
		         {name:'apaterno', type:'string'},
		         {name:'nombre', type:'string'},
		         {name:'idcliente', type:'int'}
		         ]
	});
	
	var storeClientes = Ext.create('Ext.data.Store', {
		model: 'ClienteModel',
		autoLoad: true,
		autoSync:true,
		proxy: {
				type:'ajax',
//				url:'../ServletConsultar',
//				actionMethods:{
//					read: 'GET'
				//},
				api:{
					read:'../ServletConsultar',
					update:'../ServletUpdate'
				},
				reader:{
					root:'clientes'
				}
				
		}
	});
	
	var accordionMenu = new Ext.panel.Panel({
		title:'Administración de Clientes',
		width:400,
		height:400,
		layout:'accordion',
		layoutConfig:{
			titleCollapse:false,
			animate:true,
			activeOnTop:true
		},
		items:[
		       {
		    	   title:'consultar',
		    	   html:'<div id="consultaCtes">'
		       },
		       {
		    	   title:'Buscar',
		    	   html:'<div id="buscarCtes">'
		       },
		       {
		    	   title:'Nuevo',
		    	   html:'<div id="nuevoCtes">'
		       }
		       ]
	});
	
	
	var gridClientes  = new Ext.grid.GridPanel({
		draggable : {
				insertProxy:false,
				onDrag:function(e){
					var el = this.proxy.getEl();
					this.x = el.getLeft(true);
					this.y = el.getTop(true);
				}
		      },
		title:'Clientes',
		store:storeClientes,
		columns:[
		         {header:'ID', width:60, dataIndex:'idcliente', sortable:true},
		         {header:'A. Paterno', width:60, dataIndex:'apaterno', editor:'textfield', sortable:true},
		         {header:'A. Materno', width:60, dataIndex:'amaterno', editor:'textfield', sortable:true},
		         {header:'Nombre', width:60, dataIndex:'nombre', editor:'textfield', sortable:true},
		         {header:'Edad', width:60, dataIndex:'edad', editor:'textfield', sortable:true}
		         ],
		plugins:[
		         	Ext.create('Ext.grid.plugin.RowEditing',{
		         		clicksToEdit: 1
		         	})
		         ],
		width:310,
		height:150
		
	});
	
	var formularioAlta = new Ext.FormPanel({
				frame: true,
				title: 'Alta de cliente',
				width: 300,
				items: [ {
							xtype: 'textfield',
							fieldLabel: 'Nombre',
							name: 'nombre'
				
						} , {
							xtype: 'textfield',
							name: 'apaterno',
							fieldLabel: 'A. Paterno'

							
						} , {
							xtype: 'textfield',
							name: 'amaterno',
							fieldLabel: 'A. Materno'

						} , {
				            xtype: 'numberfield',
				            name: 'edad',
				            fieldLabel: 'Edad'
				        }, {
				            xtype: 'combo',
				            name: 'banco',
				            fieldLabel: 'Banco',
				            valueField: 'idBanco'
				            
				        }
				],
				buttons : [ {
								text: 'Guardar',
								handler: function(boton, evento) {
									formularioAlta.getForm().submit({
										url: '../ServletNuevo',
										method:'POST',
										formBind: true,
										failure: function(form, action) {
											Ext.MessageBox.show({
												title: 'Error',
												msg: 'Los datos no se guardaron correctamente',
												buttons: Ext.MessageBox.OK,
												icons: Ext.MessageBox.ERROR
											});
											
										},
										success: function(form, request) {
											storeClientes.load();
										}
									});
								}
							}
				           ]
			});

	
	accordionMenu.render('menuCtes');
	gridClientes.render('consultaCtes');
	formularioAlta.render('nuevoCtes');
	
	//alert("valor de storeClientes" + storeClientes);
});

/*
private int idbanco;
private int edad;
private String amaterno;
private String apaterno;
private String nombre;
private int idcliente;

*/