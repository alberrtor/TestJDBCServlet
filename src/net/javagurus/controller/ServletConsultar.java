package net.javagurus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;

public class ServletConsultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionJSP = request.getSession(false);
		if(!(sessionJSP !=null) || !(sessionJSP.getAttribute("usr") != null)){
			response.sendRedirect("../login.jsp");
			
			return;
		}
		
		//IClienteDAO dao = new ClienteDAOImpl();
		//Generamos una variable de contexto de spring
		//contexto es como si fuera un espacio en memoria
		ApplicationContext context = null;
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IClienteDAO dao = (ClienteDAOImpl) context.getBean("clienteDAO");
		
		ArrayList<ClienteDTO> listaCtes = null;
		try {
			 listaCtes = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("ctes", listaCtes);
		
		Gson json = new Gson();
		String objJSON = json.toJson(listaCtes);
		
		System.out.println("{\"clientes\":" + objJSON + "}");
		System.out.println("{\"success\"}");
		System.out.println("{\"failure\"}");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/ResultClientes.jsp");
		//dispatcher.forward(request, response);
		PrintWriter out = response.getWriter();
		out.print("{\"clientes\":" + objJSON + "}");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
