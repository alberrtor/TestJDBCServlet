package net.javagurus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServletUpdate
 */
public class ServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		
		sb.append(line + "\n");
		
		reader.close();
		String data = sb.toString();
		
		//Convertimos el gson a dto 
		Gson gson = new Gson();
		ClienteDTO dto = gson.fromJson(data, ClienteDTO.class);
		
		try{
			dao.update(dto);
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
