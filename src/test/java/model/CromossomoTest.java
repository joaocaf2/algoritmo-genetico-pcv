package model;

import com.genetico.model.Cromossomo;
import com.genetico.model.Individuo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CromossomoTest {

    @Test
    @DisplayName("Valor do fitness  dve ser calculado corretamente")
    public void valorDoFitnessDeveSeCalculadoCorretamente() throws Exception {
        var cromossomo = new Cromossomo();

        char[] genesFixos = new char[Cromossomo.QTDE_MAXIMA_GENES];

        for (int i = 0; i < 10; i++) genesFixos[i] = (char) ('0' + i);

        var genes = Cromossomo.class.getDeclaredField("genes");
        genes.setAccessible(true);
        genes.set(cromossomo, genesFixos);

        var calcularFitness = Cromossomo.class.getDeclaredMethod("calcularFitness");
        calcularFitness.setAccessible(true);
        int fitness = (int) calcularFitness.invoke(cromossomo);

        assertEquals(70, fitness);
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
