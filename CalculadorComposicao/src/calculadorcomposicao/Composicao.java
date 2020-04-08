/**
 *
 * Classe Composicao
 */
package calculadorcomposicao;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Werner
 */
class Composicao {
    private Long codigoComposicao;
    private String descricaoComposicao;
    private String unidadeComposicao;
    private final String tipoItem;
    private final Long codigoItem;
    private final String descricaoItemComposicao;
    private final String unidadeItem;
    private final String quantidadeComposicao;
    private String valorUnitario;

    /**
     * Código Composicao
     */
    public Long getCodigoComposicao() {
        return this.codigoComposicao;
    }
//    public void setCodigoComposicao(Long valor) {
//        this.codigoComposicao = valor;
//    }

    /**
     * Descrição Composicao
     */
    public String getDescricaoComposicao() {
        return this.descricaoComposicao;
    }
//    public void setDescricaoComposicao(String valor) {
//        this.descricaoComposicao = valor;
//    }
    
    /**
     * Unidade Composicao
     */
    public String getUnidadeComposicao() {
        return this.unidadeComposicao;
    }
//    public void setUnidadeComposicao(String valor) {
//        this.unidadeComposicao = valor;
//    }
    
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
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        try {
            return (Double) df.parse(this.quantidadeComposicao).doubleValue();
        } catch (ParseException ex) {
            return 0d;
        }
    }
    
    /**
     * Valor Unitário
     */
    public Double getValorUnitario() {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        try {
            return (Double) df.parse(this.valorUnitario).doubleValue();
        } catch (ParseException ex) {
            return 0d;
        }
    }
    public void setValorUnitario(Double valor) {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        this.valorUnitario = df.format(valor);
    }
    
    /**
     * @return Double Valor Unitário * Quantidade
     */
    public Double getValorComposicao() {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        Double v, q;
        try {
            v = (Double) df.parse(this.valorUnitario).doubleValue();
            q = (Double) df.parse(this.quantidadeComposicao).doubleValue();
            return v * q;
        } catch (ParseException ex) {
            return 0d;
        }
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
        this.quantidadeComposicao = "0";
        this.valorUnitario = "0";
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
        this.quantidadeComposicao = (qtdeCom == null || qtdeCom.trim().isEmpty()) ? "0" : qtdeCom;
        this.valorUnitario = (vlrUn == null || vlrUn.trim().isEmpty()) ? "0" : vlrUn;
    }

    @Override
    public String toString() { 
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("%s ", this.codigoComposicao.toString()));
        ret.append(String.format("%s ", this.descricaoComposicao));
        ret.append(String.format("%s ", this.unidadeComposicao));
        ret.append(String.format("%s", this.valorUnitario));
        return ret.toString();
    }
}
