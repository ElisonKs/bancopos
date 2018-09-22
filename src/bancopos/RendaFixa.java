package bancopos;

/*
    Implementação do Requisito 10 - Classes abstratas. Pelo menos duas. 
    Certamente que as concretas também devem ser implementadas.
    Extende a classe abstrata Investimento
*/
public class RendaFixa extends Investimento {

    private final double rendFixo = 0.008;

    public RendaFixa(double valorInvestido) {
        setRendimento(rendFixo);
        setSaldo(valorInvestido);
    }

    @Override
    public void render() {
        setSaldo(getSaldo() + (getSaldo() * getRendimento()));
    }

    public double getRendFixo() {
        return rendFixo;
    }
    

}
