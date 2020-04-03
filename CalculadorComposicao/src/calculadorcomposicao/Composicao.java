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
    Double valorUnitario;
    
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
