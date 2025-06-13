package com.micha.elecciones.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
//@Table(name = "proceso_electoral") no ees necesrio por que JPA ase la conversion interna de snake_case a camelCase
public class ProcesoElectoral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso")
    private Integer id;

    @NotNull
    @Column(name = "nombre_proceso")
    private String nombreProceso;

    private String estado;


    private LocalDateTime fechaRegistro;

    private LocalDateTime fechaIniProc;

    private LocalDateTime fechaFinProc;

    @JsonIgnore
    @OneToMany(mappedBy = "procesoElectoral", cascade = CascadeType.ALL)
    private List<Lista> listas;

    @PrePersist
    private void asignarFechaCreacion() {
        fechaRegistro = LocalDateTime.now();
        estado = "REGISTRADO";
    }


}
