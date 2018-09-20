
package bancopos;

import java.util.Date;


/**
 *
 * @author Elison
 */
public class Transacao {
    
    private int numeroContaOrigem;
    private int numeroContaDestino;
    private double valorTransacao;
    private TipoTransacao tipoTransacao;
    private Date dataTransacao;

    public Transacao(int numeroContaOrigem, int numeroContaDestino, double valorTransacao, TipoTransacao tipoTransacao, Date dataTransacao) {
        this.numeroContaOrigem = numeroContaOrigem;
        this.numeroContaDestino = numeroContaDestino;
        this.valorTransacao = valorTransacao;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
    }

     public Transacao(int numeroContaOrigem,  double valorTransacao, TipoTransacao tipoTransacao, Date dataTransacao) {
        this.numeroContaOrigem = numeroContaOrigem;
        this.valorTransacao = valorTransacao;
        this.tipoTransacao = tipoTransacao;
        this.dataTransacao = dataTransacao;
    }
    
    public int getNumeroContaOrigem() {
        return numeroContaOrigem;
    }

    public void setNumeroContaOrigem(int numeroContaOrigem) {
        this.numeroContaOrigem = numeroContaOrigem;
    }

    public int getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(int numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    
    public void imprimir()
    {
        System.out.println("Data:" + getDataTransacao());
        System.out.println("Conta Origem:" + getNumeroContaOrigem());
        System.out.println("Conta Destino:" + getNumeroContaDestino());
        System.out.println("Tipo:" + getTipoTransacao().toString());
        System.out.println("Valor:" + getValorTransacao());
                           
    }
    
}
