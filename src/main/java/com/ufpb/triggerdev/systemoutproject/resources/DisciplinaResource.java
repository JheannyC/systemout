package com.ufpb.triggerdev.systemoutproject.resources;

import com.ufpb.triggerdev.systemoutproject.domain.Disciplina;
import com.ufpb.triggerdev.systemoutproject.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id) {
        Optional<Disciplina> disciplina = Optional.ofNullable(disciplinaService.find(id));
        return ResponseEntity.ok().body(disciplina);
    }

}
