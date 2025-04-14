package com.genetico.model;

import java.util.*;

public class Cromossomo {
    public static final int QTDE_MAXIMA_GENES = 10;
    public static final int GENE_ORIGEM = 0;

    private final char[] genes;
    private final int[][] distancias;
    private int fitness;

    public Cromossomo() {
        this.genes = inicializarGenes();
        this.distancias = inicializarDistancias();
        this.fitness = 0;
        this.fitness = calcularFitness();
    }

    public Cromossomo(char[] genes) {
        this.genes = genes;

        if (genes.length > QTDE_MAXIMA_GENES) {
            throw new IllegalArgumentException("A quantidade de genes não deve ultrapassar a capacidade máxima de: " + QTDE_MAXIMA_GENES);
        }

        distancias = inicializarDistancias();
        this.fitness = 0;
        this.fitness = calcularFitness();
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
        int[][] distancias = new int[Cromossomo.QTDE_MAXIMA_GENES][Cromossomo.QTDE_MAXIMA_GENES];

        distancias[0][0] = 10;
        distancias[0][1] = 10;
        distancias[0][2] = 20;
        distancias[0][3] = 30;
        distancias[0][4] = 40;
        distancias[0][5] = 50;
        distancias[0][6] = 60;
        distancias[0][7] = 70;
        distancias[0][8] = 80;
        distancias[0][9] = 90;

        distancias[1][0] = 15;
        distancias[1][2] = 15;
        distancias[1][3] = 25;
        distancias[1][4] = 35;
        distancias[1][5] = 45;
        distancias[1][6] = 55;
        distancias[1][7] = 65;
        distancias[1][8] = 75;
        distancias[1][9] = 85;

        distancias[2][0] = 10;
        distancias[2][1] = 10;
        distancias[2][2] = 10;
        distancias[2][4] = 20;
        distancias[2][5] = 30;
        distancias[2][6] = 40;
        distancias[2][7] = 50;
        distancias[2][8] = 60;
        distancias[2][9] = 70;

        distancias[3][0] = 5;
        distancias[3][1] = 5;
        distancias[3][2] = 5;
        distancias[3][3] = 5;
        distancias[3][4] = 5;
        distancias[3][5] = 15;
        distancias[3][6] = 25;
        distancias[3][7] = 35;
        distancias[3][8] = 45;
        distancias[3][9] = 55;

        distancias[4][0] = 10;
        distancias[4][1] = 10;
        distancias[4][2] = 10;
        distancias[4][3] = 10;
        distancias[4][4] = 10;
        distancias[4][5] = 10;
        distancias[4][6] = 20;
        distancias[4][7] = 30;
        distancias[4][8] = 40;
        distancias[4][9] = 50;

        distancias[5][0] = 5;
        distancias[5][1] = 5;
        distancias[5][2] = 5;
        distancias[5][3] = 5;
        distancias[5][4] = 5;
        distancias[5][5] = 5;
        distancias[5][6] = 5;
        distancias[5][7] = 15;
        distancias[5][8] = 25;
        distancias[5][9] = 35;

        distancias[6][0] = 10;
        distancias[6][1] = 10;
        distancias[6][2] = 10;
        distancias[6][3] = 10;
        distancias[6][4] = 10;
        distancias[6][5] = 10;
        distancias[6][6] = 10;
        distancias[6][7] = 10;
        distancias[6][8] = 20;
        distancias[6][9] = 30;

        distancias[7][0] = 5;
        distancias[7][1] = 5;
        distancias[7][2] = 5;
        distancias[7][3] = 5;
        distancias[7][4] = 5;
        distancias[7][5] = 5;
        distancias[7][6] = 5;
        distancias[7][7] = 5;
        distancias[7][8] = 5;
        distancias[7][9] = 15;

        distancias[8][0] = 10;
        distancias[8][1] = 10;
        distancias[8][2] = 10;
        distancias[8][3] = 10;
        distancias[8][4] = 10;
        distancias[8][5] = 10;
        distancias[8][6] = 10;
        distancias[8][7] = 10;
        distancias[8][8] = 10;
        distancias[8][9] = 10;

        distancias[9][0] = 10;
        distancias[9][1] = 10;
        distancias[9][2] = 10;
        distancias[9][3] = 10;
        distancias[9][4] = 10;
        distancias[9][5] = 10;
        distancias[9][6] = 10;
        distancias[9][7] = 10;
        distancias[9][8] = 10;
        distancias[9][9] = 10;

        return distancias;
    }

    private int calcularFitness() {
        var fitness = 0;

        for (int i = 0; i < genes.length - 1; i++) {
            var cidadeOrigem = Character.getNumericValue(genes[i]);
            var cidadeDestino = Character.getNumericValue(genes[i + 1]);

            fitness += distancias[cidadeOrigem][cidadeDestino];
        }

        return fitness;
    }

    public String imprimirGenes() {
        var stringJoiner = new StringJoiner(" | ");

        for (char gene : genes) stringJoiner.add(String.valueOf(gene));
        stringJoiner.add(String.valueOf(getFitness()));

        return stringJoiner.toString();
    }

    public char[] getGenes() {
        return this.genes;
    }

    public int getFitness() {
        return fitness;
    }
}
