package bancopos;

import java.util.ArrayList;

public abstract class Cliente {

    private int id;

    private String endereco;

    private String email;

    private String telefone;

    ArrayList<Conta> contasCliente;
    // Enum
    private TipoPessoa tipo;

    public Cliente(int id, String endereco, TipoPessoa tipo, String email, String telefone) {
        this.id = id;
        this.tipo = tipo;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.contasCliente = new ArrayList();
    }

    public void adicionarConta(Conta novaConta) {
        this.contasCliente.add(novaConta);
    }

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
