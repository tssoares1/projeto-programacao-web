package com.first_api_project.mappers;

import com.first_api_project.business.models.TurmaBO;
import com.first_api_project.persistence.daos.TurmaDAO;
import com.first_api_project.presentation.models.TurmaDTO;

public class TurmaMapper {
    // ===== DTO <-> BO =====
    public static TurmaBO toBO(TurmaDTO dto) {
        if (dto == null) return null;
        TurmaBO bo = new TurmaBO();
        bo.setId(dto.getId());
        bo.setNome(dto.getNome());
        bo.setCurso(dto.getCurso());
        bo.setPeriodo(dto.getPeriodo());
        return bo;
    }

    public static TurmaDTO toDTO(TurmaBO bo) {
        if (bo == null) return null;
        TurmaDTO dto = new TurmaDTO();
        dto.setId(bo.getId());
        dto.setNome(bo.getNome());
        dto.setCurso(bo.getCurso());
        dto.setPeriodo(bo.getPeriodo());
        return dto;
    }

    // ===== BO <-> DAO =====
    public static TurmaDAO toDAO(TurmaBO bo) {
        if (bo == null) return null;
        TurmaDAO dao = new TurmaDAO();
        dao.setId(bo.getId());
        dao.setNome(bo.getNome());
        dao.setCurso(bo.getCurso());
        dao.setPeriodo(bo.getPeriodo());
        return dao;
    }

    public static TurmaBO toBO(TurmaDAO dao) {
        if (dao == null) return null;
        TurmaBO bo = new TurmaBO();
        bo.setId(dao.getId());
        bo.setNome(dao.getNome());
        bo.setCurso(dao.getCurso());
        bo.setPeriodo(dao.getPeriodo());
        return bo;
    }
}
