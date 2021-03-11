package com.tiendaOnline.rest.api.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiendaOnline.rest.api.models.dto.Usuario;
import com.tiendaOnline.rest.api.service.UsuarioServiceImpl;


@RequestMapping("/")
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE} )
@RestController
public class UsuarioRestController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	

	@GetMapping("usuarios")
	public List<Usuario> listarUsuarios() {
		return usuarioServiceImpl.findAllUsuarios();
	}


	/**
	 *
	 * @param usu
	 * @param request
	 * @param response
	 * @return Usuario
	 * @throws ServletException
	 * @throws IOException
	 */
	@PostMapping("login")
	public Usuario loguearse(@RequestBody Usuario usu,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(usu.getNombreusuario()!=""|| usu.getNombreusuario()!=null) {
			List<Usuario> listaUsuarios=usuarioServiceImpl.findAllUsuarios();
			for(var i=0;i<listaUsuarios.size();i++) {
				if (listaUsuarios.get(i).getNombreusuario().equals(usu.getNombreusuario())&&listaUsuarios.get(i).getPassword().equals(usu.getPassword())) {
					Usuario usuario =usuarioServiceImpl.findUsuarioById(usu.getNombreusuario());
					return usuario;
				} 	
			}
		}

		return null;
	}
	@GetMapping("cerrarSesion")
	public void cerrarSesion(HttpServletRequest request) throws ServletException, IOException {
		HttpSession misession= request.getSession(true);
		misession.invalidate();
	}
	@GetMapping(value = "usuarios/buscar/{nombreusuario}")
	public Usuario buscarPelicula(@PathVariable("nombreusuario") String nombreusuario) {

		return usuarioServiceImpl.findUsuarioById(nombreusuario);

	}

	@DeleteMapping(value = "usuarios/eliminar/{nombreusuario}")
	public boolean eliminar(@PathVariable("nombreusuario") String nombreusuario) {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("nombre usuario: "+nombreusuario);
		usuarioServiceImpl.deleteUsuario(nombreusuario);
		System.out.println("codigo nombreusuario");
		return true;
	}
	
	@PostMapping("usuarios/crear")
//	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		System.out.println("-----------------------------------------------");
		System.out.println(usuario.getNombreusuario());
		System.out.println("-----------------------------------------------");
//		cli.setPassword(encoder.encode(cli.getPassword()));
		return usuarioServiceImpl.saveUsuario(usuario);

	}
	// http://localhost:8080/modificar/nombreUsuario (put)
	@PutMapping(value = "/usuarios/editar/{nombreusuario}")
//	@ResponseStatus(HttpStatus.CREATED)
	public Usuario modificar(@RequestBody Usuario usuario,@PathVariable("nombreusuario") String nombreusuario) {
		Usuario usuarioActual =usuarioServiceImpl.findUsuarioById(nombreusuario);
		usuarioActual.setNombreusuario(usuario.getNombreusuario());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setPassword(usuario.getPassword());
		return 	usuarioServiceImpl.saveUsuario(usuarioActual);

	}
}
