package bancopos;

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Extende a classe abstrata Cliente
*/
public class ClientePessoaJuridica extends Cliente {

    private int cnpj;

    private String razao_social;

    private String nome_fantasia;

    public ClientePessoaJuridica(int cnpj, String razao_social, String nome_fantasia, int id, String endereco, TipoPessoa tipo, String email, String telefone) {
        super(id, endereco, tipo, email, telefone);
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        super.setTipo(TipoPessoa.JURIDICA);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

}
