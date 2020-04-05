/**
 *
 * Classe de testes automatizados para as Classes
 * CalculadorComposicao e Composicao
 */
package calculadorcomposicao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * Suite de testes das classes de teste 
 * CalculadorComposicaoTest e ComposicaoTest
 * @author Werner
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({calculadorcomposicao.ComposicaoTest.class, calculadorcomposicao.CalculadorComposicaoTest.class})
public class AllTests {
    
}
