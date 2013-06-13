package net.javagurus.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;


public class ServletNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDTO dto = null;
       
    public ServletNuevo() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionJSP = request.getSession(false);
		if(!(sessionJSP !=null) || !(sessionJSP.getAttribute("usr") != null)){
			response.sendRedirect("../login.jsp");
			
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/NuevoCliente.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//IClienteDAO dao = new ClienteDAOImpl();
		ApplicationContext context = null;
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		IClienteDAO dao = (ClienteDAOImpl) context.getBean("clienteDAO");
		
		
		dto = new ClienteDTO();
		dto.setAmaterno(request.getParameter("amaterno"));
		dto.setApaterno(request.getParameter("apaterno"));
		dto.setNombre(request.getParameter("nombre"));
		dto.setEdad(Integer.parseInt(request.getParameter("edad")));
		dto.setIdbanco(Integer.parseInt(request.getParameter("banco")));
		dto.setIdcliente(1);
		
		RequestDispatcher dispatcher;
		
		try {
			if (dao.add(dto)){
				PrintWriter out = response.getWriter();
				out.print("{success:true}");
				
				
				//dispatcher = request.getRequestDispatcher("jsp/ResultClientes.jsp");
			//request.setAttribute("ctes", dao.getAll());
			//dispatcher.forward(request, response);
			}else{
				dispatcher = request.getRequestDispatcher("jsp/error.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
