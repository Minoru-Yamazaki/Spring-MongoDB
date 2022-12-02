package br.com.alura.escolalura.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;
    private String nome;
    private Date dataNascimento;
    private Curso curso;
    private List<Nota> notas;
    private List<Habilidade> habilidades;
    private Contato contato;

    public void addHabilidade(Habilidade habilidade){
        if (habilidades == null) habilidades = new ArrayList<>();
        habilidades.add(habilidade);
    }

    public void addNota(Nota nota) {
        if (notas == null) notas = new ArrayList<>();
        notas.add(nota);
    }
}
