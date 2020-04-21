/**
 *
 * Classe de testes unitários para a Classe Helpers.
 */
package calculadorcomposicao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Werner
 */
public class HelpersTest {

    private Helpers helpers = null;
    
    @Before
    public void setUp() {
        helpers = new Helpers();
    }
    
    @After
    public void tearDown() {
        helpers = null;
    }
    /**
     * Teste do método getLista, da classe Helpers.
     */
    @Test
    public void testGetLista() {
        System.out.println("getLista()");
        ArrayList<Composicao> expResult = new ArrayList<>();
        //Limpamos a lista
        helpers.getLista().clear();
        ArrayList<Composicao> result = helpers.getLista();
        //Antes de popular a lista (lista vazia)
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    /**
     * Teste do método populaLista, da classe Helpers.
     */
    @Test
    public void testPopulaLista() {
        System.out.println("populaLista()");
        String path = "src/calculadorcomposicao/entrada.json";
        JSONArray entrada = helpers.leArquivoEntrada(path);
        helpers.populaLista(entrada);
        ArrayList<Composicao> result = helpers.getLista();
        //Depois de popular a lista (lista preenchida)
        assertNotNull(result);
        assertTrue(!result.isEmpty());
    }

    /**
     * Teste do método criaComposicao, da classe Helpers.
     */
    @Test
    public void testCriaComposicao() {
        System.out.println("criaComposicao():");
        Map e = new HashMap<>();
        e.put("codigoComposicao", 94793L);
        e.put("descricaoComposicao", "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016");
        e.put("unidadeComposicao", "UN");
        e.put("tipoItem", "INSUMO");
        e.put("codigoItem", 3148L);
        e.put("descricaoItemComposicao", "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)");
        e.put("unidadeItem", "UN");
        e.put("quantidadeComposicao", "0,0190000");
        e.put("valorUnitario", "9,40");
        
        Double valorUnitario, quantidadeComposicao;
        valorUnitario = helpers.converteValor((String) e.getOrDefault("valorUnitario", ""));
        quantidadeComposicao = helpers.converteValor((String) e.getOrDefault("quantidadeComposicao", ""));
        Composicao expResult = new Composicao
            (
                (Long)   e.getOrDefault("codigoComposicao", 0L),
                (String) e.getOrDefault("descricaoComposicao", ""),
                (String) e.getOrDefault("unidadeComposicao", ""),
                (String) e.getOrDefault("tipoItem", ""),
                (Long)   e.getOrDefault("codigoItem", 0L),
                (String) e.getOrDefault("descricaoItemComposicao", ""),
                (String) e.getOrDefault("unidadeItem", ""),
                quantidadeComposicao,
                valorUnitario
            );
        Composicao result = helpers.criaComposicao(e);
        //assertEquals(expResult, result);
        String strResult = result.toString();
        String strExpResult = expResult.toString();
        assertEquals(strExpResult, strResult);
        
        //DEBUG PRINT:
        System.out.println(expResult.toString());
        System.out.println(result.toString());
        System.out.println();
    }

    /**
     * Teste do método leArquivoEntrada, da classe Helpers.
     */
    @Test
    public void testLeArquivoEntrada() {
        System.out.println("leArquivoEntrada():");
        String path = "src/calculadorcomposicao/entrada.json";
        JSONArray result = helpers.leArquivoEntrada(path);
        assertNotNull(result);
        assertTrue(!result.isEmpty());
        
        //DEBUG PRINT:
        for (Iterator<JSONObject> iterator = result.iterator();
                iterator.hasNext();) {
            JSONObject next = iterator.next();
            System.out.println("------------------------------");
            System.out.println(next);
        }
        System.out.println();
    }

    /**
     * Teste do método totalizaItensComposicao, da classe Helpers.
     */
    @Test
    public void testTotalizaItensComposicao() {
        System.out.println("totalizaItensComposicao():");
        String path = "src/calculadorcomposicao/entrada.json";
        helpers.populaLista(helpers.leArquivoEntrada(path));
        Composicao composicao = new Composicao(
                98561L,
                "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018",
                "M2",
                "COMPOSICAO",
                87286L,
                "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014",
                "M3",
                0.0250000,
                0d
        );
        Double expResult, result;
        Composicao resultEquals = getComposicao(composicao);
        expResult = 0d;
        result = resultEquals.getValorUnitario();
        //Testa valor antes da totalização
        assertEquals(expResult, result);
        helpers.totalizaItensComposicao();
        resultEquals = getComposicao(composicao);
        expResult = 289.10420000000005;
        result = resultEquals.getValorUnitario();
        //Testa valor depois da totalização
        assertEquals(expResult, result);
        
        //DEBUG PRINT:
        helpers.getLista().forEach((Composicao item) -> {
            System.out.println("------------------------------");
            System.out.println(item.toString());
        });
        System.out.println("--------------FIM-------------\n");
    }

    /**
     * Teste do método buscaInsumos, da classe Helpers.
     */
    @Test
    public void testBuscaInsumos() {
        System.out.println("buscaInsumos():");
        Composicao itemComposicao = new Composicao(
                98561L,
                "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018",
                "M2",
                "COMPOSICAO",
                87286L,
                "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014",
                "M3",
                0.0250000,
                0d
        );
        String path = "src/calculadorcomposicao/entrada.json";
        helpers.populaLista(helpers.leArquivoEntrada(path));
        path = "test/calculadorcomposicao/insumosTeste.json";
        JSONArray insumosTeste = helpers.leArquivoEntrada(path);
        ArrayList<Composicao> expResult = new ArrayList<>();
        for (Iterator<JSONObject> iterator = insumosTeste.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao c = helpers.criaComposicao(next);
            expResult.add(c);
        }
        ArrayList<Composicao> result = helpers.buscaInsumos(itemComposicao);
        //ordenaListaCrescente(result);
        //assertEquals(expResult, result);
        String strResult = result.toString();
        String strExpResult = expResult.toString();
        assertEquals(strExpResult, strResult);
        
        //DEBUG PRINT:
        result.forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.println(currItem.toString());
        });
        System.out.println();
    }

    /**
     * Teste do método agrupaItensPorComposicao, da classe Helpers.
     */
    @Test
    public void testAgrupaItensPorComposicao() {
        System.out.println("agrupaItensPorComposicao()");
        String path = "src/calculadorcomposicao/entrada.json";
        helpers.populaLista(helpers.leArquivoEntrada(path));
        helpers.totalizaItensComposicao();
        Map<Long, Double> expResult = new HashMap<>();
        expResult.put(98561L, 28.731105000000003);
        expResult.put(87286L, 289.9819);
        expResult.put(94793L, 128.61388);
        expResult.put(88831L, 0.22);
        expResult.put(88830L, 1.25);
        Map<Long, Double> result = helpers.agrupaItensPorComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método buscaComposicao, da classe Helpers.
     */
    @Test
    public void testBuscaComposicao() {
        System.out.println("buscaComposicao()");
        String path = "src/calculadorcomposicao/entrada.json";
        helpers.populaLista(helpers.leArquivoEntrada(path));
        helpers.totalizaItensComposicao();
        Map<Long, Double> e = new HashMap<>();
        e.put(98561L, 28.73);
        Map.Entry<Long, Double> item = e.entrySet().iterator().next();
        Composicao expResult = new Composicao(
                98561L,
                "IMPERMEABILIZAÃ‡ÃƒO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018",
                "M2",
                "INSUMO",
                7325L,
                "ADITIVO IMPERMEABILIZANTE DE PEGA NORMAL PARA ARGAMASSAS E  CONCRETOS SEM ARMACAO",
                "KG",
                0.3870000,
                4.44);
        Composicao result = helpers.buscaComposicao(item);
        //assertEquals(expResult, result);
        String strResult = result.toString();
        String strExpResult = expResult.toString();
        assertEquals(strExpResult, strResult);
    }
    
    Composicao getComposicao(Composicao item) {
        return (Composicao) helpers.getLista().stream()
                .filter(c -> Objects.equals(c.getCodigoComposicao(), 
                        item.getCodigoComposicao()) &&
                        Objects.equals(c.getCodigoItem(), 
                        item.getCodigoItem())).findAny().get();
    }

    ArrayList<Composicao> ordenaListaCrescente(ArrayList<Composicao> listaDesordenada) {
        ArrayList<Composicao> ret;
        ret = (ArrayList<Composicao>) listaDesordenada.stream()
                .sorted(Comparator.comparingLong(Composicao::getCodigoComposicao))
                .collect(Collectors.toList());
        return ret;
    }
}
