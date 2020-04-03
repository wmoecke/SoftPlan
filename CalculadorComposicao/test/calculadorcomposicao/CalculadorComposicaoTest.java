/*
 *
 * Classe de testes unitários para a Classe CalculadorComposicao.
 */
package calculadorcomposicao;

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
    public void testCalculadorComposicao() {
        fail("Nada a testar ainda.");
    }
}
