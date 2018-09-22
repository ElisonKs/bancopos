package bancopos;

public class ContaCorrente extends Conta {
    
    /*
        Implementação do Requisito 7.1 - Polimorfismo por sobrecarga
        Dois métodos construtores, com parâmetros diferentes
    */
    public ContaCorrente(int numero, Agencia agenciaConta) {
        super(agenciaConta,numero);
    }

    
    public ContaCorrente(int numero, Agencia agenciaConta, double saldo) {
        super(agenciaConta,numero);
        super.setSaldo(saldo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        
        super.sacar(valor);

        
    }

}
