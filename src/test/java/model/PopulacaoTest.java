package model;

import com.genetico.model.Cromossomo;
import com.genetico.model.Populacao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulacaoTest {

    @Test
    @DisplayName("Tamanho da população deve ser inicializado corretamente")
    public void tamanhoDaPopulacaoDeveSerInicializadoCorretamente() {
        var populacao = new Populacao();

        assertEquals(Populacao.TAMANHO_POPULACAO, populacao.getCromossomos().size());
    }

    @Test
    @DisplayName(value = "deve ordenar os fitness dos cromossomos em ordem crescente")
    public void deveOrdenarOsFitnessDosCromossomosEmOrdemCrescente() {
        var genes1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        var genes2 = new int[]{0, 1, 2, 3, 4, 5, 7, 6, 8, 9};
        var genes3 = new int[]{0, 1, 2, 4, 3, 5, 6, 7, 8, 9};
        var genes4 = new int[]{0, 5, 4, 3, 2, 6, 7, 8, 1, 9};
        var genes5 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        var cromossomo1 = new Cromossomo(genes1);
        var cromossomo2 = new Cromossomo(genes2);
        var cromossomo3 = new Cromossomo(genes3);
        var cromossomo4 = new Cromossomo(genes4);
        var cromossomo5 = new Cromossomo(genes5);

        var cromossomos = new ArrayList<Cromossomo>();
        cromossomos.add(cromossomo1);
        cromossomos.add(cromossomo2);
        cromossomos.add(cromossomo3);
        cromossomos.add(cromossomo4);
        cromossomos.add(cromossomo5);

        var populacao = new Populacao(cromossomos);

        assertEquals(70, populacao.getCromossomos().get(0).getFitness());
        assertEquals(70, populacao.getCromossomos().get(1).getFitness());
        assertEquals(90, populacao.getCromossomos().get(2).getFitness());
        assertEquals(100, populacao.getCromossomos().get(3).getFitness());
        assertEquals(220, populacao.getCromossomos().get(4).getFitness());
    }
}
