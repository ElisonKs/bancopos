/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

/**
 *
 * @author Elison
 */
public class OperacaoImplementacao implements OperacaoInterface {

    private Conta conta_origem;
        
    private Conta conta_destino;

    private String data_operacao;
    
    
    @Override
    public void sacar(double valor) {
      if(this.consultarSaldo() >= valor)
          conta_origem.setSaldo(this.consultarSaldo() - valor);
      else
          System.out.println("Saldo insuficiente para realizar esta operação!");
                
    }

    @Override
    public double consultarSaldo() {
       return this.conta_origem.getSaldo();
    }

    @Override
    public void depositar(double valor) {
        this.conta_origem.setSaldo(this.consultarSaldo() + valor);
    }

    @Override
    public void transferir(double valor) {
       if(this.consultarSaldo()>= valor)
       {
           conta_origem.setSaldo(this.consultarSaldo() - valor);
           conta_destino.setSaldo(conta_destino.getSaldo() + valor);
       }
       else
             System.out.println("Saldo insuficiente para realizar esta operação!");
    }
    
    
    
}
