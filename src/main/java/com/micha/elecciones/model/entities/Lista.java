package com.micha.elecciones.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista")
    private Integer id;

    private String tipoLista;

    private String nombre;


    @ManyToOne
    @JoinColumn(name = "id_proceso", referencedColumnName = "id_proceso")
    private ProcesoElectoral procesoElectoral;

    private String rutaArchivo;

    @OneToMany(mappedBy = "lista")
    private List<Candidato> candidatos;

    @OneToMany(mappedBy = "propuesta")
    private List<Propuesta> propuestas;

    @PrePersist
    public void llenarTipoLista(){
        this.tipoLista = "DELEGADOS";
    }


}
