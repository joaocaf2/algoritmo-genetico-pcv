package com.genetico.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Populacao {
    private List<Cromossomo> cromossomos;
    public static final int TAMANHO_POPULACAO = 30;

    public Populacao() {
        this.cromossomos = avaliarPopulacao(iniciarPopulacaoAleatoriamente());
    }

    public Populacao(List<Cromossomo> cromossomos) {
        this.cromossomos = avaliarPopulacao(cromossomos);
    }

    private List<Cromossomo> iniciarPopulacaoAleatoriamente() {
        var cromossomos = new ArrayList<Cromossomo>();

        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            Cromossomo cromossomo = new Cromossomo();

            cromossomos.add(cromossomo);
        }

        return cromossomos;
    }

    private List<Cromossomo> avaliarPopulacao(List<Cromossomo> cromossomos) {
        var cromossomoOrdenado = new ArrayList<>(cromossomos);

        cromossomoOrdenado.sort(Comparator.comparingInt(Cromossomo::getFitness));

        return cromossomoOrdenado;
    }

    public void imprimirPopulacao() {
        for (Cromossomo cromossomo : cromossomos) System.out.println(cromossomo.imprimirGenes());
    }

    public void reproduzir() {
        var random = new Random();

        var indiceAleatorio1 = random.nextInt(TAMANHO_POPULACAO);
        var indiceAleatorio2 = random.nextInt(TAMANHO_POPULACAO);

        var pai1 = cromossomos.get(indiceAleatorio1);
        var pai2 = cromossomos.get(indiceAleatorio2);

        var filhos = pai1.realizarCrossoverPmx(pai2, new Random());

        var filho1 = filhos.getFirst();
        var filho2 = filhos.getLast();

        System.out.println(filho1.imprimirGenes());
        System.out.println(filho2.imprimirGenes());
    }

    public List<Cromossomo> getCromossomos() {
        return this.cromossomos;
    }
}
