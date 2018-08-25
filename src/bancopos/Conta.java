package bancopos;

public class Conta implements ContaCorrente,ContaPoupanca {

	

	private Agencia agencia_conta;
        
        private double saldo;

    public Conta(Cliente cliente_conta, Agencia agencia_conta) {
     
        this.agencia_conta = agencia_conta;
    }

   

   

    @Override
    public Agencia getAgencia_conta() {
        return agencia_conta;
    }

    @Override
    public void setAgencia_conta(Agencia agencia_conta) {
        this.agencia_conta = agencia_conta;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Cliente getCliente_conta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCliente_conta(Cliente cliente_conta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
        
        

}
