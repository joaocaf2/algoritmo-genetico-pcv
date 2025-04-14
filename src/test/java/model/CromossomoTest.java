package model;

import com.genetico.model.Cromossomo;
import com.genetico.model.Individuo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CromossomoTest {

    @Test
    @DisplayName("Valor do fitness deve ser calculado corretamente")
    public void valorDoFitnessDeveSeCalculadoCorretamente() {
        var genesFixos = inicializarValoresGenesFixos();
        var cromossomo = new Cromossomo(genesFixos);

        assertEquals(70, cromossomo.getFitness());
    }

    private char[] inicializarValoresGenesFixos() {
        char[] genesFixos = new char[Cromossomo.QTDE_MAXIMA_GENES];

        genesFixos[0] = '0';
        genesFixos[1] = '1';
        genesFixos[2] = '2';
        genesFixos[3] = '3';
        genesFixos[4] = '4';
        genesFixos[5] = '5';
        genesFixos[6] = '6';
        genesFixos[7] = '7';
        genesFixos[8] = '8';
        genesFixos[9] = '9';

        return genesFixos;
    }

    @Test
    @DisplayName(value = "Genes devem ser inicializados com o tamanho correto definido na constante")
    public void genesDevemSerInicializadosComOTamanhoCorreto() {
        assertEquals(new Individuo().getCromosso().getGenes().length, Cromossomo.QTDE_MAXIMA_GENES);
    }

    @Test
    @DisplayName(value = "Genes devem ser formatados corretamente com caracter delimitador: |")
    public void genesDevemSerFormatadosCorretamenteAoImprimir() {
        var individuo = new Individuo();
        var genes = individuo.getCromosso().getGenes();

        var cromossomoFormatado = new StringJoiner(" | ");

        for (char gene : genes) cromossomoFormatado.add(String.valueOf(gene));
        cromossomoFormatado.add(String.valueOf(individuo.getCromosso().getFitness()));

        assertEquals(cromossomoFormatado.toString(), individuo.getCromosso().imprimirGenes());
    }

}
