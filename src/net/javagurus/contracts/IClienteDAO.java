package net.javagurus.contracts;

import java.util.ArrayList;

import net.javagurus.dto.ClienteDTO;

public interface IClienteDAO {
	public boolean add(ClienteDTO dto) throws Exception;
	
	//puede lanzar una Exepcion, por ejemplo no tenemos permisos
	public ArrayList<ClienteDTO> getAll() throws Exception;
	
	public ArrayList<ClienteDTO> find(int idBanco) throws Exception;
	
	public boolean delete(int idCliente) throws Exception;
	
	public boolean update(ClienteDTO dto) throws Exception;
}
