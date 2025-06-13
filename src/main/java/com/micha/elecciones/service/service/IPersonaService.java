package com.micha.elecciones.service.service;

import com.micha.elecciones.model.entities.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonaService extends ICRUD<Persona,Integer>{
    public Page<Persona> findAll(Pageable page);

}
