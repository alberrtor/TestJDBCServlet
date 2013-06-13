package net.javagurus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ServletLogin extends HttpServlet{
	
	public void init(){
		Properties props = new Properties();
		try {
			props.load(getClass().getResourceAsStream("../conf/log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (IOException e) {
			System.out.println("Error al cargar el archvo log4j.properties");
			e.printStackTrace();
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
	}

	static Logger log = Logger.getLogger(ServletLogin.class);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		log.info("petición de usuario: " + request.getParameter("usr"));
		//Si la session no existe la crea, si le pusieramos false busca una session
		//existente en el servidor y la obtiene
		HttpSession mySession = request.getSession(true);
		mySession.setAttribute("usr", request.getParameter("usr"));
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdministrarClientes.jsp");
//		dispatcher.forward(request, response);

		PrintWriter out = response.getWriter();
		out.print("{success:true}");
	}
}
