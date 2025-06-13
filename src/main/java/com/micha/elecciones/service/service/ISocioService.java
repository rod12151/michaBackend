package com.micha.elecciones.service.service;

import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.model.entities.Socio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISocioService extends ICRUD<Socio,Integer>{

    public Page<Socio> findAll(Pageable page);
}
