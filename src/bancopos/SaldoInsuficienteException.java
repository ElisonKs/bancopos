package bancopos;

public class SaldoInsuficienteException extends Exception {

    @Override
    public String getMessage() {
        return "Limite de saque excedido para este tipo de conta.";
    }

    public SaldoInsuficienteException() {

    }

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
