package br.com.dimensa.crud_test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Cidade {
    private String nome;
    private List<Bairro> bairros;
    private Estado estado;

    public Cidade() {
        this.bairros = new ArrayList<>();
    }

}
