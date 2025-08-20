package com.first_api_project.business.services;

import com.first_api_project.business.models.TurmaBO;
import com.first_api_project.mappers.TurmaMapper;
import com.first_api_project.persistence.daos.TurmaDAO;
import com.first_api_project.persistence.repositories.TurmaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TurmaService implements TurmaService_interface {
    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaBO cadastrarTurma(TurmaBO turma) {
        var turmaWithSameName = this.turmaRepository.findByName(turma.getNome());
        var turmaWithId = this.turmaRepository.findById(turma.getId());

        if(turmaWithSameName.isPresent() || turmaWithId.isPresent()) {
            throw new Error("Turma já cadastrada");
        }

        TurmaDAO turmaDao = TurmaMapper.toDAO(turma);
        TurmaDAO turmaPersistent = turmaRepository.save(turmaDao);

        return TurmaMapper.toBO(turmaPersistent);
    }

    public TurmaBO findById(int turmaId) {
        TurmaDAO turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada com ID: " + turmaId));

        return TurmaMapper.toBO(turma);
    }

    @Override
    public List<TurmaBO> findAll() {
        List<TurmaDAO> turmasDao = turmaRepository.findAll();

        if (turmasDao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma turma encontrada");
        }

        return turmasDao.stream()
                .map(TurmaMapper::toBO)
                .toList();
    }

    @Override
    public List<TurmaBO> findByPeriodo(String periodo) {
        List<TurmaBO> turmas = turmaRepository.findAllByPeriodo(periodo).stream()
                .map(TurmaMapper::toBO)
                .toList();

        if (turmas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma turma encontrada para o período: " + periodo);
        }

        return turmas;
    }

    @Override
    public List<TurmaBO> findByCurso(String curso) {
        List<TurmaBO> turmas = turmaRepository.findAllByCurso(curso).stream()
                .map(TurmaMapper::toBO)
                .toList();

        if (turmas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma turma encontrada para o curso: " + curso);
        }

        return turmas;
    }

    @Override
    public void deleteById(int turmaId) {
        turmaRepository.deleteById(turmaId);
    }


}
