package com.micha.elecciones.controller;

import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.service.service.IListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaController {
    @Autowired
    private IListaService listaService;


    @PostMapping("")
    Lista crear(@RequestBody @Validated Lista lista) {
        return listaService.save(lista);
    }

    @GetMapping("")
    List<Lista> getListas() {
        List<Lista> listas = listaService.findAll();
        return listas;
    }

    @GetMapping("/{id}")
    Lista getLista(@PathVariable Integer id) {
        Lista Lista = listaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        return Lista;
    }

    @PutMapping("/{id}")
    Lista actualizarLista(@PathVariable Integer id, @RequestBody @Validated Lista lista) {
        Lista listaFromDb = listaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);
        listaFromDb.setTipoLista(lista.getTipoLista());
        listaFromDb.setNombre(lista.getNombre());
        return listaService.save(listaFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void eliminarLista(@PathVariable Integer id) {
        Lista lista = listaService.findOne(id)
                .orElseThrow(EntityNotFoundException::new);

        listaService.delete(lista.getId());
    }
}
