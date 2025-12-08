package br.com.dimensa.crud_test.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Bairro {
    private String nome;
    private Cidade cidade;

}

