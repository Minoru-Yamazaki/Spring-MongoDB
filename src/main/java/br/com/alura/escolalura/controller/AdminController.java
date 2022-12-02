package br.com.alura.escolalura.controller;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.repository.AlunoRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/")
    public String index(){
        List<Aluno> alunos = alunoRepository.findByNome("Felipe");

        alunos.forEach(a -> System.out.println(a.toString()));

        return "index";
    }
}
