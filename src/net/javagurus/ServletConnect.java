package net.javagurus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dao.ClienteDAOImpl;
import net.javagurus.dto.ClienteDTO;

/**
 * Servlet implementation class ServletConnect
 */
public class ServletConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Constructor
	public ServletConnect() {
		super(); // Se manda a llamar el super constructor de la clase
					// HttpServlet
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	private String url;
	private String usr;
	private String pwd;
	private String db;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// Este metodo es el que se ejecuta primero
	public void init() throws ServletException {
		url = "jdbc:oracle:thin:@192.168.1.85:1521";
		db = ":XE";
		usr = "SYSTEM";
		pwd = "oracle";
	}

	private IClienteDAO dao;
	private ArrayList<ClienteDTO> ctes;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		dao = new ClienteDAOImpl();
		
		try {
			ctes = dao.getAll();
			
			for(ClienteDTO element: ctes){
				System.out.println("Nombre del cliente: " + element.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
