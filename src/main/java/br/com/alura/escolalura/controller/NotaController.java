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
@RequestMapping("nota")
public class NotaController {

    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping("/cadastrar/{id}")
    public String cadastrar(@PathVariable String id, Model model){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();

            model.addAttribute("aluno", aluno);
            model.addAttribute("nota", 0.0);

            return "nota/cadastrar";
        }
        return "redirect:/";
    }

    @GetMapping("/pesquisar")
    public String pesquisarPor(@RequestParam("classificacao") String classificacao,
                               @RequestParam("notacorte") String notaCorte, Model model){



        return "nota/pesquisar";
    }

    @GetMapping("/iniciarpesquisa")
    public String iniciarPesquisa(){

        List<Aluno> alunos = alunoRepository.buscarAprovados(7.0);

        return "nota/pesquisar";
    }

    @PostMapping("/salvar/{id}")
    public String salvar(@PathVariable String id, @ModelAttribute Nota nota){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            aluno.addNota(nota);

            alunoRepository.save(aluno);

            return "redirect:/aluno/listar";
        }
        return "redirect:/";
    }
}
