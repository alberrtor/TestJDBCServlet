package net.javagurus.dto;

import java.io.Serializable;

//Se implementa Serializable para que pueda viajar por la red y se puede descifrar.
public class ClienteDTO implements Serializable{
	private int idbanco;
	private int edad;
	private String amaterno;
	private String apaterno;
	private String nombre;
	private int idcliente;
	public int getIdbanco() {
		return idbanco;
	}
	public void setIdbanco(int idbanco) {
		this.idbanco = idbanco;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	
}
