package com.ufpb.triggerdev.systemoutproject.services;

import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import com.ufpb.triggerdev.systemoutproject.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void cadastroCurso(Curso curso) {
        cursoRepository.saveAndFlush(curso);
    }

    public Optional<Curso> buscarCursos(Integer id) {
        Optional<Curso> usuario = cursoRepository.findById(id);
        return usuario;
    }
}
