package com.micha.elecciones.controller;

import com.micha.elecciones.model.entities.Socio;
import com.micha.elecciones.service.service.ISocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
@RestController
@RequestMapping("/api/socio")
public class SocioController {

    @Autowired
    private ISocioService procesoService;


    @PostMapping("")
    Socio crear(@RequestBody @Validated Socio socio) {

        return procesoService.save(socio);
    }

    @GetMapping("")
    Page<Socio> getSocios(@PageableDefault( size = 20) Pageable pageable) {
        Page<Socio> socioPage = procesoService.findAll(pageable);

        return socioPage;
    }

    @GetMapping("/{id}")
    Socio getSocio(@PathVariable Integer id) {
        Socio Socio = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return Socio;
    }

    @PutMapping("/{id}")
    Socio actualizarSocio(@PathVariable Integer id, @RequestBody @Validated Socio socio) {
        Socio socioFromDb = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        socioFromDb.setFechaIngreso(socio.getFechaIngreso());
        socioFromDb.setSaldoAporte(socio.getSaldoAporte());
        socioFromDb.setPersona(socio.getPersona());
        socioFromDb.setAgencia(socio.getAgencia());
        return procesoService.save(socioFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarSocio(@PathVariable Integer id) {
        Socio socio = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        procesoService.delete(socio.getId());
    }

}
