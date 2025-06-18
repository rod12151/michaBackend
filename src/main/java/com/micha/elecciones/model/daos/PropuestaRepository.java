package com.micha.elecciones.model.daos;

import com.micha.elecciones.model.entities.Propuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropuestaRepository extends JpaRepository<Propuesta,Long> {
   /* @Query("select c from curso c where c.idCurso=:idCurso")
    Optional<CursoEntity> curso(@Param("idCurso") Long idCurso);*/
    @Query("select p from Propuesta p where p.lista.id=:idLista")
    List<Propuesta> findAllByIdLista(@Param("idLista") Integer idLista);
}
