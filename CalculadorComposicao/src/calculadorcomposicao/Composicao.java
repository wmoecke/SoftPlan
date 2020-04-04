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
    final Integer codigoComposicao;
    final String descricaoComposicao;
    final String unidadeComposicao;
    final String tipoItem;
    final Integer codigoItem;
    final String descricaoItemComposicao;
    final String unidadeItem;
    final Double quantidadeComposicao;
    Double valorUnitario;
    
    /**
     *
     * Inicializa a classe com valores "default".
     */
    Composicao() {
        codigoComposicao = 0;
        descricaoComposicao = "";
        unidadeComposicao = "";
        tipoItem = "";
        codigoItem = 0;
        descricaoItemComposicao = "";
        unidadeItem = "";
        quantidadeComposicao = 0.0;
        valorUnitario = 0.0;
    }
    
    /**
     *
     * Inicializa a classe com os valores fornecidos como parâmetro.
     */
    Composicao(
            Integer codCom,
            String desCom,
            String unCom,
            String tpItem,
            Integer codItem,
            String desItCom,
            String unItem,
            Double qtdeCom,
            Double vlrUn
        ) 
    {
        codigoComposicao = codCom;
        descricaoComposicao = desCom;
        unidadeComposicao = unCom;
        tipoItem = tpItem;
        codigoItem = codItem;
        descricaoItemComposicao = desItCom;
        unidadeItem = unItem;
        quantidadeComposicao = qtdeCom;
        valorUnitario = vlrUn;
    }
}
