package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISocioDao extends JpaRepository<Socio,Integer> {
}
