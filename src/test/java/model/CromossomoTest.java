package model;

import com.genetico.model.Cromossomo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CromossomoTest {

    @Test
    public void deveCalcularOFitnessCorretamente() throws Exception {
        var cromossomo = new Cromossomo();

        char[] genesFixos = new char[Cromossomo.QTDE_MAXIMA_GENES];

        for (int i = 0; i < 10; i++) genesFixos[i] = (char) ('0' + i);

        var genes = Cromossomo.class.getDeclaredField("genes");
        genes.setAccessible(true);
        genes.set(cromossomo, genesFixos);

        var calcularFitness = Cromossomo.class.getDeclaredMethod("calcularFitness");
        calcularFitness.setAccessible(true);
        int fitness = (int) calcularFitness.invoke(cromossomo);

        assertEquals(80, fitness);
    }

}
