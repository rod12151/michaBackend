package com.micha.elecciones.service.impl;


import com.micha.elecciones.model.daos.IProcesoElectoralDao;
import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.service.service.IProcesoElectoralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;




@Service
public class ProcesoElectoralServiseImpl extends CRUDImpl<ProcesoElectoral, Integer> implements IProcesoElectoralService {
    @Autowired
    private IProcesoElectoralDao dao;

    @Override
    protected JpaRepository<ProcesoElectoral, Integer> getDao() {
        return dao;
    }

    @Override
    public Page<ProcesoElectoral> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
