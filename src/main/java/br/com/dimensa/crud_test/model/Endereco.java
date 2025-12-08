package br.com.dimensa.crud_test.model;

import java.util.List;
import lombok.Data;

@Data
public class Endereco {
    private String numero;
    private String cep;
    private String complemento;
    private  Bairro bairro;
    private  Logradouro logradouro;
}
