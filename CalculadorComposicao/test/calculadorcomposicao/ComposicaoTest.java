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
    
    @Test
    public void testInicializaVazio() {
        System.out.println("testInicializaVazio():");
        instance = null;
        instance = new Composicao();
        String expResult = "'0', '', '', '', '0', '', '', '0', '0'";
        String result = String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'",
                instance.codigoComposicao.toString(),
                instance.descricaoComposicao,
                instance.unidadeComposicao,
                instance.tipoItem,
                instance.codigoItem.toString(),
                instance.descricaoItemComposicao,
                instance.unidadeItem,
                instance.quantidadeComposicao,
                instance.getValorUnitario()
        );
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInicializaComParametros() {
        System.out.println("testInicializaParametros():");
        instance = null;
        instance = new Composicao(
                94793L,
                "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, "
                        + "1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, "
                        + "INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO "
                        + "QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO "
                        + "FORNECIMENTO E INSTALAÇÃO. AF_06/2016",
                "UN",
                "INSUMO",
                3148L,
                "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)",
                "UN",
                "0,0190000",
                "9,40"
        );
        String expResult = "'94793',\n"
                + "'REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, "
                + "1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, "
                + "INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO "
                + "QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO "
                + "FORNECIMENTO E INSTALAÇÃO. AF_06/2016',\n"
                + "'UN',\n"
                + "'INSUMO',\n"
                + "'3148',\n"
                + "'FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)',\n"
                + "'UN',\n"
                + "'0,0190000',\n"
                + "'9,40'";
        String result = String.format("'%s',\n'%s',\n'%s',\n'%s',\n'%s',\n'%s',\n'%s',\n'%s',\n'%s'",
                instance.codigoComposicao.toString(),
                instance.descricaoComposicao,
                instance.unidadeComposicao,
                instance.tipoItem,
                instance.codigoItem.toString(),
                instance.descricaoItemComposicao,
                instance.unidadeItem,
                instance.quantidadeComposicao,
                instance.getValorUnitario()
        );
        System.out.println(result + '\n');
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString() {
        System.out.println("testToString():");
        instance = null;
        instance = new Composicao(
                94793L,
                "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, "
                        + "1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, "
                        + "INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO "
                        + "QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO "
                        + "FORNECIMENTO E INSTALAÇÃO. AF_06/2016",
                "UN",
                "INSUMO",
                3148L,
                "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)",
                "UN",
                "0,0190000",
                "9,40"
        );
        String expResult = "codigoComposicao: 94793\n"
                + "descricaoComposicao: REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, "
                        + "1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, "
                        + "INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO "
                        + "QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO "
                        + "FORNECIMENTO E INSTALAÇÃO. AF_06/2016\n"
                + "unidadeComposicao: UN\n"
                + "tipoItem: INSUMO\n"
                + "codigoItem: 3148\n"
                + "descricaoItemComposicao: FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)\n"
                + "unidadeItem: UN\n"
                + "quantidadeComposicao: 0,0190000\n"
                + "valorUnitario: 9,40\n";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }
}
