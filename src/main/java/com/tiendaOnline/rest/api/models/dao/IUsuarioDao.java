package com.tiendaOnline.rest.api.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiendaOnline.rest.api.models.dto.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, String>{

}
