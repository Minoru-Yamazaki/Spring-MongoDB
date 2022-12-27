package br.com.alura.escolalura.controller;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.model.Nota;
import br.com.alura.escolalura.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("geolocalizacao")
public class GeolocalizacaoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/iniciarpesquisa")
    public String iniciarPesquisa(Model model){
        List<Aluno> alunos = alunoRepository.findAll();

        model.addAttribute("alunos", alunos);

        return "geolocalizacao/pesquisar";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(@RequestParam("alunoId") String alunoId, Model model){
        Aluno aluno;
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);
        if(optionalAluno.isPresent()) aluno = optionalAluno.get();

        List<Aluno> alunosProximos = alunoRepository.pesquisarPorGeolocalizacao(aluno);

        model.addAttribute("alunosProximos", alunosProximos);

        return "geolocalizacao/pesquisar";
    }
}
