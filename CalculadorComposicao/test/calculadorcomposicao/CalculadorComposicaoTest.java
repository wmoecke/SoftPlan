/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorcomposicao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Werner
 */
public class CalculadorComposicaoTest {
    
    /**
     * Teste do método main, da classe CalculadorComposicao.
     */
    @Test
    public void testMain() {
        String msg = "O método main() escreve o resultado na console e não retorna "
                + "valor algum; o mesmo chama os métodos da classe Helpers. Para "
                + "testar estes, favor verificar a classe HelpersTest.\n"
                + "Saída do método main():";
        System.out.println(msg);
        String[] args = null;
        CalculadorComposicao.main(args);
        assertTrue(true);
    }
    
}
