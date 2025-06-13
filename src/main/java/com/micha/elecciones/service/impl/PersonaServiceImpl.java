package com.micha.elecciones.service.impl;

import com.micha.elecciones.model.daos.IPerosnaDao;
import com.micha.elecciones.model.entities.Persona;
import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.service.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    @Autowired
    private IPerosnaDao dao;

    @Override
    protected JpaRepository<Persona, Integer> getDao() {
        return dao;
    }

    @Override
    public Page<Persona> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
