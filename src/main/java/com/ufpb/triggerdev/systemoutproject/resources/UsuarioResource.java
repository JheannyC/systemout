package com.ufpb.triggerdev.systemoutproject.resources;

import com.ufpb.triggerdev.systemoutproject.domain.Usuario;
import com.ufpb.triggerdev.systemoutproject.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping (method = RequestMethod.GET)
   public String listar() {
        return  "Teste";
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.buscar(id);
        return ResponseEntity.ok().body(usuario);
    }


}
