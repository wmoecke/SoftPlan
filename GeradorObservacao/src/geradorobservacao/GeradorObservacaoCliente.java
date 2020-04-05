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
        implements GeradorObservacaoInterface
{
    //Textos prÚ-definidos
    static final String umoNota = "Fatura da nota fiscal de simples remessa: ";
    //Identificador da entidade
    String texto;

    //Gera observaþ§es, com texto pre-definido, incluindo os n·meros e valores, das notas fiscais, recebidos no parÔmetro
    public String geraObservacao(List lista) 
    {
        texto = "";
        if (!lista.isEmpty()) 
        {
            return retornaCodigos(lista) + ".";
        }		
        return "";		
    }

    //Cria observaþÒo
    public String retornaCodigos(List lista) {
        if (lista.size() >= 2) {
            texto = "Fatura das notas fiscais de simples remessa: ";
        } else {
            texto = umoNota;
        }

        return texto + achaSeparador(lista);
    }
    
    //Acha separador, incluindo o total dos valores das notas fiscais, recebidas no parÔmetro
    @Override
    public String achaSeparador(List lista) {
        if (lista == null || lista.isEmpty())
            return "";
        
        StringBuilder cod = new StringBuilder();
        NumberFormat n = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        Double t = 0.0;
        for (Iterator<Pair<Integer, Double>> iterator = lista.iterator(); iterator.hasNext();) {
            Pair<Integer, Double> next = iterator.next();
            Integer c = next.getKey();
            Double v = next.getValue();
            String vs = String.format(" cujo valor é %s", n.format(v));
            String s = "";
            if( cod.toString() == null || cod.toString().length() <= 0 )
                s =  "";
            else if( iterator.hasNext() )
                s =  ", ";
            else
                s =  " e ";

            cod.append(s + c + vs);
            t += v;
        }
        String tot = String.format(". Total = %s", n.format(t));
        return cod + tot;
    }
}
