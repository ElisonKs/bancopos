package bancopos;

public class ContaPoupanca extends Conta {
    
    /*
        Implementação do Requisito 1.5 - Deve haver alguma constante declarada e usada
        Constante implementada para guardar o valor fixo descontado das operações numa conta de Poupança
    */
    private final double taxaTransferencia = 1.50;

    public ContaPoupanca(int numero, Agencia agenciaConta) {
        super(agenciaConta, numero);
    }
    
    /*
        Implementação do Requisito 6.1
        É descontado além do valor do saque a taxa cobrada para sacar de uma poupança, definida na superclasse
    */
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException{
        if (valor > 1000) {
            System.out.println("Limite de saque excedido para este tipo de conta.");
        } else {
            super.sacar(valor + super.taxaPoupanca);
        }
    }
    
    /*
        Implementação do Requisito 7.3 - Polimorfismo de Subtipagem
        Reescreve o método sacar da superclasse Conta
    */
    @Override
    public void transferir(double valor) {
        if (this.consultarSaldo() >= valor + this.taxaTransferencia) {
            setSaldo(this.consultarSaldo() - valor - this.taxaTransferencia);

        } else {
            System.out.println("Saldo insuficiente para realizar esta operação!");
        }
    }
}
