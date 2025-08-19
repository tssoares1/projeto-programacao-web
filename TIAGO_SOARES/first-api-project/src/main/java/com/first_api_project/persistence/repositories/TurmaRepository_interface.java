package com.first_api_project.persistence.repositories;

import com.first_api_project.persistence.daos.TurmaDAO;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository_interface {
    TurmaDAO save(TurmaDAO turma);

    Optional<TurmaDAO> findById(int turmaId);

    Optional<TurmaDAO> findByName(String name);

    List<TurmaDAO> findAll();

    List<TurmaDAO> findAllByPeriodo(String periodo);

    List<TurmaDAO> findAllByCurso(String curso);

    void deleteById(int turmaId);
}
