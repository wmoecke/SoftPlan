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
    private final Long codigoComposicao;
    private final String descricaoComposicao;
    private final String unidadeComposicao;
    private final String tipoItem;
    private final Long codigoItem;
    private final String descricaoItemComposicao;
    private final String unidadeItem;
    private String quantidadeComposicao;
    private String valorUnitario;

    /**
     * @return String Código Composicao
     */
    public Long getCodigoComposicao() {
        return this.codigoComposicao;
    }

    /**
     * @return String Descrição Composicao
     */
    public String getDescricaoComposicao() {
        return this.descricaoComposicao;
    }

    /**
     * @return String Unidade Composicao
     */
    public String getUnidadeComposicao() {
        return this.unidadeComposicao;
    }

    /**
     * @return String Tipo Item
     */
    public String getTipoItem() {
        return this.tipoItem;
    }

    /**
     * @return String Código Item
     */
    public Long getCodigoItem() {
        return this.codigoItem;
    }

    /**
     * @return String Descrição Item Composição
     */
    public String getDescricaoItemComposicao() {
        return this.descricaoItemComposicao;
    }

    /**
     * @return String Unidade Item
     */
    public String getUnidadeItem() {
        return this.unidadeItem;
    }
    
    /**
     * @return String Quantidade Composição
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
     * @param valorUnitario a Quantidade Composicao a setar
     */
    public void setQuantidadeComposicao(String quantidadeComposicao) {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        this.quantidadeComposicao = df.format(quantidadeComposicao);
    }
    
    /**
     * @return String Valor Unitário
     */
    public Double getValorUnitario() {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        try {
            return (Double) df.parse(this.valorUnitario).doubleValue();
        } catch (ParseException ex) {
            return 0d;
        }
    }

    /**
     * @param valorUnitario o Valor Unitário a setar
     */
    public void setValorUnitario(Double valorUnitario) {
        DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        this.valorUnitario = df.format(valorUnitario);
    }
    
    /**
     * @return String Valor Unitário
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
        ret.append(String.format("codigoComposicao: %s\n", this.codigoComposicao.toString()));
        ret.append(String.format("descricaoComposicao: %s\n", this.descricaoComposicao));
        ret.append(String.format("unidadeComposicao: %s\n", this.unidadeComposicao));
        ret.append(String.format("tipoItem: %s\n", this.tipoItem));
        ret.append(String.format("codigoItem: %s\n", this.codigoItem.toString()));
        ret.append(String.format("descricaoItemComposicao: %s\n", this.descricaoItemComposicao));
        ret.append(String.format("unidadeItem: %s\n", this.unidadeItem));
        ret.append(String.format("quantidadeComposicao: %s\n", this.quantidadeComposicao));
        ret.append(String.format("valorUnitario: %s\n", this.valorUnitario));
        return ret.toString();
    }
}
