package net.javagurus.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.Gson;

public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEliminar() {
		super();

	}

	static Logger log = Logger.getLogger(ServletEliminar.class);

	public void init() {

		Properties props = new Properties();

		try {
			props.load(getClass().getResourceAsStream(
					"../conf/log4j.properties"));
			PropertyConfigurator.configure(props);
		} catch (IOException e) {

			System.out.println("ERROR al cargar archivo log4j.properties");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionJSP = request.getSession(false);
		
		if (!(sessionJSP != null) || !(sessionJSP.getAttribute("usr") != null)) {
			response.sendRedirect("../login.jsp");

			return;
		}

		// IClienteDAO dao = new ClienteDAOImpl();
		// Generamos una variable de contexto de spring
		// contexto es como si fuera un espacio en memoria
		ApplicationContext context = null;
		context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

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

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("jsp/EliminarClientes.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int idcliente = Integer.parseInt(request.getParameter("cmbClientes"));
		
		ApplicationContext context = null;
		context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		
		IClienteDAO dao = context.getBean("clienteDAO", ClienteDAOImpl.class);
		
		try {
			dao.delete(idcliente);
			dao = (ClienteDAOImpl) context.getBean("clienteDAO");
			ArrayList<ClienteDTO> ctes = new ArrayList<ClienteDTO>();
					ctes = dao.getAll();
			request.setAttribute("ctes", ctes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/ResultClientes.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			log.debug("error al eliminar cliente" + e);
		}
		
	}

}
