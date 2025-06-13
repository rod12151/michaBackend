package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgenciaDao extends JpaRepository<Agencia,Integer> {
}
