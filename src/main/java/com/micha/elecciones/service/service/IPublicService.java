package com.micha.elecciones.service.service;

import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.model.entities.ProcesoElectoral;

import java.util.List;

public interface IPublicService {
    List<ProcesoElectoral> procesos();
    ProcesoElectoral OneProceso(Integer id);
    List<Lista> listas(Integer idProceso);
    Lista oneLista(Integer idLista);

    List<Candidato> candidatos(Integer idLista);
    Candidato oneCandidato(Integer idCandidato);

}
