package bancopos;

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Classe investimento serve de base para as classes RendaFixa e RendaVariável
*/
public abstract class Investimento {

    private double rendimento;
    private double saldo;

    public void render() {
        this.saldo += (this.saldo * this.rendimento);
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
