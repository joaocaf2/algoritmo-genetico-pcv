package model;

import com.genetico.model.Populacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulacaoTest {

    @Test
    @DisplayName("Tamanho da população deve ser inicializado corretamente")
    public void tamanhoDaPopulacaoDeveSerInicializadoCorretamente() {
        var populacao = new Populacao();

        assertEquals(Populacao.TAMANHO_POPULACAO, populacao.getCromossomos().size());
    }
}
