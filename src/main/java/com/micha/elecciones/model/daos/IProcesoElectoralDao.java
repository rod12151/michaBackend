package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.ProcesoElectoral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProcesoElectoralDao extends JpaRepository<ProcesoElectoral, Integer> {

}
