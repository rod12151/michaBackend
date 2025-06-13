package com.micha.elecciones.service.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ICRUD<T,ID> {

    public List<T> findAll();

    public T save(T t);

    public Optional<T> findOne(ID ID);

    public void delete(ID ID);


}
