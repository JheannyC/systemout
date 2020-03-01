package com.ufpb.triggerdev.systemoutproject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ufpb.triggerdev.systemoutproject.enums.TipoUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    private Integer tipoUsuario;

    //Mapeamento entre cursos e usuarios
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    //Mapeamento entre usuarios e disciplinas
    @JsonBackReference
    @ManyToMany (mappedBy = "usuarios")
    private List <Disciplina> disciplinas = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, TipoUsuario tipoUsuario, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario.getCod();
        this.curso = curso;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return TipoUsuario.toEnum(tipoUsuario);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario.getCod();
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
