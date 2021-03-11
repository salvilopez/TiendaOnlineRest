package com.tiendaOnline.rest.api.service;

import java.util.List;

import com.tiendaOnline.rest.api.models.dto.Usuario;



public interface IUsuarioService {
	public List<Usuario> findAllUsuarios();	
	public Usuario findUsuarioById(String nombreUsuario);	
	public Usuario saveUsuario(Usuario usuario);	
	public void deleteUsuario(String nombreUsuario);
}
