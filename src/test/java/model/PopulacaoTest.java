package model;

import com.genetico.model.Populacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulacaoTest {

    @Test
    public void deveInicializarCorretamenteAPopulacao() {
        var populacao = new Populacao();

        assertEquals(Populacao.TAMANHO_POPULACAO, populacao.getCromossomos().size());
    }
}
