package com.company.applicationFuncionario.entities;

import com.company.interfaces.Entidade;

import java.util.HashMap;
import java.util.Map;

public class Treino implements Entidade<String> {
    private final String nome;
    private String descricao;
    private final Map<String, Integer> exercicios = new HashMap<>();
    private int repeticaoTreino;//? nao entendi

    public Treino(String nome) { //falta parametro
        this.nome = nome;
    }

    public void inserirExercicio(String nomeExercicio, int repeticoes){
        exercicios.put(nomeExercicio, repeticoes);
    }

    public String getNome() {
        return nome;
    }

    public void excluirExercicio(String exercicio){
        exercicios.remove(exercicio);
    }

    public void mudarRepeticoes(String exercicio, int repeticoes){
        exercicios.put(nome, repeticoes);
    }

    public String listarExercicios(){
        StringBuilder sb = new StringBuilder();
        for (String nome: exercicios.keySet()) sb.append("\n").append(nome);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", repeticaoTreino=" + repeticaoTreino +
                ", exercicios:" + listarExercicios() + '}';
    }

    @Override
    public String getId() {
        return nome;
    }

    public Map<String, Integer> getExercicios() {
        return exercicios;
    }
}
