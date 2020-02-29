package com.ufpb.triggerdev.systemoutproject;

import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import com.ufpb.triggerdev.systemoutproject.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SystemoutprojectApplication implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SystemoutprojectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
            Curso curso1 = new Curso (null, "Sistemas de Informação");
            Curso curso2 = new Curso (null, "Ciências da Computação");

            cursoRepository.saveAll(Arrays.asList(curso1,curso2));
    }
}
