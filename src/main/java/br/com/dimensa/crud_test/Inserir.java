package br.com.dimensa.crud_test;

import br.com.dimensa.crud_test.model.Bairro;
import br.com.dimensa.crud_test.model.Cidade;
import br.com.dimensa.crud_test.model.Endereco;
import br.com.dimensa.crud_test.model.Estado;
import br.com.dimensa.crud_test.model.Logradouro;
import br.com.dimensa.crud_test.model.Pais;
import br.com.dimensa.crud_test.model.Pessoa;
import br.com.dimensa.crud_test.model.Telefone;
import br.com.dimensa.crud_test.model.TipoTelefone;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

public class Inserir {
    public static void main(String[] args) {
        Inserir inserir = new Inserir();
        inserir.listarPessoas();
    }
    public void listarPessoas() {
        final List<Pessoa> pessoas = this.carregaDadosPessoa();
        for (Pessoa pessoa : pessoas) {
            System.out.println("Pessoa: " + pessoa.getNome());
            for (Endereco endereco : pessoa.getEnderecos()) {
                System.out.println("  Endereco: " + endereco.getLogradouro().getNome() + ", " +
                        endereco.getNumero() + ", " +
                        endereco.getCep() + ", " +
                        endereco.getBairro().getNome() + ", " +
                        endereco.getBairro().getCidade().getNome() + ", " +
                        endereco.getBairro().getCidade().getEstado().getNome() + ", " +
                        endereco.getBairro().getCidade().getEstado().getPais().getNome() + ".");
            }
            for (Telefone telefone : pessoa.getTelefones()) {
                System.out.println("  Telefone: (" + telefone.getTipo().name() + ") " + telefone.getNumero());
            }
        }
    }

    private List<Pessoa> carregaDadosPessoa() {
        Pais pais = new Pais();
        pais.setNome("Brasil");
        Estado estado = new Estado();
        estado.setNome("SP");
        estado.setPais(pais);
        Cidade cidade = new Cidade();
        cidade.setNome("São Paulo");
        cidade.setEstado(estado);
        estado.getCidades().add(cidade);
        Bairro bairro = new Bairro();
        bairro.setNome("Centro");
        bairro.setCidade(cidade);
        Bairro bairro2 = new Bairro();
        bairro2.setNome("Mooca");
        bairro2.setCidade(cidade);
        Telefone telefone = new Telefone();
        telefone.setNumero("(11) 99999-9999");
        telefone.setTipo(TipoTelefone.CELULAR);


        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Anderson");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataNascimento(LocalDate.parse("13/03/1982", formatter));
        Logradouro logradouro = new Logradouro();
        logradouro.setNome("Rua juventos");
        Logradouro logradouro2 = new Logradouro();
        logradouro2.setNome("Rua 15 de novembro");

        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero("93");
        endereco.setBairro(bairro2);
        endereco.setCep("01000-000");

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(logradouro2);
        endereco2.setNumero("513");
        endereco2.setBairro(bairro);
        endereco2.setCep("01000-150");
        //Adiciona endereços e telefones na pessoa
        pessoa.getEnderecos().add(endereco);
        pessoa.getEnderecos().add(endereco2);
        pessoa.getTelefones().add(telefone);

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa);
        return pessoas;
    }


}
