package bancopos;
import java.lang.Math;

public class RendaVariavel extends Investimento {
    
    public RendaVariavel(double valorInvestido)
    {
        setRendimento(Math.random()); 
        setSaldo(valorInvestido);
    }
    
    @Override
    public void render(){
        //saldo += (saldo * rendimento);
        setSaldo(getSaldo()+(getSaldo()*getRendimento()/100));
       
    }
}