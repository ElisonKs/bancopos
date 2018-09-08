package bancopos;


public class RendaFixa extends Investimento {
    
    private final double rendFixo = 0.008;
    

    public RendaFixa(double valorInvestido){
        setRendimento(rendFixo); 
        setSaldo(valorInvestido);

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
    
    @Override
    public void render(){
        //this.saldo += (this.saldo * this.rendimento);
        setSaldo(getSaldo()+(getSaldo()*getRendimento()));
    }
    
}
