/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import telas.SacarForm;

/**
 *
 * @author Elison
 */
public class BancoPos {

    static ArrayList<Cliente_PessoaFisica> ListaClientesPF = new ArrayList();
    static ArrayList<Cliente_PessoaJuridica> ListaClientesPJ = new ArrayList();
    static ArrayList<Transacao> ListaTransacoes = new ArrayList();

    public static int menu() {
        String aux;
        aux = JOptionPane.showInputDialog(null, "Selecione a opção desejada:\n"
                + "1 - Imprimir Extrato\n"
                + "2 - Verificar Saldo\n"
                + "3 - Sacar\n"
                + "4 - Transferir\n"
                + "5 - Depositar\n"
                + "6 - Investir\n"
                + "7 - Encerrar", "Menu", 3);

        return Integer.parseInt(aux);
    }

    public static void main(String[] args) throws ParseException {

        int opcao = 0;

        Scanner leitor = new Scanner(System.in);
        carregarDados();
        
        while (opcao != 7) {
            opcao = menu();

            switch (opcao) {
                case 1:
                    //int aux;
                    //System.out.println("Informe 1 para Pessoa Fisica e 2 para Pessoa Juridica:");
                    //aux = leitor.nextInt();
                    Date data1 = new Date(2018, 8, 9);
                    imprimirExtrato(data1);
                    Date data2 = new Date(2018, 9, 9);
                    imprimirExtrato(data1, data2);
                    break;
                case 3:
                    
                    
                    
                    
                    SacarForm novo_saque = new SacarForm();
                
                   final JDialog frame = new JDialog(null, "Sacar", true);
                   frame.getContentPane().add(novo_saque);
                   frame.pack();
                   frame.setVisible(true);
                /*Date data1 = new Date(2018, 8, 9);
                    imprimirExtrato(data1);
                    Date data2 = new Date(2018, 9, 9);
                    imprimirExtrato(data1, data2);
                    break;*/
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

    public static void imprimirExtrato(Date... datas) {
        System.out.println("-------------------");
        for (Date data : datas) {
            for (Transacao transacao : ListaTransacoes) {
                if ((transacao.getDataTransacao().compareTo(data) == 0)) {
                    transacao.imprimir();
                }
            }
        }

    }

    public static void carregarDados() {
        Cliente pf1, pf2;
        pf1 = new Cliente_PessoaFisica("02860189505", "Elison Nunes", 1, "Rua do IMperador 76", "elison.nunes@gmail.com", "87988540970");
        Agencia agencia_aux = new Agencia(969, "Rua das Flores 25", "8738664567");
        ContaCorrente contacorrenteAux = new ContaCorrente(1, agencia_aux, 3500);
        ContaPoupanca contaPoupancaAux = new ContaPoupanca(2, agencia_aux);
        pf1.contasCliente.add(contacorrenteAux);
        pf1.contasCliente.add(contaPoupancaAux);
        ListaClientesPF.add((Cliente_PessoaFisica) pf1);

        pf2 = new Cliente_PessoaFisica("9505", "Vinicius Barbosa", 2, "Rua do Coqueiro 25", "alenvi@gmail.com", "8798854555");
        agencia_aux = new Agencia(969, "Rua das Flores 25", "8738664567");
        contacorrenteAux = new ContaCorrente(3, agencia_aux, 4000);
        pf2.contasCliente.add(contacorrenteAux);

        ListaClientesPF.add((Cliente_PessoaFisica) pf2);
        Date data_aux = new Date(2018, 9, 9);
        Transacao transacao_aux1 = new Transacao(1, 2, 200, TipoTransacao.TRANSFERENCIA, data_aux);
        ListaTransacoes.add(transacao_aux1);
        data_aux = new Date(2018, 8, 9);
        Transacao transacao_aux2 = new Transacao(1, 200, TipoTransacao.SAQUE, data_aux);
        ListaTransacoes.add(transacao_aux2);
    }

}
