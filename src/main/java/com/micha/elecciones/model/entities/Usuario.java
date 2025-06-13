package com.micha.elecciones.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    private String nombreCompleto;

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    private LocalDateTime fechaRegistro;

    @JsonIgnore
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 4)
    @Transient
    private String passwordPlain;

    public enum Rol {
        ADMIN,
        LECTOR
    }

    @PrePersist
    private void prePersist() {
        fechaRegistro = LocalDateTime.now();
        nombreCompleto = nombres + " " + apellidos;
    }

    @PreUpdate
    private void preUpdate() {
        nombreCompleto = nombres + " " + apellidos;
    }

}
