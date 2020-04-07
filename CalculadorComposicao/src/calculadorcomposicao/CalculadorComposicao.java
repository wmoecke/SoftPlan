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
import java.util.Objects;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Werner
 */
public class CalculadorComposicao {

    private static ArrayList<Composicao> lista = new ArrayList<>();

    /**
     * @return ArrayList<Composicao> lista
     */
    public ArrayList<Composicao> getLista() {
        return lista;
    }
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        populaLista(leArquivoEntrada("entrada.json"));
        Collections.sort(lista, new OrdenaPorCodigoComposicaoAsc());
        lista.forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.print(currItem.toString());
            ArrayList<Composicao> insumos = buscaInsumos(currItem);
            if(!insumos.isEmpty()) {
                System.out.println(String.format("\t-----INSUMOS: %d-----", currItem.codigoComposicao));
                insumos.forEach((Composicao insumoComposicao) -> {
                    System.out.print(String.format("\t%d: %s * %s\n", 
                            insumoComposicao.codigoComposicao, 
                            insumoComposicao.quantidadeComposicao, 
                            insumoComposicao.valorUnitario));
                });
                System.out.println("\t------------------------");
                System.out.println("\t\t* " + currItem.quantidadeComposicao);
            }
        });
        System.out.println("--------------FIM-------------\n");
    }
    
    static Composicao criaComposicao(JSONObject e) {
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
    
    static void populaLista(JSONArray entrada) {
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject c = iterator.next();
            lista.add(criaComposicao(c));
        }
    }
    
    static ArrayList<Composicao> buscaInsumos(Composicao itemComposicao) 
    {
        ArrayList<Composicao> tmp, ret, ins = new ArrayList<>();
        tmp = (ArrayList<Composicao>) lista.stream()
                .filter(c -> Objects.equals(c.codigoComposicao, 
                        itemComposicao.codigoItem))
                .collect(Collectors.toList());
        
        ret = (ArrayList<Composicao>) tmp.clone();
        Collections.copy(ret, tmp);
        
        tmp.forEach((Composicao composicao) -> {
            ins.addAll(buscaInsumos(composicao));
            if (!ins.isEmpty()) {
                ret.remove(composicao);
            }
        });
        ret.addAll(ins);

        return ret;
    }
    
    /**
     * 
     * @param path o caminho do arquivo de entrada
     */
    static JSONArray leArquivoEntrada(String path) {
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