package br.com.alura.escolalura.controller;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.model.Habilidade;
import br.com.alura.escolalura.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("habilidade")
public class HabilidadeController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cadastrar/{id}")
    public String cadastrar(@PathVariable String id, Model model){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (!optionalAluno.isEmpty()){
            Aluno aluno = optionalAluno.get();

            model.addAttribute("aluno", aluno);
            model.addAttribute("habilidade", new Habilidade());

            return "habilidade/cadastrar";
        }
        return "redirect:/";
    }

    @PostMapping("salvar/{id}")
    public String salvar(@PathVariable String id, @ModelAttribute Habilidade habilidade){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (!optionalAluno.isEmpty()){
            Aluno aluno = optionalAluno.get();
            aluno.addHabilidade(habilidade);
            alunoRepository.save(aluno);

            return "redirect:/aluno/listar";
        }
        return "redirect:/";
    }
}
