
package net.javagurus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ServletBuscar
 */
public class ServletBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletBuscar() {
        super();
       
    }
    
	static Logger log= Logger.getLogger(ServletBuscar.class);

	public void init(){
		
		Properties props = new Properties();

		try {
			props.load(getClass().getResourceAsStream("../conf/log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (IOException e) {
			
			System.out.println("ERROR al cargar archivo log4j.properties");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false) == null){
			response.sendRedirect("jsp/Login.jsp");
			return ;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/BuscarClientes.jsp");
		dispatcher.forward(request, response);

	}

	private IClienteDAO dataManager;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ApplicationContext context = null;
		context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		
		if(request.getSession(false) == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("cmbBancos") != null){
			
			String idBanco = request.getParameter("cmbBancos");
			

			RequestDispatcher dispatcher = null;
			try {
				dataManager = (ClienteDAOImpl) context.getBean("clienteDAO");
				ArrayList<ClienteDTO> ctes = new ArrayList<ClienteDTO>(
						dataManager.find(Integer.parseInt(idBanco)));
				request.setAttribute("ctes", ctes);
				dispatcher = request.getRequestDispatcher("jsp/ResultClientes.jsp");
			} catch (Exception e) {
				log.debug("error post servletbuscar:" + e.getMessage());
				dispatcher = request.getRequestDispatcher("jsp/error.jsp");
				
			}
			dispatcher.forward(request, response);
		}
	
	}

}
