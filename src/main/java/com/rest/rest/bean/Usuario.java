/**
 * 
 */
package com.rest.rest.bean;

/**
 * @author Olivares
 *
 */
public class Usuario {

	private Integer id;
	private String email;
	private String contraseña;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
