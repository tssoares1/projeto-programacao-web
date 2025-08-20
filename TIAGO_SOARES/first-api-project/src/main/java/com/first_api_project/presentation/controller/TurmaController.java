package com.first_api_project.presentation.controller;

import com.first_api_project.business.models.TurmaBO;
import com.first_api_project.business.services.TurmaService;
import com.first_api_project.mappers.TurmaMapper;
import com.first_api_project.presentation.models.TurmaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController implements TurmaController_interface {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public TurmaDTO cadastrarTurma(@RequestBody TurmaDTO turma) {
        TurmaBO turmaBO = TurmaMapper.toBO(turma);
        TurmaBO turmaSaved = turmaService.cadastrarTurma(turmaBO);
        return TurmaMapper.toDTO(turmaSaved);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TurmaDTO> listarTurmas() {
        List<TurmaBO> turmasBo = turmaService.findAll();

        List<TurmaDTO> turmasDto = new ArrayList<>();
        for (TurmaBO bo : turmasBo) {
            turmasDto.add(TurmaMapper.toDTO(bo));
        }

        return turmasDto;
    }

    @GetMapping("/id/{turmaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public TurmaDTO buscarTurma(@PathVariable int turmaId) {
        TurmaBO turmaFind = turmaService.findById(turmaId);
        return TurmaMapper.toDTO(turmaFind);
    }

    @GetMapping("/periodo/{turmaPeriodo}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TurmaDTO> buscarTumasPorPeriodo(@PathVariable String periodo) {
        List<TurmaBO> turmasFind = turmaService.findByPeriodo(periodo);

        return turmasFind.stream()
                .map(TurmaMapper::toDTO)
                .toList();
    }

    @GetMapping("/curso/{turmaCurso}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TurmaDTO> buscarTumasPorCurso(@PathVariable String curso) {
        List<TurmaBO> turmasFind = turmaService.findByCurso(curso);

        return turmasFind.stream()
                .map(TurmaMapper::toDTO)
                .toList();
    }


    @DeleteMapping("/id/{turmaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTurma(@PathVariable int turmaId) {
        turmaService.deleteById(turmaId);
    }
}
