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
        cursoRepository.saveAll(Arrays.asList(c1,c2));

        Disciplina d1 = new Disciplina(null,"Projeto Avançado");
        Disciplina d2 = new Disciplina(null, "Banco de dados");
        Disciplina d3 = new Disciplina(null, "Estrutura de Dados II");

        disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));

        c1.getDisciplinas().addAll(Arrays.asList(d1, d2, d3));
        c2.getDisciplinas().addAll(Arrays.asList(d1, d2));

        d1.getCursos().addAll(Arrays.asList(c1, c2));
        d2.getCursos().addAll(Arrays.asList(c1, c2));
        d3.getCursos().addAll(Arrays.asList(c2));

        cursoRepository.saveAll(Arrays.asList(c1,c2));
        disciplinaRepository.saveAll(Arrays.asList(d1,d2,d3));


        Usuario u1 = new Usuario(null, "iusdhfija", "jadfhsk@dcx", TipoUsuario.ESTUDANTE,c1);

        Usuario u2 = new Usuario(null, "fddfas", "fedsarnfsadanda@dcx", TipoUsuario.ESTUDANTE,c1);


        //disciplinaRepository.saveAll(Arrays.asList(d1,d2));
     usuarioRepository.saveAll(Arrays.asList(u1,u2));

    }
}
