package com.micha.elecciones.service.impl;

import com.micha.elecciones.model.daos.ISocioDao;
import com.micha.elecciones.model.entities.Persona;
import com.micha.elecciones.model.entities.Socio;
import com.micha.elecciones.service.service.ISocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SocioServiceImpl extends CRUDImpl<Socio, Integer> implements ISocioService {
    @Autowired
    private ISocioDao dao;

    @Override
    protected JpaRepository<Socio, Integer> getDao() {
        return dao;
    }

    @Override
    public Page<Socio> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
