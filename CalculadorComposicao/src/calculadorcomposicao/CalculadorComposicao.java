/**
 *
 * Classe CalculadorComposicao
 */
package calculadorcomposicao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Werner
 */
public class CalculadorComposicao {

    private static CalculadorComposicao calculador;
    private static ArrayList<Composicao> lista;

    public CalculadorComposicao() {
        lista = new ArrayList<>();
    }
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        calculador = new CalculadorComposicao();
        JSONArray entrada = calculador.leArquivoEntrada("entrada.json");
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject c = iterator.next();
            Composicao composicao = calculador.criaComposicao(c);
            lista.add(composicao);
        }
        Collections.sort(lista, new OrdenaPorCodigoComposicaoAsc());
        
    }
    
    Composicao criaComposicao(JSONObject e) {
        return new Composicao
            (
                (Long)   e.getOrDefault("codigoComposicao", 0L),
                (String) e.getOrDefault("descricaoComposicao", ""),
                (String) e.getOrDefault("unidadeComposicao", ""),
                (String) e.getOrDefault("tipoItem", ""),
                (Long)   e.getOrDefault("codigoItem", 0L),
                (String) e.getOrDefault("descricaoItemComposicao", ""),
                (String) e.getOrDefault("unidadeItem", ""),
                (String) e.getOrDefault("quantidadeComposicao", ""),
                (String) e.getOrDefault("valorUnitario", "")
            );
    }
    
    ArrayList<Composicao> buscaInsumos(Composicao itemComposicao) 
    {
        ArrayList<Composicao> ret = new ArrayList<>();
        

        return ret;
    }
    
    /**
     * 
     * @param path o caminho do arquivo de entrada
     */
    JSONArray leArquivoEntrada(String path) {
        JSONArray entrada;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        try {
            //Salva no objeto JSONArray o que o parse tratou do arquivo
            entrada = (JSONArray) parser.parse(new FileReader(
                    path));
            return entrada;
        } 
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado!");
            System.out.println("Caminho do arquivo: " + path);
            System.out.println(e.getMessage());
            return null;
        } catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

class OrdenaPorCodigoComposicaoAsc implements Comparator<Composicao> {

    @Override
    public int compare(Composicao a, Composicao b) {
        return (int) (a.codigoComposicao - b.codigoComposicao);
    }
}