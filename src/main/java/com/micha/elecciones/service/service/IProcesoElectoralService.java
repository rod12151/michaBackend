package com.micha.elecciones.service.service;

import com.micha.elecciones.model.entities.ProcesoElectoral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProcesoElectoralService extends ICRUD<ProcesoElectoral,Integer>{

    public Page<ProcesoElectoral> findAll(Pageable page);

    //public ProcesoElectoral save(Integer id);

}
