package com.company;

import java.util.HashMap;
import java.util.Map;

public class ExercicioDAO implements GenericDAO<String, Exercicio>{
    private final Map<String, Exercicio> exercicios = new HashMap<>();
    private static ExercicioDAO EXERCICIO_DAO;

    private ExercicioDAO() {
    }

    public static ExercicioDAO getInstance(){
        if (EXERCICIO_DAO == null)
            EXERCICIO_DAO = new ExercicioDAO();
        return EXERCICIO_DAO;
    }


    @Override
    public void insert(Exercicio exercicio) {
        exercicios.put(exercicio.getNome(), exercicio);
    }

    @Override
    public Exercicio findOne(String nome) {
        return exercicios.get(nome);
    }

    @Override
    public Map<String, Exercicio> findAll() {
        return exercicios;
    }

    @Override
    public void remove(String nome) {
        exercicios.remove(nome);
    }

    @Override
    public void update(String nome, Exercicio exercicio) {
        exercicios.put(nome, exercicio); //so vai ser usado no banco de dados
    }

    public void tamanho(){
        System.out.println(exercicios.size());
    }
}
