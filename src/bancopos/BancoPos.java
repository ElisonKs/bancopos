/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

import java.util.ArrayList;
import java.util.Scanner;
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
    public static void main(String[] args) {
        
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
                       System.out.println("Passo1");
                       String aux_cpf,aux_nome,aux_endereco,aux_email,aux_telefone;
                       Cliente_PessoaFisica pf1;
                       System.out.println("Passo2");
                       EntradaDados novo_dados = new EntradaDados();
                       System.out.println("Passo3");
                      // novo_dados.abrirEntrada("CPF");
                       System.out.println("Passo4");
                       aux_cpf = JOptionPane.showInputDialog("Entre com o CPF");
                       pf1 = new Cliente_PessoaFisica(aux_cpf,"Elison Nunes",1,"Rua do IMperador 76","elison.nunes@gmail.com","87988540970");
                   
                       ListaClientesPF.add(pf1);
                   }
                   break;
                           
           }
           
       }
    }
    
}
