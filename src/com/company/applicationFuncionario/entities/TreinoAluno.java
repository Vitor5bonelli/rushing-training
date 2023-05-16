package com.company.applicationFuncionario.entities;

import com.company.CPF;

public class TreinoAluno {
    private final CPF cpfAluno;
    private final String nomeTreino;

    public TreinoAluno(CPF cpfAluno, String nomeTreino) {
        this.cpfAluno = cpfAluno;
        this.nomeTreino = nomeTreino;
    }

    public CPF getCpfAluno() {
        return cpfAluno;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    @Override
    public String toString() {
        return "TreinoAluno{" +
                "Aluno=" + cpfAluno.getCpf() +
                ", Treino='" + nomeTreino + '\'' +
                '}';
    }
}
