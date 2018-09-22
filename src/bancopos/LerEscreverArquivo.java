package bancopos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

    static File arquivoTaxa = new File("TaxaRendimento.txt");

    public static void gravarTaxa(String taxa) throws IOException, ParseException {
        if (!arquivoTaxa.exists()) {
            arquivoTaxa.createNewFile();
        }
        FileWriter fw = new FileWriter(arquivoTaxa);
        BufferedWriter bw = new BufferedWriter(fw);
       
        bw.write(taxa);
        bw.close();
        fw.close();
    }
    
    public static String getTaxa() throws FileNotFoundException, IOException
    {
        String  taxa;
        if (arquivoTaxa.exists())
        {
            FileReader fr = new FileReader(arquivoTaxa);
            BufferedReader br = new BufferedReader(fr);
            taxa = br.readLine();
        }
        else
        {
            taxa = "0";
        }
        return taxa;
    }
}
