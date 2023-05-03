package com.company;

import java.util.HashMap;
import java.util.Map;

public class TreinoDAO implements GenericDAO<String, Treino>{
    private final Map<String, Treino> treinos = new HashMap<>();
    private static TreinoDAO TREINO_DAO;

    private TreinoDAO() {
    }

    public static TreinoDAO getInstance(){
        if (TREINO_DAO == null)
            TREINO_DAO = new TreinoDAO();
        return TREINO_DAO;
    }

    @Override
    public void insert(Treino treino) {
        treinos.put(treino.getNome(), treino);
    }

    @Override
    public Treino findOne(String nome) {
        return treinos.get(nome);
    }

    @Override
    public Map<String, Treino> findAll() {
        return treinos;
    }

    @Override
    public void remove(String nome) {
        treinos.remove(nome);
    }

    @Override
    public void update(String nome, Treino treino) {
        treinos.put(nome, treino); //so vai ser usado no banco de dados
    }

    public void tamanho(){
        System.out.println(treinos.size());
    }
}
