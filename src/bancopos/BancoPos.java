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
import telas.investirForm;


public class BancoPos {
    
    /*
        Requisito 1.4 - Deve ter pelo menos um atributo ArrayList
        ArrayList criado para guardar uma coleção de Clientes
    */
    static ArrayList<ClientePessoaFisica> listaClientesPF  = new ArrayList();
    static ArrayList<ClientePessoaJuridica> listaClientesPJ = new ArrayList();
    static ArrayList<Transacao> listaTransacoes = new ArrayList();
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
                    // Utilização do método imprimirExtrato() - Requisito 2.1
                    imprimirExtrato(data1,data2,data3);
                    break;
                case 2:
                    SaldoForm consultarSaldo = new SaldoForm();
                    consultarSaldo.setLocationRelativeTo(menu);
                    consultarSaldo.setVisible(true);
                    while(consultarSaldo.getNumeroConta()==0)
                    {
                        Thread.sleep(500);
                    }
                    for(ClientePessoaFisica clientePF : listaClientesPF)
                    {
                        for(Conta contaCliente : clientePF.contasCliente)
                        {
                            if(contaCliente.getNumero() == consultarSaldo.getNumeroConta())
                            {
                                consultarSaldo.carregarCliente(clientePF.getNome());
                                consultarSaldo.carregarSaldo(contaCliente.consultarSaldo());
                                           
                                
                            }
                        }
                    }
                
                    consultarSaldo.dispose();
                
                  break;
                
                case 3:
                    SacarForm novoSaque = new SacarForm();
                    novoSaque.setLocationRelativeTo(menu);
                    novoSaque.setVisible(true);
                     while(novoSaque.getNumeroConta() == 0)
                     {
                        Thread.sleep(500);
                     }
                    for(ClientePessoaFisica clientePF : listaClientesPF)
                    {
                        for(Conta contaCliente : clientePF.contasCliente)
                        {
                            if(contaCliente.getNumero() == novoSaque.getNumeroConta())
                            {
                                novoSaque.carregarCliente(clientePF.getNome());
                                novoSaque.carregarSaldo(contaCliente.consultarSaldo());
                                novoSaque.focarValor();
                                while(novoSaque.getValorSaque() == 0)
                                {
                                    Thread.sleep(500);
                                }
                                //Método usado para sacar, lança exceção em caso de saldo insuficiente.
                                contaCliente.sacar(novoSaque.getValorSaque());
                                Date dataSaque = new Date(2018,9,17);
                                Transacao nova_Trasancao = new Transacao(novoSaque.getNumeroConta(),novoSaque.getValorSaque(),TipoTransacao.SAQUE,dataSaque);
                                listaTransacoes.add(nova_Trasancao);
                                
                                
                            }
                        }
                    }
                    novoSaque.dispose();
                     
                    break;
                case 4:
                    TransferirForm novaTransferencia = new TransferirForm();
                    novaTransferencia.setLocationRelativeTo(menu);
                    novaTransferencia.setVisible(true);
                    while((novaTransferencia.getNumeroContaDestino() == 0) ||( novaTransferencia.getNumeroContaOrigem()==0))
                    {
                        Thread.sleep(500);
                        
                    }
                    for(ClientePessoaFisica clientePF : listaClientesPF)
                    {
                        for(Conta contaCliente : clientePF.contasCliente)
                        {
                            if(contaCliente.getNumero() == novaTransferencia.getNumeroContaOrigem())
                            {
                                novaTransferencia.carregarClienteOrigem(clientePF.getNome());
                                novaTransferencia.carregarSaldo(contaCliente.consultarSaldo());
                            }
                            
                             if(contaCliente.getNumero() == novaTransferencia.getNumeroContaDestino())
                            {
                                novaTransferencia.carregarClienteDestino(clientePF.getNome());
                            }
                        }
                    }
                    
                    while(novaTransferencia.getValorTransferir()==0)
                    {
                        Thread.sleep(500);
                    }
                     for(ClientePessoaFisica clientePF : listaClientesPF)
                    {
                        for(Conta contaCliente : clientePF.contasCliente)
                        {
                            if(contaCliente.getNumero() == novaTransferencia.getNumeroContaOrigem())
                            {
                                contaCliente.sacar(novaTransferencia.getValorTransferir());
                            }
                            
                             if(contaCliente.getNumero() == novaTransferencia.getNumeroContaDestino())
                            {
                                contaCliente.depositar(novaTransferencia.getValorTransferir());
                            }
                        }
                    }
                    Date dataTransferencia = new Date(2018,9,17);
                    Transacao novaTransacao = new Transacao(novaTransferencia.getNumeroContaOrigem(),novaTransferencia.getNumeroContaDestino(),novaTransferencia.getValorTransferir(),TipoTransacao.TRANSFERENCIA,dataTransferencia);
                    listaTransacoes.add(novaTransacao);
                    novaTransferencia.dispose();
                    break;
                    
