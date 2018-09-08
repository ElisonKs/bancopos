/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Elison
 */
public class BancoPos {

    public static void menu()
    {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Verificar Saldo");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Depositar");
        System.out.println("6 - Investir");
        System.out.println("7 - Encerrar");
    }
    public static void main(String[] args) throws ParseException {
        
       int opcao = 0;
       ArrayList<Cliente_PessoaFisica> ListaClientesPF = new ArrayList();
       ArrayList<Cliente_PessoaJuridica> ListaClientesPJ = new ArrayList();
       Scanner leitor = new Scanner(System.in); 
       
      
       while(opcao != 7)
       {
           menu();
           opcao = leitor.nextInt();
           
           switch(opcao)
           {
               case 1:
                   int aux;
                   System.out.println("Informe 1 para Pessoa Fisica e 2 para Pessoa Juridica:");
                   aux = leitor.nextInt();
                   if(aux == 1)
                   {
                       Cliente_PessoaFisica pf1,pf2;
                       pf1 = new Cliente_PessoaFisica("02860189505","Elison Nunes",1,"Rua do IMperador 76","elison.nunes@gmail.com","87988540970");
                       Agencia agencia_aux = new Agencia(969,"Rua das Flores 25","8738664567");
                       ContaCorrente contacorrenteAux = new ContaCorrente(1,agencia_aux,3500);
                       ContaPoupanca contaPoupancaAux = new ContaPoupanca(2,agencia_aux);
                       pf1.contasCliente.add(contacorrenteAux);
                       pf1.contasCliente.add(contaPoupancaAux);
                       ListaClientesPF.add(pf1);
                       
                       pf2 = new Cliente_PessoaFisica("9505","Vinicius Barbosa",2,"Rua do Coqueiro 25","alenvi@gmail.com","8798854555");
                       agencia_aux = new Agencia(969,"Rua das Flores 25","8738664567");
                        contacorrenteAux = new ContaCorrente(3,agencia_aux,4000);
                        pf2.contasCliente.add(contacorrenteAux);
                    
                       ListaClientesPF.add(pf2);
                   }
                   break;
               case 7:
                   LerEscreverArquivo salvar = new LerEscreverArquivo();
                   {
                     try {
                         salvar.gravarSaldosPF(ListaClientesPF);
                          } catch (IOException ex) {
                      Logger.getLogger(BancoPos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   }
                   break;
                           
           }
           
       }
    }
    
}
