package com.genetico.model;

import java.util.*;

public class Cromossomo {
    public static final int QTDE_MAXIMA_GENES = 10;
    public static final int GENE_ORIGEM = 0;

    private final char[] genes;

    public Cromossomo() {
        genes = new char[QTDE_MAXIMA_GENES];
        inicializarGenes();
    }

    public char[] getGenes() {
        return this.genes;
    }

    public String imprimirGenes() {
        StringJoiner stringJoiner = new StringJoiner(" | ");

        for (char gene : genes) stringJoiner.add(String.valueOf(gene));

        return stringJoiner.toString();
    }

    private void inicializarGenes() {
        List<String> cidades = new ArrayList<>();

        for (int i = 1; i < genes.length; i++) cidades.add(String.valueOf(i));

        Collections.shuffle(cidades);

        genes[GENE_ORIGEM] = '0';

        for (int i = 1; i < genes.length; i++) genes[i] = cidades.get(i - 1).charAt(0);
    }

}
