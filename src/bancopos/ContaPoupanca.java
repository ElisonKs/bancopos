/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

/**
 *
 * @author Elison
 */
public class ContaPoupanca extends Conta {

    private final double taxaTransferencia = 1.50;

    public ContaPoupanca(Cliente cliente_conta, Agencia agencia_conta) {
        super(cliente_conta, agencia_conta);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > 1000) {
            System.out.println("Limite de saque excedido para este tipo de conta.");
        } else {
            super.sacar(valor + super.taxPoupanca);
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