                case 5:    
                  DepositarForm novoDeposito = new DepositarForm();
                    novoDeposito.setLocationRelativeTo(menu);
                    novoDeposito.setVisible(true);
                     while(novoDeposito.getNumeroConta() == 0)
                     {
                        Thread.sleep(500);
                     }
                    for(ClientePessoaFisica clientePF : listaClientesPF)
                    {
                        for(Conta contaCliente : clientePF.contasCliente)
                        {
                            if(contaCliente.getNumero() == novoDeposito.getNumeroConta())
                            {
                                novoDeposito.carregarCliente(clientePF.getNome());
                                novoDeposito.carregarSaldo(contaCliente.consultarSaldo());
                                novoDeposito.focarValor();
                                while(novoDeposito.getValorDeposito() == 0)
                                {
                                    Thread.sleep(500);
                                } 
                                contaCliente.depositar(novoDeposito.getValorDeposito());
                                Date dataDeposito = new Date(2018,9,17);
                                novaTransacao = new Transacao(novoDeposito.getNumeroConta(),novoDeposito.getValorDeposito(),TipoTransacao.DEPOSITO,dataDeposito);
                                listaTransacoes.add(novaTransacao);
                                
                                
                            }
                        }
                    }  
                    novoDeposito.dispose();
                    break;
                case 6:
                    Integer tipoFundo;
                    Double valorInvestido =  500.00;
                    EntradaDados selecionarTipo = new EntradaDados();
                    selecionarTipo.abrirEntrada("1 para Renda Fixa ou 2 para Renda Variável");
                    while(selecionarTipo.getEntrada() == "")
                    {
                        Thread.sleep(500);
                    }
                    tipoFundo = Integer.parseInt(selecionarTipo.getEntrada());
                    if(tipoFundo == 1)
                    {
                       /*
                            Implementação do Requisito 7.4 - Polimorfismo Paramétrico
                            A classe Fundo é uma classe com objeto genérico, que depois é substituída 
                            pelo tipo RendaFixa
                        */
                       Fundo<RendaFixa> novoFundo = new Fundo<>(new RendaFixa(valorInvestido));
                       investirForm novoInvestimento = new investirForm();
                       novoInvestimento.setLocationRelativeTo(null);
                       novoInvestimento.carregarSaldoAnterior(Double.toString(novoFundo.objeto.getSaldo()));
                       novoFundo.objeto.render();
                       novoInvestimento.carregarSaldoAtual(Double.toString(novoFundo.objeto.getSaldo()));
                       novoInvestimento.carregarTaxa(Double.toString(novoFundo.objeto.getRendFixo()));
                       novoInvestimento.setVisible(true);
                    }
                    else if(tipoFundo == 2)
                    {
                         Fundo<RendaVariavel> novoFundo = new Fundo<>(new RendaVariavel(valorInvestido));
                       investirForm novoInvestimento = new investirForm();
                       novoInvestimento.setLocationRelativeTo(null);
                       novoInvestimento.carregarSaldoAnterior(String.format("%.2f",novoFundo.objeto.getSaldo()));
                       novoFundo.objeto.render();
                       novoInvestimento.carregarSaldoAtual(String.format("%.2f",novoFundo.objeto.getSaldo()));
                       novoInvestimento.carregarTaxa(String.format("%.2f",novoFundo.objeto.getRendimento()));
                       novoInvestimento.desabilitarPerspectiva();
                       novoInvestimento.setVisible(true);
                        
                    }
                    
                   
                    break;
                case 7:
                    LerEscreverArquivo salvar = new LerEscreverArquivo();
                     {
                        try {
                            salvar.gravarSaldosPF(listaClientesPF);
                        } catch (IOException ex) {
                            Logger.getLogger(BancoPos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                     System.exit(0);
                    break;
                    

            }

        }
    }
    
    /*
        Implementação do Requisito 2.1 - Algum método deve ter uma lista de argumentos variados
        Método imprime um extrato de transação de acordo com as datas passadas
    */
    public static void imprimirExtrato(Date... datas) {
        System.out.println("-------------------");
        for (Date data : datas) {
            for (Transacao transacao : listaTransacoes) {
                if ((transacao.getDataTransacao().compareTo(data) == 0)) {
                    transacao.imprimir();
                }
            }
        }

    }

    public static void carregarDados() {
        Cliente pf1, pf2;

        // Utilização do Requisito 3 - Construtor sendo utilizado para criar um Cliente
        pf1 = new ClientePessoaFisica("02860189505", "Elison Nunes", 1, "Rua do IMperador 76", "elison.nunes@gmail.com", "87988540970");
        Agencia agenciaAux = new Agencia(969, "Rua das Flores 25", "8738664567");
        // Utilização do Requisito 3 - Construtor sendo utilizado para criar uma Conta
        ContaCorrente contaCorrenteAux = new ContaCorrente(1, agenciaAux, 3500);
        ContaPoupanca contaPoupancaAux = new ContaPoupanca(2, agenciaAux);
        pf1.contasCliente.add(contaCorrenteAux);
        pf1.contasCliente.add(contaPoupancaAux);
        listaClientesPF.add((ClientePessoaFisica) pf1);
        
        /*
            Implementação do Requisito 7.2, onde o atributo foi declarado como Cliente, 
            porém foi instanciado como ClientePessoaFísica
        */
        pf2 = new ClientePessoaFisica("9505", "Vinicius Barbosa", 2, "Rua do Coqueiro 25", "alenvi@gmail.com", "8798854555");
        agenciaAux = new Agencia(969, "Rua das Flores 25", "8738664567");
        contaCorrenteAux = new ContaCorrente(3, agenciaAux, 4000);
        pf2.contasCliente.add(contaCorrenteAux);

        listaClientesPF.add((ClientePessoaFisica) pf2);
        Date dataAux = new Date(2018, 9, 9);
        Transacao transacaoAux1 = new Transacao(1, 2, 200, TipoTransacao.TRANSFERENCIA, dataAux);
        listaTransacoes.add(transacaoAux1);
        dataAux = new Date(2018, 8, 9);
        Transacao transacaoAux2 = new Transacao(1, 200, TipoTransacao.SAQUE, dataAux);
        listaTransacoes.add(transacaoAux2);
    }

}
