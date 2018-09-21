package bancopos;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Agencia agenciaConta) {
        super(agenciaConta,numero);
    }

    //Polimorfismo de Sobrecarga
    public ContaCorrente(int numero, Agencia agenciaConta, double saldo) {
        super(agenciaConta,numero);
        super.setSaldo(saldo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        
        super.sacar(valor);

        
    }

}
