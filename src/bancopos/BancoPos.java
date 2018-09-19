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
import telas.DepositarForm;
import telas.MenuForm;
import telas.SacarForm;
import telas.SaldoForm;
import telas.TransferirForm;

/**
 *
 * @author Elison
 */
public class BancoPos {

    static ArrayList<Cliente_PessoaFisica> ListaClientesPF = new ArrayList();
    static ArrayList<Cliente_PessoaJuridica> ListaClientesPJ = new ArrayList();
    static ArrayList<Transacao> ListaTransacoes = new ArrayList();
    static MenuForm menu = new MenuForm();

    public static int menu() throws InterruptedException {
        int opcao;
        menu.setVisible(true);
        
        while(menu.getOpcao() == 0)
              Thread.sleep(500);
        opcao = menu.getOpcao();
        menu.setOpcao(0);
        return opcao;
    }

    public static void main(String[] args) throws ParseException, InterruptedException, SaldoInsuficienteException {

        int opcao = 0;

        Scanner leitor = new Scanner(System.in);
        carregarDados();
        
        while (opcao != 7) {
            opcao = menu();
            switch (opcao) {
                case 1:
                   
                    Date data1 = new Date(2018, 8, 9);
                    imprimirExtrato(data1);
                    Date data2 = new Date(2018, 9, 9);
                    imprimirExtrato(data1, data2);
                    Date data3 = new Date(2018,9,17);
                    imprimirExtrato(data1,data2,data3);
                    break;
                case 2:
                    SaldoForm consultar_saldo = new SaldoForm();
                    consultar_saldo.setLocationRelativeTo(menu);
                    consultar_saldo.setVisible(true);
                    while(consultar_saldo.getNumeroConta()==0)
                    {
                        Thread.sleep(500);
                    }
                    for(Cliente_PessoaFisica clientePF : ListaClientesPF)
                    {
                        for(Conta conta_cliente : clientePF.contasCliente)
                        {
                            if(conta_cliente.getNumero() == consultar_saldo.getNumeroConta())
                            {
                                consultar_saldo.carregarCliente(clientePF.getNome());
                                consultar_saldo.carregarSaldo(conta_cliente.consultarSaldo());
                                           
                                
                            }
                        }
                    }
                
                
                
                  break;
                
                case 3:
                    SacarForm novo_saque = new SacarForm();
                    novo_saque.setLocationRelativeTo(menu);
                    novo_saque.setVisible(true);
                     while(novo_saque.getNumeroConta() == 0)
                     {
                        Thread.sleep(500);
                     }
                    for(Cliente_PessoaFisica clientePF : ListaClientesPF)
                    {
                        for(Conta conta_cliente : clientePF.contasCliente)
                        {
                            if(conta_cliente.getNumero() == novo_saque.getNumeroConta())
                            {
                                novo_saque.carregarCliente(clientePF.getNome());
                                novo_saque.carregarSaldo(conta_cliente.consultarSaldo());
                                novo_saque.focarValor();
                                while(novo_saque.getValorSaque() == 0)
                                {
                                    Thread.sleep(500);
                                } 
                                conta_cliente.sacar(novo_saque.getValorSaque());
                                Date data_saque = new Date(2018,9,17);
                                Transacao nova_Trasancao = new Transacao(novo_saque.getNumeroConta(),novo_saque.getValorSaque(),TipoTransacao.SAQUE,data_saque);
                                ListaTransacoes.add(nova_Trasancao);
                                
                                
                            }
                        }
                    }
                     
                     
                    break;
                case 4:
                    TransferirForm nova_transferencia = new TransferirForm();
                    nova_transferencia.setLocationRelativeTo(menu);
                    nova_transferencia.setVisible(true);
                    while((nova_transferencia.getNumeroContaDestino() == 0) ||( nova_transferencia.getNumeroContaOrigem()==0))
                    {
                        Thread.sleep(500);
                        
                    }
                    for(Cliente_PessoaFisica clientePF : ListaClientesPF)
                    {
                        for(Conta conta_cliente : clientePF.contasCliente)
                        {
                            if(conta_cliente.getNumero() == nova_transferencia.getNumeroContaOrigem())
                            {
                                nova_transferencia.carregarClienteOrigem(clientePF.getNome());
                                nova_transferencia.carregarSaldo(conta_cliente.consultarSaldo());
                            }
                            
                             if(conta_cliente.getNumero() == nova_transferencia.getNumeroContaDestino())
                            {
                                nova_transferencia.carregarClienteDestino(clientePF.getNome());
                            }
                        }
                    }
                    
                    while(nova_transferencia.getValorTransferir()==0)
                    {
                        Thread.sleep(500);
                    }
                     for(Cliente_PessoaFisica clientePF : ListaClientesPF)
                    {
                        for(Conta conta_cliente : clientePF.contasCliente)
                        {
                            if(conta_cliente.getNumero() == nova_transferencia.getNumeroContaOrigem())
                            {
                                conta_cliente.sacar(nova_transferencia.getValorTransferir());
                            }
                            
                             if(conta_cliente.getNumero() == nova_transferencia.getNumeroContaDestino())
                            {
                                conta_cliente.depositar(nova_transferencia.getValorTransferir());
                            }
                        }
                    }
                    Date data_transferencia = new Date(2018,9,17);
                    Transacao nova_Trasancao = new Transacao(nova_transferencia.getNumeroContaOrigem(),nova_transferencia.getNumeroContaDestino(),nova_transferencia.getValorTransferir(),TipoTransacao.TRANSFERENCIA,data_transferencia);
                    ListaTransacoes.add(nova_Trasancao);
                    break;
                    
                case 5:    
                  DepositarForm novo_deposito = new DepositarForm();
                    novo_deposito.setLocationRelativeTo(menu);
                    novo_deposito.setVisible(true);
                     while(novo_deposito.getNumeroConta() == 0)
                     {
                        Thread.sleep(500);
                     }
                    for(Cliente_PessoaFisica clientePF : ListaClientesPF)
                    {
                        for(Conta conta_cliente : clientePF.contasCliente)
                        {
                            if(conta_cliente.getNumero() == novo_deposito.getNumeroConta())
                            {
                                novo_deposito.carregarCliente(clientePF.getNome());
                                novo_deposito.carregarSaldo(conta_cliente.consultarSaldo());
                                novo_deposito.focarValor();
                                while(novo_deposito.getValorDeposito() == 0)
                                {
                                    Thread.sleep(500);
                                } 
                                conta_cliente.depositar(novo_deposito.getValorDeposito());
                                Date data_deposito = new Date(2018,9,17);
                                nova_Trasancao = new Transacao(novo_deposito.getNumeroConta(),novo_deposito.getValorDeposito(),TipoTransacao.DEPOSITO,data_deposito);
                                ListaTransacoes.add(nova_Trasancao);
                                
                                
                            }
                        }
                    }    
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
