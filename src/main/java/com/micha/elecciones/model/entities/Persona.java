package com.micha.elecciones.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellidoPaterno;

    @NotNull
    private String apellidoMaterno;

    @NotNull
    private Integer dni;

    @NotNull
    private String sexo;

    @NotNull
    private String tipoPersona;

    @NotNull
    private LocalDateTime fechaNacimiento;

    private String fullnombre;



    @PrePersist
    public void llenarTipoPersona(){
        this.tipoPersona = "Natural";
        this.fullnombre = this.apellidoPaterno +" " + this.apellidoMaterno+" "+this.nombre;
    }

    @PreUpdate
    public void update(){
        this.fullnombre = this.apellidoPaterno +" " + this.apellidoMaterno+" "+this.nombre;
    }
}
