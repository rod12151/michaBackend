package com.micha.elecciones.service.impl;

import com.micha.elecciones.service.service.ICRUD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T, ID> implements ICRUD<T,ID> {

    protected abstract JpaRepository<T,ID> getDao();


    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public T save(T t) {
       return getDao().save(t);
    }

    @Override
    public Optional<T> findOne(ID ID) {
        return getDao().findById( ID);
    }

    @Override
    public void delete(ID ID) {
        getDao().deleteById(ID);
    }


}
