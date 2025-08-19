package com.first_api_project.business.services;

import com.first_api_project.business.models.TurmaBO;

import java.util.List;

public interface TurmaService_interface {
    TurmaBO cadastrarTurma(TurmaBO turmaBO);

    TurmaBO findById(int turmaId);

    List<TurmaBO> findAll();

    List<TurmaBO> findByPeriodo(String periodo);

    List<TurmaBO> findByCurso(String curso);

    void deleteById(int turmaId);
}
