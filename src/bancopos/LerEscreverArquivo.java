/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancopos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Elison
 */
public class LerEscreverArquivo {
    
    File arquivoPF = new File("saldosPF.txt");
    
    public void gravarSaldosPF(ArrayList<Cliente_PessoaFisica> clientes) throws IOException, ParseException
    {
        int i,y;
        MaskFormatter mf = new MaskFormatter("####");
        mf.setValueContainsLiteralCharacters(false);
        if(!arquivoPF.exists())
            arquivoPF.createNewFile();
        FileWriter fw = new FileWriter(arquivoPF);
        BufferedWriter bw = new BufferedWriter(fw);
        for(i=0;i<clientes.size();i++)
        {
            bw.write("Cliente   " + clientes.get(i).getId());
            bw.newLine();
            bw.newLine();
            for(y=0;y<clientes.get(i).contasCliente.size();y++)
            {
                String numero_aux,saldo_aux;
                numero_aux = Integer.toString(clientes.get(i).contasCliente.get(y).getNumero());
                numero_aux = mf.valueToString(numero_aux);
                saldo_aux = Double.toString(clientes.get(i).contasCliente.get(y).getSaldo());
                bw.write(numero_aux + saldo_aux);
                bw.newLine();
                
            }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
