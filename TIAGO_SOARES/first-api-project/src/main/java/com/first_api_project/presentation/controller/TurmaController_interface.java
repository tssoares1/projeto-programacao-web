package com.first_api_project.presentation.controller;

import com.first_api_project.presentation.models.TurmaDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TurmaController_interface {

    TurmaDTO cadastrarTurma(@RequestBody TurmaDTO turmaDTO);

    TurmaDTO buscarTurma(@PathVariable int turmaId);

    List<TurmaDTO> listarTurmas();

    List<TurmaDTO> buscarTumasPorPeriodo(@PathVariable String periodo);

    void removerTurma(@PathVariable int turmaId);
}
