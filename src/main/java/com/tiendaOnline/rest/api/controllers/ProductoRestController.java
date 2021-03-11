package com.tiendaOnline.rest.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tiendaOnline.rest.api.models.dto.Producto;
import com.tiendaOnline.rest.api.models.dto.Usuario;
import com.tiendaOnline.rest.api.service.ProductoServiceImpl;

@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE} )
@RestController

public class ProductoRestController {

	
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	

	// http://localhost:8080/clientes/listar (GET)
	@GetMapping({"/tienda","/productos"})
	public List<Producto> listarProductos() {

		return productoServiceImpl.findAllProductos();
	}
	//ok
	// http://localhost:8080/clientes/buscar/{nombreUsuario} (GET)
	@GetMapping(value = {"tienda/buscar/{codigoProducto}","{productos/buscar/{codigoProducto}"})
	public Producto buscarProducto(@PathVariable("codigoProducto") Integer codigoProducto) {

		return productoServiceImpl.findProductoById(codigoProducto);

	}
	
	
	
	// http://localhost:8080/clientes/crear (ADD)
	@PostMapping("/productos/crear")
//	@ResponseStatus(HttpStatus.CREATED)
	public Producto crear(@RequestBody Producto producto) {
		System.out.println("-----------------------------------------------");
		System.out.println(producto.getNombretitulo());
		System.out.println("-----------------------------------------------");
//		cli.setPassword(encoder.encode(cli.getPassword()));
		return productoServiceImpl.saveProducto(producto);

	}
	
	// http://localhost:8080/modificar/nombreUsuario (put)
	@PutMapping(value = "/productos/editar/{codigoProducto}")
//	@ResponseStatus(HttpStatus.CREATED)
	public Producto modificar(@RequestBody Producto producto,@PathVariable("codigoProducto") Integer codigoProducto) {
		Producto productoActual =productoServiceImpl.findProductoById(codigoProducto);

		productoActual.setCodigoproducto(producto.getCodigoproducto());
		productoActual.setNombretitulo(producto.getNombretitulo());
		productoActual.setImagen(producto.getImagen());
		productoActual.setPrecio(producto.getPrecio());
	
		return 	productoServiceImpl.saveProducto(productoActual);	
		
	}
	@GetMapping(value = "productos/buscar/{codigoproducto}")
	public Producto buscarPelicula(@PathVariable("codigoproducto") Integer codigoproducto) {

		return productoServiceImpl.findProductoById(codigoproducto);

	}
	@DeleteMapping(value = "/productos/eliminar/{codigoproducto}")
	public boolean eliminar(@PathVariable("codigoproducto") Integer codigoproducto) {
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("codigo producto: "+codigoproducto);
		productoServiceImpl.deleteProducto(codigoproducto);
		System.out.println("codigo productoeliminado");
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
