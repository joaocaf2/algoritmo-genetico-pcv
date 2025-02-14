package com.genetico.model;

import java.util.*;

public class Cromossomo {
    public static final int QTDE_MAXIMA_GENES = 10;
    public static final int GENE_ORIGEM = 0;

    private final char[] genes;
    private final int[][] distancias;

    private int fitness;

    public Cromossomo() {
        genes = inicializarGenes();
        distancias = inicializarDistancias();
        fitness = 0;
        fitness = calcularFitness();
    }

    private char[] inicializarGenes() {
        var genes = new char[QTDE_MAXIMA_GENES];

        List<String> cidades = new ArrayList<>();

        for (int i = 1; i < genes.length; i++) cidades.add(String.valueOf(i));

        Collections.shuffle(cidades);

        genes[GENE_ORIGEM] = '0';

        for (int i = 1; i < genes.length; i++) genes[i] = cidades.get(i - 1).charAt(0);

        return genes;
    }

    private int[][] inicializarDistancias() {
        Random rand = new Random();

        var distancias = new int[QTDE_MAXIMA_GENES][QTDE_MAXIMA_GENES];

        for (int casaAnterior = 0; casaAnterior < QTDE_MAXIMA_GENES; casaAnterior++) {

            for (int casadaFrente = casaAnterior + 1; casadaFrente < QTDE_MAXIMA_GENES; casadaFrente++) {
                int distanciaAleatoria = rand.nextInt(100) + 1;

                distancias[casaAnterior][casadaFrente] = distanciaAleatoria;
                distancias[casadaFrente][casaAnterior] = distanciaAleatoria;
            }
        }

        return distancias;
    }

    private int calcularFitness() {
        var fitness = 0;

        for (int i = 0; i < genes.length - 1; i++) {
            int cidadeAtual = Character.getNumericValue(genes[i]);
            int cidadeProxima = Character.getNumericValue(genes[i + 1]);
            fitness += distancias[cidadeAtual][cidadeProxima];
        }

        return fitness;
    }

    public char[] getGenes() {
        return this.genes;
    }

    public int getFitness() {
        return fitness;
    }

    public String imprimirGenes() {
        StringJoiner stringJoiner = new StringJoiner(" | ");

        for (char gene : genes) stringJoiner.add(String.valueOf(gene));

        return stringJoiner.toString();
    }

}
