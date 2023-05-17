package com.company.applicationFuncionario.entities;

import com.company.interfaces.Entidade;

public class Exercicio implements Entidade<String> {
    final private String nome;
    private String aparelho;
    /* private Image image = new Image(new FileInputStream("path of the image"));
        implementar somente quando junto a interface */
    private int pesoMin;
    private int pesoMax;

    public Exercicio(String nome, String aparelho, int pesoMin, int pesoMax) {
        this.nome = nome;
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    protected void editarExercicio(String aparelho, int pesoMin, int pesoMax) {
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    protected String getNOME() {
        return nome;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "nome='" + nome + '\'' +
                ", aparelho='" + aparelho + '\'' +
                ", pesoMin=" + pesoMin +
                ", pesoMax=" + pesoMax +
                '}';
    }

    @Override
    public String getId() {
        return nome;
    }
}
