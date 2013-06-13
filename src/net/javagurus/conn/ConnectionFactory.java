package net.javagurus.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConnectionFactory {

	private String url;
	private String usr;
	private String pwd;
	private String db;
	private Connection conn;
	private static ConnectionFactory connectionFactory;
	
	static Logger log = Logger.getLogger(ConnectionFactory.class);
	
	private ConnectionFactory() {
		url = "jdbc:postgresql://10.4.7.3:5432/borrar";
		usr = "kylix";
		pwd = "kylix";
		
		Properties props = new Properties();
		try {
			props.load(getClass().getResourceAsStream("../conf/log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (IOException e) {
			System.out.println("Error al cargar el archvo log4j.properties");
			e.printStackTrace();
		}
		
		

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public Connection getConnection() throws SQLException{
		
		log.debug("conectandose a DB: s" + url  + "user: " + usr + "pwd:" + pwd);
		
		conn = DriverManager.getConnection(url, usr, pwd);
		
		return conn;
	}
	
	//Declaramos metodo singleton, que solo haya una referencia del objeto ConnectionFactory
	public static ConnectionFactory getInstance(){
		if (connectionFactory == null){
			connectionFactory = new ConnectionFactory();
		}
	
		return connectionFactory;
	}
}
