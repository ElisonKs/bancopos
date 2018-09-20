package bancopos;

public interface NegocioInterface {

    Agencia getAgencia_conta();

    Cliente getCliente_conta();

    double getSaldo();

    void setAgencia_conta(Agencia agencia_conta);

    void setCliente_conta(Cliente cliente_conta);

    void setSaldo(double saldo);

}
