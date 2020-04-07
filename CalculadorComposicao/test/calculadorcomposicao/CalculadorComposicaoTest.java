/**
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
        ArrayList<Composicao> sorted = (ArrayList<Composicao>) result.clone();
        Collections.copy(sorted, result);
        Collections.sort(sorted, new OrdenaPorCodigoComposicaoAsc());
        assertNotEquals(result, sorted);
//        result.forEach((Composicao currItem) -> {
//            System.out.println("------------------------------");
//            System.out.print(currItem.toString());
//        });
        System.out.println();
    }
    
    @Test
    public void testBuscaInsumos() {
        System.out.println("testBuscaInsumos():");
        CalculadorComposicao.populaLista(CalculadorComposicao.leArquivoEntrada("entrada.json"));
        //ArrayList<Composicao> result = new ArrayList<>();
        Collections.sort(instance.getLista(), new OrdenaPorCodigoComposicaoAsc());
        instance.getLista().forEach((Composicao currItem) -> {
            System.out.println("------------------------------");
            System.out.print(currItem.toString());
            ArrayList<Composicao> insumos = CalculadorComposicao.buscaInsumos(currItem);
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
        //assertNotEquals(new ArrayList<>(), result);
    }
}
