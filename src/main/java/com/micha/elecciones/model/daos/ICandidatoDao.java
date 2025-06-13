package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICandidatoDao extends JpaRepository<Candidato,Integer> {

    List<Candidato> findByLista(Lista lista);
}
