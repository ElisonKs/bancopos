package bancopos;

public class Cliente_PessoaFisica extends Cliente {

	private int cpf;

	private int nome;

    public Cliente_PessoaFisica(int cpf, int nome, int id, char endereco, char email, char telefone) {
        super(id, endereco, email, telefone);
        this.cpf = cpf;
        this.nome = nome;
    }
        
        

}
