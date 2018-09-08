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
public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, Agencia agencia_conta) {
        super(agencia_conta,numero);
    }

    //Polimorfismo de Sobrecarga
    public ContaCorrente(int numero, Agencia agencia_conta, double saldo) {
        super(agencia_conta,numero);
        super.setSaldo(saldo);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        try {
            super.sacar(valor);
        } catch (SaldoInsuficienteException e) {

        }
    }

}
