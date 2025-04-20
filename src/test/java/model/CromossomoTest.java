package model;

import com.genetico.model.Cromossomo;
import com.genetico.model.Individuo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        String padraoImpressaoCromossomo = "^(\\d+\\s\\|\\s)*\\d+$";

        boolean impressaoCromossomoEstaNoPadrao = individuo
                .getCromosso()
                .imprimirGenes()
                .matches(padraoImpressaoCromossomo);

        assertTrue(impressaoCromossomoEstaNoPadrao);
    }

}
