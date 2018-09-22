package bancopos;

public class PerspectivaRF {
    
    /*
       Implementação do Requisito 2.2 - Deve contem pelo menos um método estático no programa. 
       Certamente que ele precisa ser necessário e utilizado
       Método é estático porque não precisa instanciar uma classe para utilizá-lo 
    */
    public static void calcPerspRF(double capital) {

        System.out.println("Perspectiva Renda Fixa:");
        System.out.println("5 anos: " + capital * (Math.pow((1 + 0.008), 60)));
        System.out.println("10 anos: " + capital * (Math.pow((1 + 0.008), 120)));
        System.out.println("15 anos: " + capital * (Math.pow((1 + 0.008), 180)));
    }

}
