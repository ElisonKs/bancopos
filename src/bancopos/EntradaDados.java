/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

import javax.swing.JOptionPane;

/**
 *
 * @author Elison
 */
public class EntradaDados implements EntradaDadosInterface {
    
    private String entrada;
    
    @Override
    public void abrirEntrada(String campo_requerido)
    {
        this.entrada = JOptionPane.showInputDialog("Entre com " + campo_requerido);
        
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
}
