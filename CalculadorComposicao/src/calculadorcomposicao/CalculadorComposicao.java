/**
 *
 * Classe CalculadorComposicao
 */
package calculadorcomposicao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
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
    public static ArrayList<Composicao> getLista() {
        return lista;
    }
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        populaLista(leArquivoEntrada("entrada.json"));
        ///TODO: rest of the code goes here (as soon as I'm done).
    }
    
    static ArrayList<Composicao> calculaValorUnitario() {
        Collections.sort(lista, new OrdenaPorCodigoComposicaoAsc());
        for (Composicao next : lista) {
            DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
            Double vt;
            try {
                vt = (Double) df.parse(next.getValorUnitario()).doubleValue();
            } catch (java.text.ParseException ex) {
                vt = 0d;
            }
            ArrayList<Composicao> insumos = buscaInsumos(next);
            if(!insumos.isEmpty()) {
                for (Composicao insumo : insumos) {
                    Double v, q;
                    try {
                        v = (Double) df.parse(insumo.getValorUnitario()).doubleValue();
                        q = (Double) df.parse(insumo.quantidadeComposicao).doubleValue();
                    } catch (Exception e) {
                        v = 0d;
                        q = 0d;
                    }
                    vt += v * q;
                }
            }
            next.setValorUnitario(df.format(vt));
            //System.out.print(next.toString());
        }
        
        //DEBUG PRINT:
        lista.forEach((Composicao item) -> {
            System.out.println("------------------------------");
            System.out.print(item.toString());
        });
        System.out.println("--------------FIM-------------\n");
        return null;
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
        lista.clear();
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