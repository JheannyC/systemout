package com.ufpb.triggerdev.systemoutproject;

import com.ufpb.triggerdev.systemoutproject.domain.Curso;
import com.ufpb.triggerdev.systemoutproject.domain.Disciplina;
import com.ufpb.triggerdev.systemoutproject.domain.Usuario;
import com.ufpb.triggerdev.systemoutproject.enums.TipoUsuario;
import com.ufpb.triggerdev.systemoutproject.repositories.CursoRepository;
import com.ufpb.triggerdev.systemoutproject.repositories.DisciplinaRepository;
import com.ufpb.triggerdev.systemoutproject.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SystemoutprojectApplication implements CommandLineRunner {
    //implements CommandLineRunner
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(SystemoutprojectApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso (null, "Sistemas de Informação");
        Curso curso2 = new Curso (null, "Ciências da Computação");

        cursoRepository.saveAll(Arrays.asList(curso1, curso2));

        Disciplina d1 = new Disciplina(null,"Matemática Elementar");
        Disciplina d2 = new Disciplina(null, "Estrutura de Dados I");
        Disciplina d3 = new Disciplina(null, "Estrutura de Dados II");

        curso1.getDisciplinas().addAll(Arrays.asList(d1, d2, d3));
        curso2.getDisciplinas().addAll(Arrays.asList(d1, d2));

       disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));

        d1.getCursos().addAll(Arrays.asList(curso1, curso2));
        d2.getCursos().addAll(Arrays.asList(curso1, curso2));
        d3.getCursos().addAll(Arrays.asList(curso2));

        Usuario u1 = new Usuario(null, "Jeane", "jeane@dcx", TipoUsuario.ESTUDANTE,curso1);
        Usuario u2 = new Usuario(null, "Maria", "maria@dcx", TipoUsuario.ESTUDANTE,curso1);
        Usuario u3 = new Usuario(null, "Joaquina", "joaquina@dcx", TipoUsuario.PROFESSOR, curso2);

        curso1.getUsuario().addAll(Arrays.asList(u1,u2));
        curso2.getUsuario().addAll(Arrays.asList(u3));


        usuarioRepository.saveAll(Arrays.asList(u1,u2,u3));
        cursoRepository.saveAll(Arrays.asList(curso1,curso2));




    }
}
