package com.micha.elecciones.service.impl;

import com.micha.elecciones.model.daos.IAgenciaDao;
import com.micha.elecciones.model.entities.Agencia;
import com.micha.elecciones.service.service.IAgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgenciaServiceImpl extends CRUDImpl<Agencia ,Integer> implements IAgenciaService {

    @Autowired
    private IAgenciaDao dao;

    @Override
    protected JpaRepository<Agencia, Integer> getDao() {
        return dao;
    }
}
