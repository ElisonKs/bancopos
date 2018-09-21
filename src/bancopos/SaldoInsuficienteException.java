package bancopos;

public class SaldoInsuficienteException extends Exception {

    @Override
    public String getMessage() {
        return "Saldo Insuficiente!";
    }

    public SaldoInsuficienteException() {

    }

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
