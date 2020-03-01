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
        Curso c1 = new Curso (null, "Sistemas de Informação");
        Curso c2 = new Curso (null, "Ciências da Computação");

        Disciplina d1 = new Disciplina(null,"Matemática Elementar");
        Disciplina d2 = new Disciplina(null, "Estrutura de Dados I");
        Disciplina d3 = new Disciplina(null, "Estrutura de Dados II");

        c1.getDisciplinas().addAll(Arrays.asList(d1, d2, d3));
        c2.getDisciplinas().addAll(Arrays.asList(d1, d2));

        d1.getCursos().addAll(Arrays.asList(c1, c2));
        d2.getCursos().addAll(Arrays.asList(c1, c2));
        d3.getCursos().addAll(Arrays.asList(c2));

        Usuario u1 = new Usuario(null, "Samira", "samira@dcx", TipoUsuario.ESTUDANTE,c1);
        Usuario u2 = new Usuario(null, "Fernanda", "fernanda@dcx", TipoUsuario.ESTUDANTE,c1);
        Usuario u3 = new Usuario(null, "Josilene", "josilene@dcx", TipoUsuario.PROFESSOR, c2);

        d1.getUsuarios().addAll(Arrays.asList(u1,u3));
        d2.getUsuarios().addAll(Arrays.asList(u1,u2,u3));
        d3.getUsuarios().addAll(Arrays.asList(u2,u3));

        u1.getDisciplinas().addAll(Arrays.asList(d1,d2));
        u2.getDisciplinas().addAll(Arrays.asList(d2,d3));
        u3.getDisciplinas().addAll(Arrays.asList(d1,d2,d3));


    }
}
