package com.micha.elecciones.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Propuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String propuesta;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_proveedor")
    @JsonIgnore
    private Lista lista;
}
