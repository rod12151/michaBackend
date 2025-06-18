package com.micha.elecciones.service.impl;

import com.micha.elecciones.controller.models.request.PropuestaRequest;
import com.micha.elecciones.exception.IdNoExiste;
import com.micha.elecciones.model.daos.IListaDao;
import com.micha.elecciones.model.daos.PropuestaRepository;
import com.micha.elecciones.model.entities.Lista;
import com.micha.elecciones.model.entities.Propuesta;
import com.micha.elecciones.service.service.IPropuestaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PropuestaServiceImpl implements IPropuestaService {
    private IListaDao iListaDao;
    private PropuestaRepository propuestaRepository;
    @Override
    public Propuesta crearPropuesta(Integer idLista, PropuestaRequest propuesta) {

       Lista lista = iListaDao.findById(idLista).orElseThrow(()-> new IdNoExiste(idLista.toString(),"ListaCandidatos"));

       Propuesta propuesta1 = Propuesta.builder()
               .propuesta(propuesta.getPropuesta())
               .lista(lista)
               .build();
       propuestaRepository.save(propuesta1);
       return propuesta1;
    }

    @Override
    public Propuesta editarPropuesta(Long id, PropuestaRequest propuesta) {
        Propuesta propuestaUpdate = propuestaRepository.findById(id).orElseThrow(()->new IdNoExiste(id.toString(),"Propuesta"));
        propuestaUpdate.setPropuesta(propuesta.getPropuesta());
        propuestaRepository.save(propuestaUpdate);
        return propuestaUpdate;
    }

    @Override
    public List<Propuesta> listaPropuesta() {
        return propuestaRepository.findAll();
    }

    @Override
    public List<Propuesta> listaByIdLista(Integer idLista) {
        Optional<Lista> lista = iListaDao.findById(idLista);
        if (lista.isPresent()) {
            return propuestaRepository.findAllByIdLista(idLista);
        } else {
           throw  new IdNoExiste(idLista.toString(), "Lista");

        }

    }

    @Override
    public void eliminarPropuesta(Long id) {
        Propuesta propuesta = propuestaRepository.findById(id).orElseThrow(()->new IdNoExiste(id.toString(),"Propuesta"));
        propuestaRepository.delete(propuesta);

    }
}
