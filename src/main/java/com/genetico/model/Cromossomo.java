package com.genetico.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cromossomo {
    public static final int QTDE_MAXIMA_GENES = 10;

    private final int[] genes;

    public Cromossomo() {
        genes = new int[QTDE_MAXIMA_GENES];
        inicializarGenes();
    }

    public void imprimirGenes() {
        System.out.println(String.join(" | ", Arrays.toString(genes)));
    }

    private void inicializarGenes() {
        List<Integer> cidades = new ArrayList<>();

        for (int i = 1; i < genes.length; i++) {
            cidades.add(i);
        }

        Collections.shuffle(cidades);

        genes[0] = 0;

        for (int i = 1; i < genes.length; i++) {
            genes[i] = cidades.get(i - 1);
        }
    }

}
