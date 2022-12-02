package br.com.alura.escolalura.controller;

import br.com.alura.escolalura.model.Aluno;
import br.com.alura.escolalura.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("aluno", new Aluno());

        return "aluno/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno){
        alunoRepository.save(aluno);

        return "redirect:/";
    }

    @GetMapping("/listar")
    public String Listar(Model model){
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);

        return "aluno/listar";
    }

    @GetMapping("/visualizar/{id}")
    public String visualizar(@PathVariable String id, Model model){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if(optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();

            model.addAttribute("aluno", aluno);

            return "aluno/visualizar";
        }
        return "aluno/listar";
    }

    @GetMapping("/pesquisarnome")
    public String pesquisarNome(){
        return "aluno/pesquisarnome";
    }

    @GetMapping("/pesquisar")
    public String perquisar(@RequestParam("nome") String nome, Model model){
        List<Aluno> alunos = alunoRepository.findByNome(nome);

        model.addAttribute("alunos", alunos);

        return "aluno/pesquisarnome";
    }
}
