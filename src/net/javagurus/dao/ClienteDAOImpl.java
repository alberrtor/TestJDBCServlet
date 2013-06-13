package net.javagurus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.javagurus.conn.ConnectionFactory;
import net.javagurus.contracts.IClienteDAO;
import net.javagurus.dto.ClienteDTO;

public class ClienteDAOImpl implements IClienteDAO {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conn;

	private BancoDAOImpl banco;

	public BancoDAOImpl getBanco() {
		return banco;
	}

	public void setBanco(BancoDAOImpl banco) {
		this.banco = banco;
	}

	public boolean add(ClienteDTO dto) throws Exception {

		try {
			dto.setIdcliente(getMaxId());
			conn = ConnectionFactory.getInstance().getConnection();
			String insert = "insert into cliente values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(insert);
			ps.setInt(1, dto.getIdcliente());
			ps.setString(2, dto.getNombre());
			ps.setString(3, dto.getApaterno());
			ps.setString(4, dto.getAmaterno());
			ps.setInt(5, dto.getEdad());
			ps.setInt(6, dto.getIdbanco());

			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
		}

	}

	public ArrayList<ClienteDTO> getAll() throws Exception {
		ArrayList<ClienteDTO> ctes = new ArrayList<ClienteDTO>();

		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String query = "select * from cliente";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			this.getBanco().add();
			ClienteDTO dto;

			while (rs.next()) {
				dto = new ClienteDTO();
				dto.setAmaterno(rs.getString("amaterno"));
				dto.setApaterno(rs.getString("apaterno"));
				dto.setNombre(rs.getString("nombre"));
				dto.setIdcliente(rs.getInt("idcliente"));
				dto.setEdad(rs.getInt("edad"));
				ctes.add(dto);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		return ctes;
	}

	public ArrayList<ClienteDTO> find(int idBanco) throws Exception {

		ArrayList<ClienteDTO> ctes = new ArrayList<ClienteDTO>();

		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String query = "select * from cliente where idbanco=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, idBanco);
			rs = ps.executeQuery();
			this.getBanco().add();
			ClienteDTO dto;

			while (rs.next()) {
				dto = new ClienteDTO();
				dto.setAmaterno(rs.getString("amaterno"));
				dto.setApaterno(rs.getString("apaterno"));
				dto.setNombre(rs.getString("nombre"));
				dto.setIdcliente(rs.getInt("idcliente"));
				dto.setEdad(rs.getInt("edad"));
				ctes.add(dto);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		return ctes;

	}

	public boolean delete(int idCliente) throws Exception {

		try {
			conn = ConnectionFactory.getInstance().getConnection();
			String query = "delete  from cliente where idcliente=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, idCliente);

			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		}

		
	}

	private int getMaxId() throws SQLException {

		String getMaxIDCte = "select MAX(idcliente) AS MaxCte from cliente";
		conn = ConnectionFactory.getInstance().getConnection();
		ps = conn.prepareStatement(getMaxIDCte);
		rs = ps.executeQuery();
		rs.next();

		int idCte = 0;
		if (rs.getString("MaxCte") != null) {

			idCte = Integer.parseInt(rs.getString("MaxCte"));
		}
		idCte = idCte + 1;

		return idCte;

	}

	@Override
	public boolean update(ClienteDTO dto) throws Exception {
		try {
			
			conn = ConnectionFactory.getInstance().getConnection();
			String update = "update cliente set nombre = ?,  apaterno = ?, amaterno = ?, edad = ? where idcliente = ?";
			ps = conn.prepareStatement(update);
			
			ps.setInt(5, dto.getIdcliente());
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getApaterno());
			ps.setString(3, dto.getAmaterno());
			ps.setInt(4, dto.getEdad());
			

			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			throw e;
		} finally {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
		}

	}

}
