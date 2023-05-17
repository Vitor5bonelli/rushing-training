package com.company.dao;

import com.company.CPF;
import com.company.applicationFuncionario.entities.TreinoAluno;

import java.util.ArrayList;
import java.util.List;

public class TreinoAlunoDAO{
    protected List<TreinoAluno> bancoDeDados = new ArrayList<>();

    public void insert(TreinoAluno treinoAluno) {
        bancoDeDados.add(treinoAluno);
    }

    public void remove(TreinoAluno treinoAluno) {
        bancoDeDados.remove(treinoAluno);
    }

    public void remove(CPF cpfAluno, String nomeTreino) {
        TreinoAluno treinoAluno = new TreinoAluno(cpfAluno, nomeTreino);
        bancoDeDados.remove(treinoAluno);
    }

    public List<TreinoAluno> findAll() {
        return bancoDeDados;
    }

    public List<TreinoAluno> findTreinosAluno(String cpfAluno) {
        List<TreinoAluno> treinosAluno = new ArrayList<>();
        for (TreinoAluno treinoAluno : bancoDeDados) {
            if (treinoAluno.getCpfAluno().getCpf().equals(cpfAluno))
                treinosAluno.add(treinoAluno);
        }
        return treinosAluno;
    }
}
