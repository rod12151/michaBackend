package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotacionDao extends JpaRepository<Votacion,Integer> {
}
