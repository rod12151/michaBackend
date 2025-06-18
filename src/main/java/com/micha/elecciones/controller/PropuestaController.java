package com.micha.elecciones.controller;

import com.micha.elecciones.controller.models.request.PropuestaRequest;
import com.micha.elecciones.model.entities.Propuesta;
import com.micha.elecciones.service.service.IPropuestaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/propuesta")
@AllArgsConstructor
public class PropuestaController {
    private final IPropuestaService propuestaService;
    @PostMapping("/crear/{id}")
    public ResponseEntity<Propuesta> crear(@PathVariable Integer id, @RequestBody PropuestaRequest propuesta){
        return ResponseEntity.ok(propuestaService.crearPropuesta(id,propuesta));
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propuesta> actualizar(@PathVariable Long id, @RequestBody PropuestaRequest propuesta){
        return ResponseEntity.ok(propuestaService.editarPropuesta(id, propuesta));
    }
    @GetMapping("/lista")
    public ResponseEntity<List<Propuesta>> list(){
        return ResponseEntity.ok(propuestaService.listaPropuesta());

    }
    @GetMapping("/lista/{id}")
    public ResponseEntity<List<Propuesta>> listByIDLista(@PathVariable Integer id){
        return ResponseEntity.ok(propuestaService.listaByIdLista(id));

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> eliminarPropuesta(@PathVariable Long id){
        propuestaService.eliminarPropuesta(id);
        return ResponseEntity.noContent().build();
    }
}
