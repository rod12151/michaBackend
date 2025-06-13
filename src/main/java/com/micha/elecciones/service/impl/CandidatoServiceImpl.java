package com.micha.elecciones.service.impl;

import com.micha.elecciones.model.daos.ICandidatoDao;
import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.service.service.ICandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoServiceImpl extends CRUDImpl <Candidato,Integer> implements ICandidatoService {

    @Autowired
    private ICandidatoDao dao;

    @Override
    protected JpaRepository<Candidato, Integer> getDao() {
        return dao;
    }

    @Override
    public List<Candidato> findByLista(Lista lista) {
        return dao.findByLista(lista);
    }
}
