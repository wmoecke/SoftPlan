/*
 *
 * Classe de testes unitários para a Classe GeradorObservacaoCliente.
 */
package geradorobservacao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe GeradorObservacaoCliente
 * @author Werner
 */
public class GeradorObservacaoClienteTest {
    
    private GeradorObservacaoCliente instance = null;
    
    @Before
    public void setUp() {
        instance = new GeradorObservacaoCliente();
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
        List<Pair<Integer, Double>> lista = null;
        String expResult = "";
        String result = instance.achaSeparador(lista);
        assertEquals(expResult, result);
    }

    //A seguir, testamos com uma lista vazia
    @Test
    public void testAchaSeparadorListaVazia() {
        System.out.println("achaSeparadorListaVazia()");
        List<Pair<Integer, Double>> lista = Collections.emptyList();
        String expResult = "";
        String result = instance.achaSeparador(lista);
        assertEquals(expResult, result);
    }

    @Test
    public void testAchaSeparadorUmaNota() {
        System.out.println("achaSeparadorUmaNota():");
        List<Pair<Integer, Double>> lista;
        lista = Arrays.asList(
                new Pair<Integer, Double>(1, 10.0)
            );
        String expResult = "1 cujo valor é R$ 10,00. Total = R$ 10,00";
        String result = instance.achaSeparador(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }

    @Test
    public void testGeraObservacaoUmaNota() {
        System.out.println("geraObservacaoUmaNota():");
        List<Pair<Integer, Double>> lista;
        lista = Arrays.asList(
                new Pair<Integer, Double>(1, 10.0)
            );
        String expResult = "Fatura da nota fiscal de simples remessa: "
                + "1 cujo valor é R$ 10,00. Total = R$ 10,00.";
        String result = instance.geraObservacao(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAchaSeparadorVariasNotas() {
        System.out.println("achaSeparadorVariasNotas():");
        List<Pair<Integer, Double>> lista = Arrays.asList(
                new Pair<Integer, Double>(1, 10.0), 
                new Pair<Integer, Double>(2, 35.0), 
                new Pair<Integer, Double>(3, 5.0), 
                new Pair<Integer, Double>(4, 1500.0), 
                new Pair<Integer, Double>(5, 0.3)
            );
        String expResult = ""
                + "1 cujo valor é R$ 10,00, "
                + "2 cujo valor é R$ 35,00, "
                + "3 cujo valor é R$ 5,00, "
                + "4 cujo valor é R$ 1.500,00 e "
                + "5 cujo valor é R$ 0,30. Total = R$ 1.550,30";
        String result = instance.achaSeparador(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }

    @Test
    public void testGeraObservacaoVariasNotas() {
        System.out.println("geraObservacaoVariasNotas():");
        List<Pair<Integer, Double>> lista = Arrays.asList(
                new Pair<Integer, Double>(1, 10.0), 
                new Pair<Integer, Double>(2, 35.0), 
                new Pair<Integer, Double>(3, 5.0), 
                new Pair<Integer, Double>(4, 1500.0), 
                new Pair<Integer, Double>(5, 0.3)
            );
        String expResult = "Fatura das notas fiscais de simples remessa: "
                + "1 cujo valor é R$ 10,00, "
                + "2 cujo valor é R$ 35,00, "
                + "3 cujo valor é R$ 5,00, "
                + "4 cujo valor é R$ 1.500,00 e "
                + "5 cujo valor é R$ 0,30. Total = R$ 1.550,30.";
        String result = instance.geraObservacao(lista);
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
}
