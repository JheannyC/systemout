package com.ufpb.triggerdev.systemoutproject.services;

import com.ufpb.triggerdev.systemoutproject.domain.Usuario;
import com.ufpb.triggerdev.systemoutproject.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscar(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }
}
