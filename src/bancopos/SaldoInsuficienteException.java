package bancopos;


/*
    Exceção criada para o caso da conta não ser saldo suficiente para um saque.
*/
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
