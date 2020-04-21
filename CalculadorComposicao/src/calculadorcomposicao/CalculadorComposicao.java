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
        Helpers helpers = new Helpers();
        String path = "src/calculadorcomposicao/entrada.json";
        helpers.populaLista(helpers.leArquivoEntrada(path));
        helpers.totalizaItensComposicao();
        helpers.agrupaItensPorComposicao().entrySet().stream().forEach((item) -> 
        {
            Composicao c = helpers.buscaComposicao(item);
            if (c != null) {
                c.setValorUnitario(item.getValue());
                System.out.println(c.toString());
            }
        });
    }
}