package bancopos;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Conta implements CreditoInterface, DebitoInterface {

    protected final double taxaPoupanca = 1.00;
    private Agencia agenciaConta;
    private int numero;

    private double saldo;

    public Conta(Agencia agenciaConta, int numero) {
        this.numero = numero;
        this.agenciaConta = agenciaConta;
        this.saldo = 0.0;

    }

    public Agencia getAgenciaConta() {
        return agenciaConta;
    }

    public void setAgenciaConta(Agencia agenciaConta) {
        this.agenciaConta = agenciaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (this.consultarSaldo() >= valor) {
            setSaldo(this.consultarSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    public double consultarSaldo() {
        return this.getSaldo();
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.consultarSaldo() + valor);
        JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
    }

    @Override
    public void transferir(double valor) {
        if (this.consultarSaldo() >= valor) {
            setSaldo(this.consultarSaldo() - valor);
            setSaldo(getSaldo() + valor);
        } else {
            System.out.println("Saldo insuficiente para realizar esta operação!");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
