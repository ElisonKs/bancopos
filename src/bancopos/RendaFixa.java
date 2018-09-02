package bancopos;


public class RendaFixa {
    
    private final double rendimento = 0.008;
    
    private double saldo;
    
    public RendaFixa(double valorInvestido){
        this.saldo = valorInvestido;
    }
    
    public void render(){
        this.saldo += (this.saldo * this.rendimento);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
