/**
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
 * @author Werner
 */
public class ComposicaoTest {
    
    private Composicao instance = null;
    
    @Before
    public void setUp() {
        instance = new Composicao(
                94793L,
                "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016",
                "UN",
                "INSUMO",
                3148L,
                "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)",
                "UN",
                0.0190000,
                9.4
            );
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Teste do método getCodigoComposicao, da classe Composicao.
     */
    @Test
    public void testGetCodigoComposicao() {
        System.out.println("getCodigoComposicao()");
        Long expResult = 94793L;
        Long result = instance.getCodigoComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getDescricaoComposicao, da classe Composicao.
     */
    @Test
    public void testGetDescricaoComposicao() {
        System.out.println("getDescricaoComposicao()");
        String expResult = "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016";
        String result = instance.getDescricaoComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUnidadeComposicao, da classe Composicao.
     */
    @Test
    public void testGetUnidadeComposicao() {
        System.out.println("getUnidadeComposicao()");
        String expResult = "UN";
        String result = instance.getUnidadeComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getTipoItem, da classe Composicao.
     */
    @Test
    public void testGetTipoItem() {
        System.out.println("getTipoItem()");
        String expResult = "INSUMO";
        String result = instance.getTipoItem();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getCodigoItem, da classe Composicao.
     */
    @Test
    public void testGetCodigoItem() {
        System.out.println("getCodigoItem()");
        Long expResult = 3148L;
        Long result = instance.getCodigoItem();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getDescricaoItemComposicao, da classe Composicao.
     */
    @Test
    public void testGetDescricaoItemComposicao() {
        System.out.println("getDescricaoItemComposicao()");
        String expResult = "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)";
        String result = instance.getDescricaoItemComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getUnidadeItem, da classe Composicao.
     */
    @Test
    public void testGetUnidadeItem() {
        System.out.println("getUnidadeItem()");
        String expResult = "UN";
        String result = instance.getUnidadeItem();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getQuantidadeComposicao, da classe Composicao.
     */
    @Test
    public void testGetQuantidadeComposicao() {
        System.out.println("getQuantidadeComposicao()");
        Double expResult = 0.019;
        Double result = instance.getQuantidadeComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getValorUnitario, da classe Composicao.
     */
    @Test
    public void testGetValorUnitario() {
        System.out.println("getValorUnitario");
        Double expResult = 9.4;
        Double result = instance.getValorUnitario();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método setValorUnitario, da classe Composicao.
     */
    @Test
    public void testSetValorUnitario() {
        System.out.println("setValorUnitario()");
        Double valor = 1.5, expResult = 1.5;
        instance.setValorUnitario(valor);
        Double result = instance.getValorUnitario();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método getValorComposicao, da classe Composicao.
     */
    @Test
    public void testGetValorComposicao() {
        System.out.println("getValorComposicao()");
        instance.setValorUnitario(9.4);
        Double expResult = 0.1786;
        Double result = instance.getValorComposicao();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método toString, da classe Composicao.
     */
    @Test
    public void testToString() {
        System.out.println("toString()");
        String expResult = "94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016 UN 9,40";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
