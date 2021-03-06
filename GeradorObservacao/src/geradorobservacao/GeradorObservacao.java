/*
 *
 * Classe GeradorObservacao
 */
package geradorobservacao;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author SoftPlan
 */
public class GeradorObservacao 
        implements GeradorObservacaoInterface
{
    //Textos prÚ-definidos
    static final String umoNota = "Fatura da nota fiscal de simples remessa: ";
    //Identificador da entidade
    String texto;

    //Gera observaþ§es, com texto pre-definido, incluindo os n·meros, das notas fiscais, recebidos no parÔmetro
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
    
    @Override
    public String achaSeparador(List lista) {
        if (lista == null || lista.isEmpty())
            return "";
        
        StringBuilder cod = new StringBuilder();
        for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
            Integer codigo = iterator.next();
            String separador = "";
            if( cod.toString() == null || cod.toString().length() <= 0 )
                separador =  "";
            else if( iterator.hasNext() )
                separador =  ", ";
            else
                separador =  " e ";

            cod.append(separador + codigo);
        }
        return cod.toString();
    }
}
