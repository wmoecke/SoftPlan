/**
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe CalculadorComposicao
 * @author Werner
 */
public class CalculadorComposicaoTest {
    
    private CalculadorComposicao instance = null;

    @Before
    public void setUp() throws Exception {
        instance = new CalculadorComposicao();
        assertNotNull(instance);
    }

    @After
    public void tearDown() throws Exception {
        instance = null;
        assertNull(instance);
    }
    
    @Test
    public void testLeArquivoEntrada() {
        System.out.println("testLeArquivoEntrada():");
        JSONArray entrada = instance.leArquivoEntrada("entrada.json");
        assertNotNull(entrada);
//        for (Iterator<JSONObject> iterator = entrada.iterator();
//                iterator.hasNext();) {
//            JSONObject next = iterator.next();
//            System.out.println("------------------------------");
//            System.out.println(next);
//        }
        System.out.println();
    }
    
    @Test
    public void testOrdenaPorCodigoComposicao() {
        System.out.println("testOrdenaPorCodigoComposicao():");
        JSONArray entrada = instance.leArquivoEntrada("entrada.json");
        ArrayList<Composicao> result = new ArrayList<>();
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao composicao = instance.criaComposicao(next);
            result.add(composicao);
        }
        Collections.sort(result, new OrdenaPorCodigoComposicaoAsc());
//        lista.forEach((Composicao currItem) -> {
//            System.out.println("------------------------------");
//            System.out.print(currItem.toString());
//        });
        System.out.println();
    }
    
    @Test
    public void testBuscaInsumos() {
        System.out.println("testBuscaInsumos():");
        JSONArray entrada = instance.leArquivoEntrada("entrada.json");
        assertNotNull(entrada);
        ArrayList<Composicao> result = new ArrayList<>();
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao comp = instance.criaComposicao(next);
            result.add(comp);
        }
        Collections.sort(result, new OrdenaPorCodigoComposicaoAsc());
        result.forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.print(currItem.toString());
        });
        System.out.println();
        assertNotEquals(new ArrayList<>(), result);
    }
}
