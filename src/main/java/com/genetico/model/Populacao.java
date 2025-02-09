package com.genetico.model;

import java.util.ArrayList;
import java.util.List;

public class Populacao {
    List<Cromossomo> cromossomos;
    public static final int TAMANHO_POPULACAO = 50;

    public Populacao(){
        this.cromossomos = new ArrayList<>();
        iniciarPopulacao();
    }

    private void iniciarPopulacao(){
        for (int i = 0; i < TAMANHO_POPULACAO; i++) {
            Cromossomo cromossomo = new Cromossomo();

            cromossomos.add(cromossomo);
        }
    }

    public void imprimirPopulacao(){
        for(Cromossomo cromossomo: cromossomos){
            System.out.println(cromossomo.imprimirGenes());
        }

    }

    public List<Cromossomo> getCromossomos() {
        return cromossomos;
    }
}
