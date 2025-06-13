package com.micha.elecciones.service.impl;

import com.micha.elecciones.model.daos.IVotacionDao;
import com.micha.elecciones.model.entities.Votacion;
import com.micha.elecciones.service.service.IVotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VotacionServiceImpl extends CRUDImpl<Votacion, Integer> implements IVotacionService {
    @Autowired
    private IVotacionDao dao;

    @Override
    protected JpaRepository<Votacion, Integer> getDao() {
        return dao;
    }
}
