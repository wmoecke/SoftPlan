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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * Testes unitários da classe CalculadorComposicao
 * @author Werner
 */
public class CalculadorComposicaoTest {
    
    @Test
    public void testLeArquivoEntrada() {
        System.out.println("testLeArquivoEntrada():");
        JSONArray entrada = CalculadorComposicao.leArquivoEntrada("entrada.json");
        assertNotNull(entrada);
        assertTrue(!entrada.isEmpty());
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
        JSONArray entrada = CalculadorComposicao.leArquivoEntrada("entrada.json");
        ArrayList<Composicao> result = new ArrayList<>();
        for (Iterator<JSONObject> iterator = entrada.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao composicao = CalculadorComposicao.criaComposicao(next);
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
        JSONArray insumosTeste = CalculadorComposicao.leArquivoEntrada("insumosTeste.json");
        ArrayList<Composicao> expResult = new ArrayList<>();
        for (Iterator<JSONObject> iterator = insumosTeste.iterator(); iterator.hasNext();)
        {
            JSONObject next = iterator.next();
            Composicao composicao = CalculadorComposicao.criaComposicao(next);
            expResult.add(composicao);
        }
        Composicao c = new Composicao(
                98561L,
                "IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE "
                        + "CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, "
                        + "E = 2CM. AF_06/2018",
                "M2",
                "COMPOSICAO",
                87286L,
                "ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA "
                        + "EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE "
                        + "VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. "
                        + "AF_06/2014",
                "M3",
                "0,0250000",
                "0"
        );
        Collections.sort(CalculadorComposicao.getLista(), new OrdenaPorCodigoComposicaoAsc());
        ArrayList<Composicao> result = CalculadorComposicao.buscaInsumos(c);
        //assertEquals(expResult, result);
        System.out.println();
    }
    
    @Test
    public void testCalculaValorUnitario() {
        System.out.println("testCalculaValorUnitario():");
        //assertNotNull(CalculadorComposicao.calculaValorUnitario());
        CalculadorComposicao.populaLista(CalculadorComposicao.leArquivoEntrada("entrada.json"));
        CalculadorComposicao.calculaValorUnitario();
//        Collections.sort(CalculadorComposicao.getLista(), new OrdenaPorCodigoComposicaoAsc());
//        for (Composicao next : CalculadorComposicao.getLista()) {
//            System.out.println("------------------------------");
//            DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
//            Double vt;
//            try {
//                vt = (Double) df.parse(next.getValorUnitario()).doubleValue();
//            } catch (ParseException ex) {
//                vt = 0d;
//            }
//            ArrayList<Composicao> insumos = CalculadorComposicao.buscaInsumos(next);
//            if(!insumos.isEmpty()) {
//                for (Composicao insumo : insumos) {
//                    Double v, q;
//                    try {
//                        v = (Double) df.parse(insumo.getValorUnitario()).doubleValue();
//                        q = (Double) df.parse(insumo.quantidadeComposicao).doubleValue();
//                    } catch (Exception e) {
//                        v = 0d;
//                        q = 0d;
//                    }
//                    vt += v * q;
//                }
//            }
//            next.setValorUnitario(df.format(vt));
//            System.out.print(next.toString());
//        }
//        System.out.println("--------------FIM-------------\n");
    }
}
