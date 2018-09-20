package bancopos;

public interface DebitoInterface {

    public void sacar(double valor) throws SaldoInsuficienteException;

    public void transferir(double valor);

}
