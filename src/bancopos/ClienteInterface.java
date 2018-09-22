package bancopos;

/*
    Implementação do Requisito 8 - Pelo menos três classes do sistema 
    devem implementar uma interface. Uma destas classes deve implementar, pelo menos, duas interfaces
    Essa classe define uma interface de operações da classe Cliente
*/
public interface ClienteInterface {
    
    public void adicionarConta(Conta novaConta);

    public void listarContas();
    
    
}
