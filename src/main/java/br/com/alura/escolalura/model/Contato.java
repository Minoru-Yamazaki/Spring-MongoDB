package br.com.alura.escolalura.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Contato {

    private String endereco;
    private List<Double> coordinates;
    private String type;
}
