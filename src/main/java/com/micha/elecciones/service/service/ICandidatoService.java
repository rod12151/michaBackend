package com.micha.elecciones.service.service;

import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;

import java.util.List;


public interface ICandidatoService extends ICRUD<Candidato,Integer>{

    public List<Candidato> findByLista(Lista lista);
}
