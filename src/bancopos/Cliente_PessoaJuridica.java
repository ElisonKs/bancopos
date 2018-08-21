package bancopos;




public class Cliente_PessoaJuridica extends Cliente {

	private int cnpj;

	private char razao_social;

	private char nome_fantasia;

    public Cliente_PessoaJuridica(int cnpj, char razao_social, char nome_fantasia, int id, char endereco, char email, char telefone) {
        super(id, endereco, email, telefone);
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
    }
        
        

}
