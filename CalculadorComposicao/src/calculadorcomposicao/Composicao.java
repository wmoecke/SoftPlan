/**
 *
 * Classe Composicao
 */
package calculadorcomposicao;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Werner
 */
class Composicao implements CalculadorComposicaoInterface {
    private final Long codigoComposicao;
    private final String descricaoComposicao;
    private final String unidadeComposicao;
    private final String tipoItem;
    private final Long codigoItem;
    private final String descricaoItemComposicao;
    private final String unidadeItem;
    private final Double quantidadeComposicao;
    private Double valorUnitario;

    /**
     * Código Composicao
     */
    public Long getCodigoComposicao() {
        return this.codigoComposicao;
    }

    /**
     * Descrição Composicao
     */
    public String getDescricaoComposicao() {
        return this.descricaoComposicao;
    }
    
    /**
     * Unidade Composicao
     */
    public String getUnidadeComposicao() {
        return this.unidadeComposicao;
    }
    
    /**
     * Tipo Item
     */
    public String getTipoItem() {
        return this.tipoItem;
    }

    /**
     * Código Item
     */
    public Long getCodigoItem() {
        return this.codigoItem;
    }

    /**
     * Descrição Item Composição
     */
    public String getDescricaoItemComposicao() {
        return this.descricaoItemComposicao;
    }

    /**
     * Unidade Item
     */
    public String getUnidadeItem() {
        return this.unidadeItem;
    }
    
    /**
     * Quantidade Composição
     */
    public Double getQuantidadeComposicao() {
        return this.quantidadeComposicao;
    }
    
    /**
     * Valor Unitário
     */
    public Double getValorUnitario() {
        return this.valorUnitario;
    }
    public void setValorUnitario(Double valor) {
        this.valorUnitario = valor;
    }
    
    /**
     * @return Double Valor Unitário * Quantidade
     */
    public Double getValorComposicao() {
        return this.valorUnitario * this.quantidadeComposicao;
    }
    
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
        this.quantidadeComposicao = 0d;
        this.valorUnitario = 0d;
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
            Double qtdeCom,
            Double vlrUn
        ) 
    {
        this.codigoComposicao = codCom;
        this.descricaoComposicao = desCom;
        this.unidadeComposicao = unCom;
        this.tipoItem = tpItem;
        this.codigoItem = codItem;
        this.descricaoItemComposicao = desItCom;
        this.unidadeItem = unItem;
        this.quantidadeComposicao = qtdeCom == null ? 0d : qtdeCom;
        this.valorUnitario =  vlrUn == null ? 0d : vlrUn;
    }

    @Override
    public String toString() { 
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("%s ", this.codigoComposicao.toString()));
        ret.append(String.format("%s ", this.descricaoComposicao));
        ret.append(String.format("%s ", this.unidadeComposicao));
        ret.append(String.format("%s", df.format(this.valorUnitario)));
        return ret.toString();
    }
}
