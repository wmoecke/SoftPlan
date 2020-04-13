/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorcomposicao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
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
public class Helpers {

    private final static ArrayList<Composicao> lista = new ArrayList<Composicao>();

    /**
     * @return ArrayList<Composicao> lista
     */
    public static ArrayList<Composicao> getLista() {
        return lista;
    }
    
    static void populaLista(JSONArray entrada) {
        lista.clear();
        for (Iterator<JSONObject> iterator = entrada.iterator(); 
                iterator.hasNext();)
        {
            JSONObject c = iterator.next();
            lista.add(criaComposicao(c));
        }
    }
    
    static Composicao criaComposicao(Map e) {
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
    
    static void totalizaItensComposicao() {
        lista.forEach(next -> {
            Double vt = next.getValorUnitario();
            ArrayList<Composicao> insumos = buscaInsumos(next);
            if(!insumos.isEmpty()) {
                for (Composicao insumo : insumos) {
                    vt += insumo.getValorComposicao();
                }
            }
            next.setValorUnitario(vt);
        });
    }
    
    static ArrayList<Composicao> buscaInsumos(Composicao itemComposicao) 
    {
        ArrayList<Composicao> tmp, ret, ins = new ArrayList<Composicao>();
        tmp = (ArrayList<Composicao>) lista.stream().filter(c -> Objects
                .equals(c.getCodigoComposicao(), itemComposicao.getCodigoItem()))
                .collect(Collectors.toList());
        
        ret = (ArrayList<Composicao>) tmp.clone();
        Collections.copy(ret, tmp);
         
        tmp.forEach(c -> {
            ins.addAll(buscaInsumos(c));
            if (!ins.isEmpty()) {
                ret.remove(c);
            }
        });
        ret.addAll(ins);

        return ret;
    }
    
    static Map<Long, Double> agrupaItensPorComposicao() {
        Map<Long, Double> ret = lista.stream().collect(Collectors
                .groupingBy(Composicao::getCodigoComposicao, 
                        Collectors.summingDouble(Composicao::
                                getValorComposicao)));
        return ret;
    }
    
    static Composicao buscaComposicao(Map.Entry<Long, Double> item) {
        return (Composicao) lista.stream()
                .filter(c -> Objects.equals(c.getCodigoComposicao(), 
                        item.getKey())).findFirst().get();
    }
}
