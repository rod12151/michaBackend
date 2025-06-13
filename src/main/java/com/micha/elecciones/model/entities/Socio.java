package com.micha.elecciones.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_socio")
    private Integer id;

    @NotNull
    private LocalDate FechaIngreso;

    @NotNull
    private double saldoAporte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "id_agencia", referencedColumnName = "id_agencia")
    private Agencia agencia;


}
