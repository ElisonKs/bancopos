package bancopos;

/*
    Implementação do Requisito 7.4 - Polimorfismo Paramétrico
    A classe Fundo é uma classe com objeto genérico
*/
public class Fundo<G> {

    private int matricula;
    private double saldo;
    G objeto;

    public Fundo(G objeto) {
        this.objeto = objeto;
    }

}
