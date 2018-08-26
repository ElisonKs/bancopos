package bancopos;

public class Cliente_PessoaFisica extends Cliente {

	private String cpf;

	private String nome;

    public Cliente_PessoaFisica(String cpf, String nome, int id, String endereco,  String email, String telefone) {
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
