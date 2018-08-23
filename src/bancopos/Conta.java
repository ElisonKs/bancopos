package bancopos;

public abstract class Conta {

	private Cliente cliente_conta;

	private Agencia agencia_conta;

    public Conta(Cliente cliente_conta, Agencia agencia_conta) {
        this.cliente_conta = cliente_conta;
        this.agencia_conta = agencia_conta;
    }

    public Cliente getCliente_conta() {
        return cliente_conta;
    }

    public void setCliente_conta(Cliente cliente_conta) {
        this.cliente_conta = cliente_conta;
    }

    public Agencia getAgencia_conta() {
        return agencia_conta;
    }

    public void setAgencia_conta(Agencia agencia_conta) {
        this.agencia_conta = agencia_conta;
    }
    
    
        
        

}
