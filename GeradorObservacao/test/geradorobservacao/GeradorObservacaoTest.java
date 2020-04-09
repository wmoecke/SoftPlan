/*
 *
 * Classe de testes unitários para a Classe GeradorObservacao.
 */
package geradorobservacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe GeradorObservacao
 * @author Werner
 */
public class GeradorObservacaoTest {
    
    private GeradorObservacao instance = null;
    
    @Before
    public void setUp() {
        instance = new GeradorObservacao();
        assertNotNull(instance);
    }
    
    @After
    public void tearDown() {
        instance = null;
        assertNull(instance);
    }
    
    //Primeiro testamos com uma lista não inicializada
    @Test
    public void testAchaSeparadorListaNula() {
        System.out.println("achaSeparadorListaNula()");
        List<Integer> lista = null;
        String expResult = "";
        String result = instance.achaSeparador(lista);
        assertEquals(expResult, result);
    }

    //A seguir, testamos com uma lista vazia
    @Test
    public void testAchaSeparadorListaVazia() {
        System.out.println("achaSeparadorListaVazia()");
        List<Integer> lista = Collections.emptyList();
        String expResult = "";
        String result = instance.achaSeparador(lista);
        assertEquals(expResult, result);
    }

    @Test
    public void testAchaSeparadorUmaNota() {
        System.out.println("achaSeparadorUmaNota():");
        List lista = Arrays.asList(1);
        String expResult = "1";
        String result = instance.achaSeparador(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }

    @Test
    public void testGeraObservacaoUmaNota() {
        System.out.println("geraObservacaoUmaNota():");
        List lista = Arrays.asList(1);
        String expResult = "Fatura da nota fiscal de simples remessa: 1.";
        String result = instance.geraObservacao(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAchaSeparadorVariasNotas() {
        System.out.println("achaSeparadorVariasNotas():");
        List lista = Arrays.asList(1, 2, 3, 4, 5);
        String expResult = "1, 2, 3, 4 e 5";
        String result = instance.achaSeparador(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }

    @Test
    public void testGeraObservacaoVariasNotas() {
        System.out.println("geraObservacaoVariasNotas():");
        List lista = Arrays.asList(1, 2, 3, 4, 5);
        String expResult = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";
        String result = instance.geraObservacao(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
}
