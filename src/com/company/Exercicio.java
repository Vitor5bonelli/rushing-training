package com.company;

import com.company.interfaces.Entidade;

public class Exercicio implements Entidade<String> {
    final private String NOME;
    private String aparelho;
    //private Image image = new Image(new FileInputStream("path of the image"));
    //implementar somente quando junto a interface
    private int pesoMin;
    private int pesoMax;

    public Exercicio(String nome, String aparelho, int pesoMin, int pesoMax) {
        this.NOME = nome;
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    public void editarExercicio(String aparelho, int pesoMin, int pesoMax) {
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    public String getNOME() {
        return NOME;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "nome='" + NOME + '\'' +
                ", aparelho='" + aparelho + '\'' +
                ", pesoMin=" + pesoMin +
                ", pesoMax=" + pesoMax +
                '}';
    }

    @Override
    public String getId() {
        return NOME;
    }
}
