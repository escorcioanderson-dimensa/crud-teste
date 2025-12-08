package br.com.dimensa.crud_test.model;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public Pessoa() {
        this.enderecos = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }
}

