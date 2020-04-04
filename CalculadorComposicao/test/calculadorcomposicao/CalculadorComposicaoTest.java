/*
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

import java.util.Iterator;
import java.util.List;
import jdk.nashorn.internal.parser.JSONParser;
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
        for (Iterator<JSONObject> iterator = result.iterator(); iterator.hasNext();)
        {
            JSONObject c = iterator.next();
            System.out.println(c);
        }
    }
}
