package com.micha.elecciones.controller;


import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.service.service.ICandidatoService;
import com.micha.elecciones.service.service.ICandidatoService;
import com.micha.elecciones.service.service.IListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/candidato")
public class CandidatoController extends BaseController{

    @Autowired
    private ICandidatoService candidatoService;

    @Autowired
    private IListaService listaService;


    @PostMapping("{id}")
    Candidato crear(@RequestBody @Validated Candidato candidato,@PathVariable Integer id) {


        candidato.setLista(listaService.findOne(id).orElseThrow(EntityNotFoundException::new));
        System.out.println("el candidato es /n"+candidato);
        return candidatoService.save(candidato);
    }

    @GetMapping("")
    List<Candidato> getCandidatos() {
        List<Candidato> candidatos = candidatoService.findAll();
        return candidatos;
    }

    @GetMapping("/lista/{id}")
    List<Candidato> getCandidatosbyLista(@PathVariable Integer id) {
        Lista lista = listaService.findOne(id).orElseThrow(EntityNotFoundException::new);
        List<Candidato> candidatos = candidatoService.findByLista(lista);
        return candidatos;
    }

    @GetMapping("/{id}")
    Candidato getCandidato(@PathVariable Integer id) {
        Candidato Candidato = candidatoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return Candidato;
    }

    @PutMapping("/{id}")
    Candidato actualizarCandidato(@PathVariable Integer id, @RequestBody @Validated Candidato candidato) {
        Candidato candidatoFromDb = candidatoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
        candidatoFromDb.setEvaluacion(false);
        return candidatoService.save(candidatoFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarCandidato(@PathVariable Integer id) {
        Candidato candidato = candidatoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        candidatoService.delete(candidato.getId());
    }

}
