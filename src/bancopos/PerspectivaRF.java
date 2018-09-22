package bancopos;

import javax.swing.JOptionPane;

public class PerspectivaRF {

    public static void CalcPerspRF(double capital) {

        String mensagem = "Perspectiva Renda Fixa:" +
                          "\n5 anos:  " + String.format("%.2f", capital * (Math.pow((1 + 0.008), 60))) +
                          "\n10 anos: " +  String.format("%.2f", capital * (Math.pow((1 + 0.008), 120))) +
                          "\n15 anos: " +  String.format("%.2f", capital * (Math.pow((1 + 0.008), 180))) ;     
        JOptionPane.showMessageDialog(null,mensagem);
    }

}
