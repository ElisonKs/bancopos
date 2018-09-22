package bancopos;


/*
    Implementação do Requisito 11 - Uma exceção deve ser criada, levantada e tratada pelo programa
    Exceção criada para o caso da conta não ter saldo suficiente para um saque.
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
