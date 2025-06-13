package com.micha.elecciones.controller;


import com.micha.elecciones.model.entities.Agencia;
import com.micha.elecciones.service.service.IAgenciaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaControler extends BaseController {

    @Autowired
    private IAgenciaService agenciaService;


    @PostMapping("")
    Agencia crear(@RequestBody @Validated Agencia agencia) {

        return agenciaService.save(agencia);
    }

    @GetMapping("")
    List<Agencia> getAgencias() {
        List<Agencia> agencias = agenciaService.findAll();
        return agencias;
    }

    @GetMapping("/{id}")
    Agencia getAgencia(@PathVariable Integer id) {
        Agencia Agencia = agenciaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return Agencia;
    }

    @PutMapping("/{id}")
    Agencia actualizarAgencia(@PathVariable Integer id, @RequestBody @Validated Agencia Agencia) {
        Agencia AgenciaFromDb = agenciaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
        AgenciaFromDb.setNombreAgencia(Agencia.getNombreAgencia());
        return agenciaService.save(AgenciaFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarAgencia(@PathVariable Integer id) {
        Agencia Agencia = agenciaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        agenciaService.delete(Agencia.getId());
    }
    
}
