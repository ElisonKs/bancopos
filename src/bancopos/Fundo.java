package bancopos;

public class Fundo<G> {

    private int matricula;
    private double saldo;
    G objeto;

    public Fundo(G objeto) {
        this.objeto = objeto;
    }

}
