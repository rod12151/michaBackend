package com.micha.elecciones.controller;


import com.micha.elecciones.model.daos.IProcesoElectoralDao;
import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.service.service.IProcesoElectoralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/procesoElectoral")
public class ProcesoElectoralController extends  BaseController {

    @Autowired
    private IProcesoElectoralService procesoService;

    //@Autowired
    //private IProcesoElectoralDao prorepo; ingresando directo al repositorio sin la implementacion de los servicios


    @PostMapping("")
    ProcesoElectoral crear(@RequestBody @Validated ProcesoElectoral procesoElectoral) {

        return procesoService.save(procesoElectoral);

        //return prorepo.save(procesoElectoral); ingresando directo al repositorio sin la implementacion de los servicios
    }

    @GetMapping("")
    Page<ProcesoElectoral> getProcesoElectorals(@PageableDefault( size = 20) Pageable pageable) {
        Page<ProcesoElectoral> ProcesoElectoralPage = procesoService.findAll(pageable);


        return ProcesoElectoralPage;
    }

    @GetMapping("/{id}")
    ProcesoElectoral getProcesoElectoral(@PathVariable Integer id) {
        ProcesoElectoral ProcesoElectoral = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return ProcesoElectoral;
    }

    @PutMapping("/{id}")
    ProcesoElectoral actualizarProcesoElectoral(@PathVariable Integer id, @RequestBody @Validated ProcesoElectoral ProcesoElectoral) {
        ProcesoElectoral ProcesoElectoralFromDb = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        ProcesoElectoralFromDb.setNombreProceso(ProcesoElectoral.getNombreProceso());
        ProcesoElectoralFromDb.setEstado(ProcesoElectoral.getEstado());
        return procesoService.save(ProcesoElectoralFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarProcesoElectoral(@PathVariable Integer id) {
        ProcesoElectoral ProcesoElectoral = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        procesoService.delete(ProcesoElectoral.getId());
    }


}
