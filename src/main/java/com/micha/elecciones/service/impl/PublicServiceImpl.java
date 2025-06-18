package com.micha.elecciones.service.impl;

import com.micha.elecciones.exception.IdNoExiste;
import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.service.service.ICandidatoService;
import com.micha.elecciones.service.service.IListaService;
import com.micha.elecciones.service.service.IProcesoElectoralService;
import com.micha.elecciones.service.service.IPublicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class PublicServiceImpl implements IPublicService {
    private IListaService iListaService;
    private IProcesoElectoralService iProcesoElectoralService;
    private ICandidatoService iCandidatoService;
    @Override
    public List<ProcesoElectoral> procesos() {
        List<ProcesoElectoral>procesoElectorales=iProcesoElectoralService.findAll();

        return procesoElectorales;
    }

    @Override
    public ProcesoElectoral OneProceso(Integer id) {
        ProcesoElectoral procesoElectoral= iProcesoElectoralService.findOne(id).orElseThrow(()-> new IdNoExiste(id.toString(),"Proceso Electoral"));
        return procesoElectoral;
    }

    @Override
    public List<Lista> listas(Integer idProceso) {
        List<Lista> listas= iListaService.findAll();
        List<Lista> listaFinal=new ArrayList<>();
        listas.stream().filter(lista -> lista.getProcesoElectoral().getId().equals(idProceso)).forEach(listaFinal::add);
        return listaFinal;
    }

    @Override
    public Lista oneLista(Integer idLista) {
        Lista lista = iListaService.findOne(idLista).orElseThrow(()-> new IdNoExiste(idLista.toString(),"Lista Electoral"));
        return lista;
    }

    @Override
    public List<Candidato> candidatos(Integer idLista) {
        List<Candidato> candidatoList=iCandidatoService.findAll();
        List<Candidato> candidatosFinal=new ArrayList<>();
        candidatoList.stream().filter(cand->cand.getLista().getId().equals(idLista)).forEach(candidatosFinal::add);
        return candidatosFinal;
    }

    @Override
    public Candidato oneCandidato(Integer idCandidato) {
        Candidato candidato=iCandidatoService.findOne(idCandidato).orElseThrow(()->new IdNoExiste(idCandidato.toString(),"Candidatos"));

        return candidato;
    }
}
