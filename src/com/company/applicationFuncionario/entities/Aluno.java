package com.company.applicationFuncionario.entities;

import com.company.enums.Estado;
import com.company.interfaces.Entidade;

import java.time.LocalDate;
import java.util.List;

public class Aluno implements Entidade<Integer> {
    private String matricula;
    private final String senha;
    private String nome;
    private final int cpf; // criar classe cpf
    private String telefone;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private Estado estadoAluno;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno(String senha, String nome, int cpf) {
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }
    // treino

    public void inativarAluno(){
        estadoAluno = Estado.INATIVO;
    }

    public void ativarAluno(){
        estadoAluno = Estado.ATIVO;
    }


    @Override
    public Integer getId() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", senha='" + senha + '\'' +
                '}';
    }
}
