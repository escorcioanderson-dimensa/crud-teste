package br.com.dimensa.crud_test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Pais {
    private String nome;
    private List<Estado> estados;

    public Pais() {
        this.estados = new ArrayList<>();
    }

}
