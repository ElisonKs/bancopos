package bancopos;

public class Agencia {

	private int codigo;

	private char endereco;

	private char telefone;

    public Agencia(int codigo, char endereco, char telefone) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.telefone = telefone;
    }

        
        
        
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getEndereco() {
        return endereco;
    }

    public void setEndereco(char endereco) {
        this.endereco = endereco;
    }

    public char getTelefone() {
        return telefone;
    }

    public void setTelefone(char telefone) {
        this.telefone = telefone;
    }

        
}
