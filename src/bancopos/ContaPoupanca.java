package bancopos;

public class ContaPoupanca extends Conta {

    private final double taxaTransferencia = 1.50;

    public ContaPoupanca(int numero, Agencia agenciaConta) {
        super(agenciaConta, numero);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > 1000) {
            System.out.println("Limite de saque excedido para este tipo de conta.");
        } else {
            super.sacar(valor + super.taxaPoupanca);
        }
    }

    @Override
    public void transferir(double valor) {
        if (this.consultarSaldo() >= valor + this.taxaTransferencia) {
            setSaldo(this.consultarSaldo() - valor - this.taxaTransferencia);

        } else {
            System.out.println("Saldo insuficiente para realizar esta operação!");
        }
    }
}
