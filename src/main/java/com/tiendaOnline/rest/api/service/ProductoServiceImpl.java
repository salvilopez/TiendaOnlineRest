package com.tiendaOnline.rest.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaOnline.rest.api.models.dao.IProductoDao;
import com.tiendaOnline.rest.api.models.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	
	@Autowired
	private IProductoDao iProductoDao;

	@Override
	public List<Producto> findAllProductos() {

		return iProductoDao.findAll();
	}

	@Override
	public Producto findProductoById(Integer codigoProducto) {
		return iProductoDao.findById(codigoProducto).get();
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return iProductoDao.save(producto);
	}

	@Override
	public void deleteProducto(Integer codigoProducto) {
		iProductoDao.deleteById(codigoProducto);
	}

}
