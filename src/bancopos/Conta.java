package bancopos;




public abstract class Conta {

	private Cliente cliente_conta;

	private Agencia agencia_conta;

    public Conta(Cliente cliente_conta, Agencia agencia_conta) {
        this.cliente_conta = cliente_conta;
        this.agencia_conta = agencia_conta;
    }
        
        

}
