/**
 *
 * Classe CalculadorComposicao
 */
package calculadorcomposicao;

/**
 *
 * @author Werner
 */
public class CalculadorComposicao {
           
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "src/calculadorcomposicao/entrada.json";
        Helpers.populaLista(Helpers.leArquivoEntrada(path));
        Helpers.totalizaItensComposicao();
        Helpers.agrupaItensPorComposicao().entrySet().stream().forEach((item) -> 
        {
            Composicao c = Helpers.buscaComposicao(item);
            if (c != null) {
                c.setValorUnitario(item.getValue());
                System.out.println(c.toString());
            }
        });
    }
}