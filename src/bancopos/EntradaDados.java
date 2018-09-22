package bancopos;

import javax.swing.JOptionPane;

/*
    Implementação do Requisito 8 - Pelo menos três classes do sistema 
    devem implementar uma interface. Uma destas classes deve implementar, pelo menos, duas interfaces
    Essa classe implementa uma interface de operações de entrada
*/
public class EntradaDados implements EntradaDadosInterface {

    private String entrada;
    
    /*
        Implementação do Requisito 12 - Deve ter alguma entrada de dados usando Caixas de Diálogo
        Essa classe utiliza uma entrada de dados com um inputDialog
    */
    @Override
    public void abrirEntrada(String campoRequerido) {
        this.entrada = JOptionPane.showInputDialog(null, "Entre com " + campoRequerido);

    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

}
