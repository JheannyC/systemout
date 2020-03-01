package com.ufpb.triggerdev.systemoutproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeDisciplina;

    //Mapeamento entre cursos e disciplinas - nova tabela
    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name="DISCIPLINA_CURSO",
            joinColumns=
            @JoinColumn(name="disciplina_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="curso_id", referencedColumnName="Id")
    )
    private List <Curso> cursos = new ArrayList<>();


    //Mapeamento entre usuarios e disciplinas - nova tabela
    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name="DISCIPLINA_USUARIO",
            joinColumns=
            @JoinColumn(name="disciplina_id", referencedColumnName="Id"),
            inverseJoinColumns=
            @JoinColumn(name="usuario_id", referencedColumnName="Id")
    )
    private List <Usuario> usuarios = new ArrayList<>();


    public Disciplina() {
    }

    public Disciplina(Integer id, String nomeDisciplina) {
        this.id = id;
        this.nomeDisciplina = nomeDisciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
