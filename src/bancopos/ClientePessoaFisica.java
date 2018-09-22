package bancopos;

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Extende a classe abstrata Cliente
*/
public class ClientePessoaFisica extends Cliente {

    private String cpf;

    private String nome;

    public ClientePessoaFisica(String cpf, String nome, int id, String endereco, String email, String telefone) {
        /*
            Implementação do Requisito 6.2 - Pelo menos um acoplamento dinâmico (acesso a método da superclasse)
            Método da classe Cliente
        */
        super(id, endereco, TipoPessoa.FISICA, email, telefone);
        this.cpf = cpf;
        this.nome = nome;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
