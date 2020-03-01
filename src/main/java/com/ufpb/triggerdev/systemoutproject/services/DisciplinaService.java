package com.ufpb.triggerdev.systemoutproject.services;

import com.ufpb.triggerdev.systemoutproject.domain.Disciplina;
import com.ufpb.triggerdev.systemoutproject.repositories.DisciplinaRepository;
import com.ufpb.triggerdev.systemoutproject.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void cadastroDisciplina (Disciplina disciplina) {
        disciplinaRepository.saveAndFlush(disciplina);
    }

    public Disciplina find (Integer id) {
        Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
        return disciplina.orElseThrow (() -> new ObjectNotFoundException("Not found: "+ id));
    }
}
