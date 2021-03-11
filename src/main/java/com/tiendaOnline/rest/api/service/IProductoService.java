package com.tiendaOnline.rest.api.service;

import java.util.List;

import com.tiendaOnline.rest.api.models.dto.Producto;


public interface IProductoService {
	public List<Producto> findAllProductos();	
	public Producto findProductoById(Integer codigoProducto);	
	public Producto saveProducto(Producto producto);	
	public void deleteProducto(Integer codigoProducto);
}
