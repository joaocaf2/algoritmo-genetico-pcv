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
        var cromossomo = new Cromossomo(inicializarValoresGenesFixos());

        assertEquals(70, cromossomo.getFitness());
    }

    private int[] inicializarValoresGenesFixos() {
        var genesFixos = new int[Cromossomo.QTDE_MAXIMA_GENES];

        for (int indice = 0; indice < genesFixos.length; indice++) {
            genesFixos[indice] = indice;
        }

        return genesFixos;
    }

    @Test
    @DisplayName(value = "Genes devem ser inicializados com o tamanho correto definido na constante")
    public void genesDevemSerInicializadosComOTamanhoCorreto() {
        assertEquals(Cromossomo.QTDE_MAXIMA_GENES, new Individuo().getCromosso().getGenes().length);
    }

    @Test
    @DisplayName(value = "Genes devem ser formatados corretamente com caracter delimitador: |")
    public void genesDevemSerFormatadosCorretamenteAoImprimir() {
        var individuo = new Individuo();
        var genes = individuo.getCromosso().getGenes();

        var cromossomoFormatado = new StringJoiner(" | ");

        for (int gene : genes) cromossomoFormatado.add(String.valueOf(gene));
        cromossomoFormatado.add(String.valueOf(individuo.getCromosso().getFitness()));

        assertEquals(cromossomoFormatado.toString(), individuo.getCromosso().imprimirGenes());
    }

}
