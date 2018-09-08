package bancopos;

public abstract class Investimento {
    
    private double rendimento;
    private double saldo;
    
    
    public void render (){
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