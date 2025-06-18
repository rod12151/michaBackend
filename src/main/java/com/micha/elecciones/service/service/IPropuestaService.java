package com.micha.elecciones.service.service;

import com.micha.elecciones.controller.models.request.PropuestaRequest;
import com.micha.elecciones.model.entities.Propuesta;

import java.util.List;

public interface IPropuestaService {
     Propuesta crearPropuesta(Integer idLista, PropuestaRequest propuesta);
     Propuesta editarPropuesta(Long id,PropuestaRequest propuesta);
     List<Propuesta> listaPropuesta();
     List<Propuesta> listaByIdLista(Integer idLista);
     void eliminarPropuesta(Long id);

}
