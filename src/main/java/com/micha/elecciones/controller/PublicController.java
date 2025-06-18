package com.micha.elecciones.controller;

import com.micha.elecciones.model.entities.Candidato;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.model.entities.ProcesoElectoral;
import com.micha.elecciones.service.service.IPublicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/public")
public class PublicController {
    private final IPublicService iPublicService;
    @GetMapping("/procesos")
    public ResponseEntity<List<ProcesoElectoral>> procesos(){
       return ResponseEntity.ok(iPublicService.procesos());
    }
    @GetMapping("/proceso/{id}")
    public ResponseEntity<ProcesoElectoral> OneProceso(@PathVariable Integer id){
        return ResponseEntity.ok(iPublicService.OneProceso(id));
    }
    @GetMapping("/listas/{id}")
    public ResponseEntity<List<Lista>> listas( @PathVariable Integer id){
        return ResponseEntity.ok(iPublicService.listas(id));
    }
    @GetMapping("/lista/{idLista}")
    public ResponseEntity<Lista> oneLista(@PathVariable Integer idLista){
        return ResponseEntity.ok(iPublicService.oneLista(idLista));
    }
    @GetMapping("/candidatos/{idLista}")
    public ResponseEntity<List<Candidato>> candidatos(@PathVariable Integer idLista){
        return ResponseEntity.ok(iPublicService.candidatos(idLista));
    }
    @GetMapping("/candidato/{idCandidato}")
    public ResponseEntity<Candidato> oneCandidato(@PathVariable Integer idCandidato){
        return ResponseEntity.ok(iPublicService.oneCandidato(idCandidato));
    }
}
