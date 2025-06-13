package com.micha.elecciones.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Votacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_votacion")
    private Integer id;


    private LocalDateTime fechaVotacion;

    @OneToOne
    @JoinColumn(name = "id_lista", referencedColumnName = "id_lista")
    private Lista lista;

    @OneToOne
    @JoinColumn(name = "id_socio", referencedColumnName = "id_socio")
    private Socio socio;

    @PrePersist
    private void asignarFechaCreacion() {
        fechaVotacion = LocalDateTime.now();
    }

}
