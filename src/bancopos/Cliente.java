package bancopos;

import java.util.ArrayList;

/*
    Implementação do Requisito 8 - Pelo menos três classes do sistema 
    devem implementar uma interface. Uma destas classes deve implementar, pelo menos, duas interfaces
    Essa classe implementa uma interface de operações de cliente
*/

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Classe asbtrata que serve de base para as classes ClientePessoaFisica e ClientePessoaJuridica
*/
public abstract class Cliente implements ClienteInterface {

    private int id;

    /*
        Requisito 1.2 - Pelo menos um atributo deve ser do tipo String
        Atributo criado para guardar o endereço do Cliente
    */
    private String endereco;

    private String email;

    private String telefone;
    
    /*
        Requisito 4 - Associação por Composição
        ArrayList criado para guardar uma coleção de contas do Cliente
    */
    ArrayList<Conta> contasCliente;
    
    private TipoPessoa tipo;
    
    /*
        Implementação do requisito 3 - Pelo menos duas classes do projeto devem 
        possuir um construtor declarado
        Construtor implementado para inicializar atributos da classe Cliente
    */
    public Cliente(int id, String endereco, TipoPessoa tipo, String email, String telefone) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.contasCliente = new ArrayList();
    }

    @Override
    public void adicionarConta(Conta novaConta) {
        this.contasCliente.add(novaConta);
    }

    @Override
    public void listarContas() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

}
