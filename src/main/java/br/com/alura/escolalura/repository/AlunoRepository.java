package br.com.alura.escolalura.repository;

import br.com.alura.escolalura.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
    List<Aluno> findByNome(String nome);
    @Query("{'notas': {$gte : {'valor': ?0}}}")
    List<Aluno> buscarAprovados(double notaCorte);
    @Query("{'notas': {$lt : {'valor': ?0}}}")
    List<Aluno> buscarReprovados(double notaCorte);

    List<Aluno> pesquisarPorGeolocalizacao(Aluno aluno); // Precisa criar lógica para retornar alunos próximos
}
