/*
 *
 * Classe Composicao
 */
package calculadorcomposicao;

/**
 *
 * @author Werner
 */
class Composicao {
    Integer codigoComposicao;
    String descricaoComposicao;
    String unidadeComposicao;
    String tipoItem;
    Integer codigoItem;
    String descricaoItemComposicao;
    String unidadeItem;
    Double quantidadeComposicao;
    Float valorUnitario;
    
    Composicao() {
        codigoComposicao = 0;
        descricaoComposicao = "";
        unidadeComposicao = "";
        tipoItem = "";
        codigoItem = 0;
        descricaoItemComposicao = "";
        unidadeItem = "";
        quantidadeComposicao = 0.0;
        valorUnitario = 0.0f;
    }
}
