package bancopos;

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
