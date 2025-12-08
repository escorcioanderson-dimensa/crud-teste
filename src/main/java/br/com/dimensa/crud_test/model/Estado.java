package br.com.dimensa.crud_test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Estado {
    private String nome;
    private List<Cidade> cidades;
    private Pais pais;

    public Estado(){
        this.cidades = new ArrayList<>();
    }

}
