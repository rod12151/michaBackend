package com.micha.elecciones.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString(exclude = "lista")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato")
    private Integer Id;

    @NotNull
    private boolean evaluacion;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;


    @OneToOne
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    private Socio socio;

    @JsonIgnore
    @ManyToOne

    @JoinColumn(name = "id_lista", referencedColumnName = "id_lista")
    private Lista lista;

    public enum Cargo {
        PRESIDENTE,
        VICEPRESIDENTE,
        SECRETARIO,
        TESORERO,
        VOCAL
    }

}
