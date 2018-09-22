package bancopos;

/*
    Implementação do Requisito 8 - Pelo menos três classes do sistema 
    devem implementar uma interface. Uma destas classes deve implementar, pelo menos, duas interfaces
    Essa classe define uma interface de operações de débito
*/
public interface DebitoInterface {

    public void sacar(double valor) throws SaldoInsuficienteException;

    public void transferir(double valor);

}
