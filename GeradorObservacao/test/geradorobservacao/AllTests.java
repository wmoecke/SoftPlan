/*
 *
 * Classe de testes automatizados para as Classes
 * GeradorObservacao e GeradorObservacaoCliente.
 */
package geradorobservacao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * Suite de testes das classes de teste 
 * GeradorObservacaoTest e GeradorObservacaoClienteTest.
 * @author Werner
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({geradorobservacao.GeradorObservacaoTest.class, geradorobservacao.GeradorObservacaoClienteTest.class})
public class AllTests {
    
}
