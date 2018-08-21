package bancopos;

public abstract class Cliente {

	private int id;

	private char endereco;
        
        
        private char email;

	private char telefone;

    public Cliente(int id, char endereco, char email, char telefone) {
        this.id = id;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

	

}
