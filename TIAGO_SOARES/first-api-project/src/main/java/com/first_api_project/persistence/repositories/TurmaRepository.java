package com.first_api_project.persistence.repositories;

import com.first_api_project.persistence.daos.TurmaDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TurmaRepository implements TurmaRepository_interface{
    final List<TurmaDAO> turmas = new ArrayList<>();

    public TurmaDAO save(TurmaDAO turma) {
        turma.setId(turmas.size() + 1);
        turmas.add(turma);
        return turma;
    }

    public Optional<TurmaDAO> findById(int turmaId) {
        return turmas.stream()
                .filter(t -> t.getId() == turmaId)
                .findFirst();
    }

    @Override
    public Optional<TurmaDAO> findByName(String name) {
        return turmas.stream()
                .filter(t -> t.getNome().equals(name))
                .findFirst();
    }

    @Override
    public List<TurmaDAO> findAll() {
        return turmas;
    }

    @Override
    public List<TurmaDAO> findAllByPeriodo(String periodo) {
        return turmas.stream()
                .filter(t -> t.getPeriodo().equalsIgnoreCase(periodo))
                .toList();
    }

    @Override
    public List<TurmaDAO> findAllByCurso(String curso) {
        return turmas.stream()
                .filter(t -> t.getPeriodo().equalsIgnoreCase(curso))
                .toList();
    }

    @Override
    public void deleteById(int turmaId) {
        TurmaDAO turma = turmas.stream()
                .filter(t -> t.getId() == turmaId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + turmaId));

        turmas.remove(turma);
    }

}
