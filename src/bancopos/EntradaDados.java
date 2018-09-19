package bancopos;

import javax.swing.JOptionPane;

public class EntradaDados implements EntradaDadosInterface {

    private String entrada;

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
