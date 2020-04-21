/*
 *
 * Classe GeradorObservacaoCliente
 */
package geradorobservacao;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javafx.util.Pair;

/**
 *
 * @author Werner
 */
public class GeradorObservacaoCliente 
        extends GeradorObservacao
{
    @Override
    public String achaSeparador(List lista) {
        if (lista == null || lista.isEmpty())
            return "";
        
        StringBuilder cod = new StringBuilder();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        Double t = 0.0;
        for (Iterator<Pair<Integer, Double>> iterator = lista.iterator(); iterator.hasNext();) {
            Pair<Integer, Double> next = iterator.next();
            Integer codigo = next.getKey();
            Double valor = next.getValue();
            String valorSeparado = String.format(" cujo valor é %s", nf.format(valor));
            String separador = "";
            if( cod.toString() == null || cod.toString().length() <= 0 )
                separador =  "";
            else if( iterator.hasNext() )
                separador =  ", ";
            else
                separador =  " e ";

            cod.append(separador + codigo + valorSeparado);
            t += valor;
        }
        String tot = String.format(". Total = %s", nf.format(t));
        return cod + tot;
    }
}
