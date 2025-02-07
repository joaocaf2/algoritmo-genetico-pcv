package model;

import com.genetico.model.Cromossomo;
import com.genetico.model.Individuo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndividuoTest {

    @Test
    @DisplayName(value = "genes devem ser inicializados com o tamanho correto definido na constante")
    public void genesDevemSerInicializadosComOTamanhoCorreto() {
        var individuo = new Individuo();

        assertEquals(individuo.getCromosso().getGenes().length, Cromossomo.QTDE_MAXIMA_GENES);
    }

    @Test
    @DisplayName(value = "genes devem ser formatados corretamente com caracter delimitador: |")
    public void genesDevemSerFormatadosCorretamenteAoImprimir() {
        var individuo = new Individuo();
        var genes = individuo.getCromosso().getGenes();

        StringJoiner genesFormatadosComBarra = new StringJoiner(" | ");

        for (char gene : genes) genesFormatadosComBarra.add(String.valueOf(gene));

        assertEquals(genesFormatadosComBarra.toString(), individuo.getCromosso().imprimirGenes());
    }
}
