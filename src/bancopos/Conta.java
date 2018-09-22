package bancopos;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
    Implementação do Requisito 8 - Pelo menos três classes do sistema 
    devem implementar uma interface. Uma destas classes deve implementar, pelo menos, duas interfaces
    Essa classe implementa duas interfaces, uma de operações de crédito e outra de operações de débito
*/
public class Conta implements CreditoInterface, DebitoInterface {
    /*
        Implementação do Requisito 6.1 - Deve declarar algum atributo final em alguma Superclasse
        Atributo é usado na Classe filha ContaPoupança;
    */
    protected final double taxaPoupanca = 1.00;
    /*
        Implementação do Requisito 5 - Associação por agregação
        Agencia pode existir sem necessariamente ter uma Conta
    */
    private Agencia agenciaConta;
    private int numero;

    private double saldo;
    
    /*
        Implementação do requisito 3 - Pelo menos duas classes do projeto devem 
        possuir um construtor declarado
        Construtor implementado para inicializar atributos da classe Cliente
    */
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
    
    /*
        Implementação do requisito 11 - Uma exceção deve ser criada, levantada e tratada pelo programa
        Lança exceção SaldoInsuficienteException no caso do valor ser maior que o saldo
    */
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (this.consultarSaldo() >= valor) {
            setSaldo(this.consultarSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
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
