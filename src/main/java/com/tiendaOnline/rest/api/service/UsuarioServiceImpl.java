package com.tiendaOnline.rest.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaOnline.rest.api.models.dao.IUsuarioDao;
import com.tiendaOnline.rest.api.models.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao iUsuarioDao;
	
	@Override
	public List<Usuario> findAllUsuarios() {
		return iUsuarioDao.findAll();
	}

	@Override
	public Usuario findUsuarioById(String nombreUsuario) {
		return iUsuarioDao.findById(nombreUsuario).get();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return iUsuarioDao.save(usuario);
	}

	@Override
	public void deleteUsuario(String nombreUsuario) {
		iUsuarioDao.deleteById(nombreUsuario);
	}

}
