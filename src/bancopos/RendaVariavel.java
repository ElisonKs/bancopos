package bancopos;
import java.lang.Math;

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Extende a classe abstrata Investimento
*/
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