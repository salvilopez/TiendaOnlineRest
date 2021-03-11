package com.tiendaOnline.rest.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendaOnline.rest.api.models.dto.Producto;



public interface IProductoDao extends JpaRepository<Producto, Integer>{

}
