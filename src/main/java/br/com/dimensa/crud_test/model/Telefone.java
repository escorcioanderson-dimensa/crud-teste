package br.com.dimensa.crud_test.model;

import lombok.Data;

@Data
public class Telefone {
    private TipoTelefone tipo;
    private String ddd;
    private String numero;

    public void inserirTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }
    public void inserirDdd(String ddd) {
        this.ddd = ddd;
    }
    public void inserirNumero(String numero) {
        this.numero = numero;
    }
}
