/**
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe CalculadorComposicao
 * @author Werner
 */
public class CalculadorComposicaoTest {
    
    @Test
    public void testLeArquivoEntrada() {
        System.out.println("testLeArquivoEntrada():");
        JSONArray entrada = CalculadorComposicao.leArquivoEntrada("entrada.json");
        assertNotNull(entrada);
        assertTrue(!entrada.isEmpty());
        //DEBUG PRINT:
        for (Iterator<JSONObject> iterator = entrada.iterator();
                iterator.hasNext();) {
            JSONObject next = iterator.next();
            System.out.println("------------------------------");
            System.out.println(next);
        }
        System.out.println();
    }
    
    @Test
    public void testOrdenaListaCrescente() {
        System.out.println("testOrdenaListaCrescente():");
        JSONArray entrada = CalculadorComposicao.leArquivoEntrada("entrada.json");
        ArrayList<Composicao> result = new ArrayList<>();
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao composicao = CalculadorComposicao.criaComposicao(next);
            result.add(composicao);
        }
        ArrayList<Composicao> sorted = (ArrayList<Composicao>) result.clone();
        Collections.copy(sorted, result);
        //Testa antes da ordenação
        assertEquals(result, sorted);
        sorted = ordenaListaCrescente(sorted);
        //Testa depois da ordenação
        assertNotEquals(result, sorted);
        //DEBUG PRINT:
        result.forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.println(currItem.toString());
        });
        System.out.println();
    }
    
    @Test
    public void testBuscaInsumos() {
        System.out.println("testBuscaInsumos():");
        CalculadorComposicao.populaLista(CalculadorComposicao.leArquivoEntrada("entrada.json"));
        //ArrayList<Composicao> result = new ArrayList<>();
        JSONArray insumosTeste = CalculadorComposicao.leArquivoEntrada("insumosTeste.json");
        ArrayList<Composicao> expResult = new ArrayList<>();
        for (Iterator<JSONObject> iterator = insumosTeste.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao composicao = CalculadorComposicao.criaComposicao(next);
            expResult.add(composicao);
        }
        Composicao c = new Composicao(
                98561L,
                "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE "
                        + "CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, "
                        + "E = 2CM. AF_06/2018",
                "M2",
                "COMPOSICAO",
                87286L,
                "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA "
                        + "EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE "
                        + "VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. "
                        + "AF_06/2014",
                "M3",
                "0,0250000",
                "0"
        );
        ArrayList<Composicao> result = CalculadorComposicao.buscaInsumos(c);
        ArrayList<Composicao> sorted = ordenaListaCrescente(result);
        //assertEquals(expResult, sorted);
        //DEBUG PRINT:
        result.forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.println(currItem.toString());
        });
        System.out.println();
    }
    
    @Test
    public void testTotalizaItensComposicao() {
        System.out.println("testTotalizaItensComposicao():");
        //assertNotNull(CalculadorComposicao.calculaValorUnitario());
        CalculadorComposicao.populaLista(CalculadorComposicao.leArquivoEntrada("entrada.json"));
        Composicao composicao = new Composicao(
                98561L,
                "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE "
                        + "CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, "
                        + "E = 2CM. AF_06/2018",
                "M2",
                "COMPOSICAO",
                87286L,
                "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA "
                        + "EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE "
                        + "VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. "
                        + "AF_06/2014",
                "M3",
                "0,0250000",
                "0"
        );
        Double expResult, result;
        Composicao resultEquals = getComposicao(composicao);
        expResult = 0d;
        result = resultEquals.getValorUnitario();
        //Testa valor antes da totalização
        assertEquals(expResult, result);
        CalculadorComposicao.totalizaItensComposicao();
        resultEquals = getComposicao(composicao);
        expResult = 289.1d;
        result = resultEquals.getValorUnitario();
        //Testa valor depois da totalização
        assertEquals(expResult, result);
        //DEBUG PRINT:
        CalculadorComposicao.getLista().forEach((Composicao item) -> {
            System.out.println("------------------------------");
            System.out.println(item.toString());
        });
        System.out.println("--------------FIM-------------\n");
    }
    
    @Test
    public void testAgrupaItensComposicao() {
        System.out.println("testAgrupaItensComposicao():");
        CalculadorComposicao.populaLista(CalculadorComposicao.leArquivoEntrada("entrada.json"));
        CalculadorComposicao.totalizaItensComposicao();
        ArrayList<Double> expResult = new ArrayList<>();
        expResult.add(28.731000);
        expResult.add(289.981900);
        expResult.add(128.613880);
        expResult.add(0.220000);
        expResult.add(1.250000);
        Map<Long, Double> result = CalculadorComposicao.agrupaItensComposicao();
        assertNotNull(CalculadorComposicao.agrupaItensComposicao());
        //DEBUG PRINT:
        CalculadorComposicao.getLista().forEach((Composicao item) -> {
            System.out.println("------------------------------");
            System.out.println(item.toString());
        });
        System.out.println("--------------FIM-------------\n");
        //DEBUG PRINT:
        for (Iterator<Map.Entry<Long, Double>> iterator = result.entrySet().iterator(); iterator.hasNext();) 
        {
            Map.Entry<Long, Double> next = iterator.next();
            //DEBUG PRINT:
            System.out.println("------------------------------");
            String str = String.format("%d: %f", next.getKey(), next.getValue());
            System.out.println(str);
        }
        System.out.println("--------------FIM-------------\n");
    }

    ArrayList<Composicao> ordenaListaCrescente(ArrayList<Composicao> listaDesordenada) {
        ArrayList<Composicao> ret;
        ret = (ArrayList<Composicao>) listaDesordenada.stream()
                .sorted(Comparator.comparingLong(Composicao::getCodigoComposicao))
                .collect(Collectors.toList());
        return ret;
    }
    
    Composicao getComposicao(Composicao item) {
        return (Composicao) CalculadorComposicao.getLista().stream()
                .filter(c -> Objects.equals(c.getCodigoComposicao(), 
                        item.getCodigoComposicao()) &&
                        Objects.equals(c.getCodigoItem(), 
                        item.getCodigoItem())).findAny().get();
    }
}
