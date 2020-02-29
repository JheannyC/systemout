package com.ufpb.triggerdev.systemoutproject.repositories;

import com.ufpb.triggerdev.systemoutproject.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
