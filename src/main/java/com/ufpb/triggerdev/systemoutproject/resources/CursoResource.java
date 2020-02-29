package com.ufpb.triggerdev.systemoutproject.resources;


import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import com.ufpb.triggerdev.systemoutproject.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id) {
        Optional<Curso> cursos = Optional.ofNullable(cursoService.find(id));
        return ResponseEntity.ok().body(cursos);
    }

}
