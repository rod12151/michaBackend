package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerosnaDao extends JpaRepository<Persona,Integer> {
}
