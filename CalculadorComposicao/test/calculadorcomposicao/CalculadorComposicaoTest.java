/**
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

import java.util.ArrayList;
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
    
//    @Test
//    public void testCalculadorComposicao() {
//        fail("Nada a testar ainda.");
//    }
    
    @Test
    public void testLeArquivoEntrada() {
        System.out.println("testLeArquivoEntrada():");
        JSONArray result = instance.leArquivoEntrada("entrada.json");
        assertNotNull(result);
        ArrayList<Composicao> lista = new ArrayList<>();
        for (Iterator<JSONObject> iterator = result.iterator(); iterator.hasNext();)
        {
            JSONObject c = iterator.next();
            Composicao composicao = new Composicao
                (
                    (Long)   c.getOrDefault("codigoComposicao", 0L),
                    (String) c.getOrDefault("descricaoComposicao", ""),
                    (String) c.getOrDefault("unidadeComposicao", ""),
                    (String) c.getOrDefault("tipoItem", ""),
                    (Long)   c.getOrDefault("codigoItem", 0L),
                    (String) c.getOrDefault("descricaoItemComposicao", ""),
                    (String) c.getOrDefault("unidadeItem", ""),
                    (String) c.getOrDefault("quantidadeComposicao", "0"),
                    (String) c.getOrDefault("valorUnitario", "0")
                );
            lista.add(composicao);
//            System.out.println(String.format("Iterando em %s:", c.entrySet()));
//            for (Iterator<Map.Entry> iter = c.entrySet().iterator(); iter.hasNext();)
//            {
//                Map.Entry currItem = iter.next();
//                System.out.println("\t" + currItem.getKey() + ": " + currItem.getValue());
//            }
//            System.out.println("------------------------------");
        }
        //System.out.println(String.format("Iterando em %s:", lista.toString()));
        lista.forEach((Composicao currItem) -> {
            System.out.print(currItem.toString());
            System.out.println("------------------------------\n");
        });
    }
    
//    @Test
//    public void testMontaListaComposicao() {
//        System.out.println("testLeArquivoEntrada():\n");
//        JSONArray entrada = instance.leArquivoEntrada("entrada.json");
//        List<Composicao> result = instance.montaListaComposicao(entrada);
//        assertNotNull(result);
//    }
}
