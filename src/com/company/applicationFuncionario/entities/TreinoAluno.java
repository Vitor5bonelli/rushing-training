package com.company.applicationFuncionario.entities;

import com.company.CPF;

import java.time.LocalDate;

public class TreinoAluno implements Comparable<TreinoAluno>{
    private final CPF cpfAluno;
    private final String nomeTreino;
    private final LocalDate dataTreino;

    public TreinoAluno(CPF cpfAluno, String nomeTreino) {
        this.cpfAluno = cpfAluno;
        this.nomeTreino = nomeTreino;

        this.dataTreino = LocalDate.now();
    }

    @Override
    public int compareTo(TreinoAluno treinoAluno) {
        return getDataTreino().compareTo(treinoAluno.getDataTreino());
    }

    public CPF getCpfAluno() {
        return cpfAluno;
    }
    public String getNomeTreino() {
        return nomeTreino;
    }

    public LocalDate getDataTreino() {
        return dataTreino;
    }

    @Override
    public String toString() {
        return "TreinoAluno{" +
                "Aluno=" + cpfAluno.getCpf() +
                ", Treino='" + nomeTreino + '\'' +
                '}';
    }
}
