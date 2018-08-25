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
public interface NegocioInterface {

    Agencia getAgencia_conta();

    Cliente getCliente_conta();

    double getSaldo();

    void setAgencia_conta(Agencia agencia_conta);

    void setCliente_conta(Cliente cliente_conta);

    void setSaldo(double saldo);
    
}
