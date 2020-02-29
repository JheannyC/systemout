package com.ufpb.triggerdev.systemoutproject.services;

import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import com.ufpb.triggerdev.systemoutproject.repositories.CursoRepository;
import com.ufpb.triggerdev.systemoutproject.services.exceptions.ObjectNotFoundException;
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

    public Curso find (Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElseThrow (() -> new ObjectNotFoundException("Not found: "+ id));
    }
}
