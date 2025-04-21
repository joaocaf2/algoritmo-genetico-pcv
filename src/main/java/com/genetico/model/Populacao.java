package com.genetico.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Populacao {
    private List<Cromossomo> cromossomos;
    public static final int TAMANHO_POPULACAO = 30;

    public Populacao() {
        this.cromossomos = new ArrayList<>();
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
        cromossomos.sort(Comparator.comparingInt(Cromossomo::getFitness));

        return new ArrayList<>(cromossomos);
    }

    public void imprimirPopulacao() {
        for (Cromossomo cromossomo : cromossomos) System.out.println(cromossomo.imprimirGenes());
    }

    public List<Cromossomo> getCromossomos() {
        return cromossomos;
    }
}
