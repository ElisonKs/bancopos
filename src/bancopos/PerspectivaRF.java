package bancopos;
/**
 *
 * @author nailsonandrade
 */
public class PerspectivaRF {
    
    public static void CalcPerspRF(double capital) {

        System.out.println("Perspectiva Renda Fixa:");
        System.out.println("5 anos: " + capital*(Math.pow((1+0.008), 60)));
        System.out.println("10 anos: " + capital*(Math.pow((1+0.008), 120)));
        System.out.println("15 anos: " + capital*(Math.pow((1+0.008), 180)));
    }
    
}
