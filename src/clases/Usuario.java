package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Usuario {
	private String nombre;
	private String contraseña;
	private int nivel;

	
	public Usuario(String nombre, String contraseña, int nivel){
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.nivel = nivel;	
	}
	
	
	/**
	 * Metodo que obtiene el nombre de un usuario.
	 * 
	 * @return nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que modifica el nombre de un usuario.
	 * 
	 * @param nombre nuevo nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**
	 * Metodo que obtiene la contraseña de un usuario.
	 * 
	 * @return contraseña del usuario.
	 */
	public String getContraseña() {
		return contraseña;
	}
	
	
	/**
	 * Metodo que modifica la contraseña de un usuario.
	 * 
	 * @param contraseña nueva contraseña.
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	/**
	 * Metodo que obtiene el nivel de un usuario.
	 * 
	 * @return nivel del usuario.
	 */
	public int getNivel() {
		return nivel;
	}

	
	/**
	 * Metodo que modifica el nivel de un usuario.
	 * 
	 * @param nivel nuevo nivel.
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}


	
}