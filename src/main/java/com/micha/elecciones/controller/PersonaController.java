package com.micha.elecciones.controller;

import com.micha.elecciones.model.entities.Persona;
import com.micha.elecciones.service.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService procesoService;


    @PostMapping("")
    Persona crear(@RequestBody @Validated Persona persona) {

        return procesoService.save(persona);
    }

    @GetMapping("")
    Page<Persona> getPersonas(@PageableDefault( size = 20) Pageable pageable) {
        Page<Persona> personaPage = procesoService.findAll(pageable);

        return personaPage;
    }

    @GetMapping("/{id}")
    Persona getPersona(@PathVariable Integer id) {
        Persona Persona = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return Persona;
    }

    @PutMapping("/{id}")
    Persona actualizarPersona(@PathVariable Integer id, @RequestBody @Validated Persona persona) {
        Persona personaFromDb = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        personaFromDb.setNombre(persona.getNombre());
        personaFromDb.setApellidoPaterno(persona.getApellidoPaterno());
        personaFromDb.setApellidoMaterno(persona.getApellidoMaterno());
        personaFromDb.setDni(persona.getDni());
        personaFromDb.setSexo(persona.getSexo());
        personaFromDb.setTipoPersona(persona.getTipoPersona());
        personaFromDb.setFechaNacimiento(persona.getFechaNacimiento());
        return procesoService.save(personaFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarPersona(@PathVariable Integer id) {
        Persona persona = procesoService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        procesoService.delete(persona.getId());
    }

}
