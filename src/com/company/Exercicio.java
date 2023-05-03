package com.company;

import java.awt.*;

public class Exercicio {
    final private String nome;
    private String aparelho;
    //private Image image = new Image(new FileInputStream("path of the image"));
    //implementar somente quando junto a interface
    private int pesoMin;
    private int pesoMax;

    public Exercicio(String nome, String aparelho, int pesoMin, int pesoMax) {
        this.nome = nome;
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        ExercicioDAO exDAO = ExercicioDAO.getInstance();
        exDAO.insert(this);//adiciona automaticamente no ExercicioDAO
    }

    public void editarExercicio(String aparelho, int pesoMin, int pesoMax) {
        this.aparelho = aparelho;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    public String getNome() {
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
}
