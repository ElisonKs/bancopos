package bancopos;

public class Cliente_PessoaFisica extends Cliente {

	private int cpf;

	private String nome;

    public Cliente_PessoaFisica(int cpf, String nome, int id, String endereco, TipoPessoa tipo, String email, String telefone) {
        super(id, endereco, tipo, email, telefone);
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
        
        

}
