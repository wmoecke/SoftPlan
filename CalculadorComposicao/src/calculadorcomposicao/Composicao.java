/**
 *
 * Classe Composicao
 */
package calculadorcomposicao;

/**
 *
 * @author Werner
 */
class Composicao {
    final Long codigoComposicao;
    final String descricaoComposicao;
    final String unidadeComposicao;
    final String tipoItem;
    final Long codigoItem;
    final String descricaoItemComposicao;
    final String unidadeItem;
    final String quantidadeComposicao;
    final String valorUnitario;
    
    /**
     *
     * Inicializa a classe com valores "default".
     */
    Composicao() {
        this.codigoComposicao = 0L;
        this.descricaoComposicao = "";
        this.unidadeComposicao = "";
        this.tipoItem = "";
        this.codigoItem = 0L;
        this.descricaoItemComposicao = "";
        this.unidadeItem = "";
        this.quantidadeComposicao = "";
        this.valorUnitario = "";
    }
    
    /**
     *
     * Inicializa a classe com os valores fornecidos como parâmetro.
     */
    Composicao(
            Long codCom,
            String desCom,
            String unCom,
            String tpItem,
            Long codItem,
            String desItCom,
            String unItem,
            String qtdeCom,
            String vlrUn
        ) 
    {
        this.codigoComposicao = codCom;
        this.descricaoComposicao = desCom;
        this.unidadeComposicao = unCom;
        this.tipoItem = tpItem;
        this.codigoItem = codItem;
        this.descricaoItemComposicao = desItCom;
        this.unidadeItem = unItem;
        this.quantidadeComposicao = qtdeCom;
        this.valorUnitario = vlrUn;
    }

    @Override
    public String toString() { 
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("codigoComposicao: %s\n", this.codigoComposicao.toString()));
        ret.append(String.format("descricaoComposicao: %s\n", this.descricaoComposicao));
        ret.append(String.format("unidadeComposicao: %s\n", this.unidadeComposicao));
        ret.append(String.format("tipoItem: %s\n", this.tipoItem));
        ret.append(String.format("codigoItem: %s\n", this.codigoItem.toString()));
        ret.append(String.format("descricaoItemComposicao: %s\n", this.descricaoItemComposicao));
        ret.append(String.format("unidadeItem: %s\n", this.unidadeItem));
        ret.append(String.format("quantidadeComposicao: %s\n", this.quantidadeComposicao));
        ret.append(String.format("valorUnitario: %s\n", (this.valorUnitario == null || this.valorUnitario.trim().isEmpty()) ? "0" : this.valorUnitario));
        
        return ret.toString();
    }
}
