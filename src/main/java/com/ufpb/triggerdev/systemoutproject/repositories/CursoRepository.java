package com.ufpb.triggerdev.systemoutproject.repositories;

import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
