package com.company.applicationAluno.usecases;

import com.company.CPF;
import com.company.applicationFuncionario.entities.Aluno;
import com.company.applicationFuncionario.entities.Exercicio;
import com.company.applicationFuncionario.entities.Treino;
import com.company.applicationFuncionario.entities.TreinoAluno;
import com.company.dao.AlunoDAO;
import com.company.dao.GenericDAO;
import com.company.dao.TreinoDAO;

import java.util.*;

public class ControlarTreinoVinculado {
    private final Map<String, Integer> mapExercicioPeso = new HashMap<>();
    private final TreinoAluno treinoAluno;

    private final GenericDAO<String, Treino> treinoDAO;

    public ControlarTreinoVinculado(TreinoAluno treinoAluno, GenericDAO<String, Treino> treinoDAO) {
        this.treinoAluno = treinoAluno;
        this.treinoDAO = treinoDAO;
    }

    public Integer getTotalExerciciosTreino(){
        Treino treino = getTreinoAluno(treinoDAO);

        return treino.getExercicios().size();
    }

    public Set<String> getSetExerciciosConcluidos(){
        return mapExercicioPeso.keySet();
    }

    public void concluirExercicio(String nomeExercicio, Integer peso){
        Treino treino = getTreinoAluno(treinoDAO);
        if(treino.getExercicios().containsKey(nomeExercicio)){
            mapExercicioPeso.put(nomeExercicio, peso);
            System.out.println("Exercício '" + nomeExercicio + "' Concluido!");
        }else {
            System.out.println("Exercicio não existe...");
        }

    }

    public Map<String, Integer> getMapExercicioPeso(){
        return mapExercicioPeso;
    }

    private Treino getTreinoAluno(GenericDAO<String, Treino> treinoDAO){
        return treinoDAO.findOne(treinoAluno.getNomeTreino());
    }

}
