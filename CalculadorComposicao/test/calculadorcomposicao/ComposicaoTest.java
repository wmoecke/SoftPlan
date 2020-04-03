/*
 *
 * Classe de testes unitários para a Classe Composicao.
 */
package calculadorcomposicao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe Composicao
 * @author Werner
 */
public class ComposicaoTest {
    
    private Composicao instance = null;
    
    @Before
    public void setUp() {
        instance = new Composicao();
        assertNotNull(instance);
    }
    
    @After
    public void tearDown() {
        instance = null;
        assertNull(instance);
    }
    
}
