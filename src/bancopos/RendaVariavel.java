    
package bancopos;
import java.lang.Math;

public class RendaVariavel {
    
    private double rendimento;
    private double saldo;
    
    public RendaVariavel(double valorInvestido)
    {
        this.rendimento = Math.random();
        this.saldo = valorInvestido;
    }
    
    public void render(){
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
