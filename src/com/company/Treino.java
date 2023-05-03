package com.company;

import java.util.HashMap;
import java.util.Map;

public class Treino {
    private final String NOME;
    private String descricao;
    private final Map<String, Integer> exercicios = new HashMap<>();
    private int repeticaoTreino;//? nao entendi

    public Treino(String nome) {
        this.NOME = nome;
        TreinoDAO treinoDAO = TreinoDAO.getInstance();
        treinoDAO.insert(this);//adiciona automaticamente no ExercicioDAO
    }

    public void inserirExercicio(String nomeExercicio, int repeticoes){
        exercicios.put(nomeExercicio, repeticoes);
    }

    //public boolean excluirTreino() --- nao faz sentido ele estar nessa classe

    //public boolean editarTreino() --- qual o sentido da funcao?? edita o treino pelos sets

    //implementações extras para melhorar o fnucionamento do codigo

    public String getNome() {
        return NOME;
    }

    public void excluirExercicio(String exercicio){
        exercicios.remove(exercicio);
    }

    public void mudarRepeticoes(String exercicio, int repeticoes){
        exercicios.put(NOME, repeticoes);
    }

    public String listarExercicios(){
        StringBuilder sb = new StringBuilder();
        for (String nome: exercicios.keySet()) sb.append("\n").append(nome);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Treino{" +
                "nome='" + NOME + '\'' +
                ", descricao='" + descricao + '\'' +
                ", repeticaoTreino=" + repeticaoTreino +
                ", exercicios:" + listarExercicios() + '}';

    }
}
