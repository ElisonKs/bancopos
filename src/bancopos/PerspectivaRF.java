package bancopos;

import javax.swing.JOptionPane;

public class PerspectivaRF {
    
    /*
       Implementação do Requisito 2.2 - Deve contem pelo menos um método estático no programa. 
       Certamente que ele precisa ser necessário e utilizado
       Método é estático porque não precisa instanciar uma classe para utilizá-lo 
    */
    public static void calcPerspRF(double capital) {

        String mensagem = "Perspectiva Renda Fixa:" +
                          "\n5 anos:  " + String.format("%.2f", capital * (Math.pow((1 + 0.008), 60))) +
                          "\n10 anos: " +  String.format("%.2f", capital * (Math.pow((1 + 0.008), 120))) +
                          "\n15 anos: " +  String.format("%.2f", capital * (Math.pow((1 + 0.008), 180))) ;     
        JOptionPane.showMessageDialog(null,mensagem);
    }

}
