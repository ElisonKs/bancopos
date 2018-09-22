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

/*
    Implementação do requisito 13 - Alguma informação do sistema deve ser guardada 
    em um arquivo e depois recuperada e usada.
    A classe é responsável por escrever um arquivo que guarda a taxa de rendimento variável
*/
public class LerEscreverArquivo {

    File arquivoPF = new File("saldosPF.txt");

    public void gravarSaldosPF(ArrayList<ClientePessoaFisica> clientes) throws IOException, ParseException {
        int i, y;
        MaskFormatter mf = new MaskFormatter("####");
        mf.setValueContainsLiteralCharacters(false);
        if (!arquivoPF.exists()) {
            arquivoPF.createNewFile();
        }
        FileWriter fw = new FileWriter(arquivoPF);
        BufferedWriter bw = new BufferedWriter(fw);
        for (i = 0; i < clientes.size(); i++) {
            bw.write("Cliente   " + clientes.get(i).getId());
            bw.newLine();
            bw.newLine();
            for (y = 0; y < clientes.get(i).contasCliente.size(); y++) {
                String numeroAux, saldoAux;
                numeroAux = Integer.toString(clientes.get(i).contasCliente.get(y).getNumero());
                numeroAux = mf.valueToString(numeroAux);
                saldoAux = Double.toString(clientes.get(i).contasCliente.get(y).getSaldo());
                bw.write(numeroAux + saldoAux);
                bw.newLine();

            }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
}
