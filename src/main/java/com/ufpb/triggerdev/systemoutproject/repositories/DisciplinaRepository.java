package com.ufpb.triggerdev.systemoutproject.repositories;

import com.ufpb.triggerdev.systemoutproject.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
