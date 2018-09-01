package bancopos;

public class Conta implements CreditoInterface, DebitoInterface {

    protected final double taxPoupanca = 1.00;
    private Agencia agencia_conta;

    private double saldo;

    public Conta(Cliente cliente_conta, Agencia agencia_conta) {
        this.agencia_conta = agencia_conta;
        this.saldo = 0.0;
    }

    public Agencia getAgencia_conta() {
        return agencia_conta;
    }

    public void setAgencia_conta(Agencia agencia_conta) {
        this.agencia_conta = agencia_conta;
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

}
