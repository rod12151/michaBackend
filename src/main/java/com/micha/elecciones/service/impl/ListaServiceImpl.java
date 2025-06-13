package com.micha.elecciones.service.impl;


import com.micha.elecciones.model.daos.IListaDao;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.service.service.IListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaServiceImpl extends CRUDImpl<Lista, Integer> implements IListaService {

    @Autowired
    private IListaDao dao;

    @Override
    protected JpaRepository<Lista, Integer> getDao() {
        return dao;
    }
}
