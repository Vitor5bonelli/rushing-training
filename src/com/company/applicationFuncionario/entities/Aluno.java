package com.company.applicationFuncionario.entities;

import com.company.CPF;
import com.company.enums.Estado;
import com.company.interfaces.Entidade;

import java.time.LocalDate;
import java.util.List;

public class Aluno implements Entidade<String> {
    private String matricula;
    private final String senha;
    private String nome;
    private final CPF cpf;
    private String telefone;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private Estado estadoAluno;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno(String senha, String nome, String cpf) {
        this.cpf = new CPF(cpf);
        this.senha = senha;
        this.nome = nome;
    }
    // treino

    public void inativarAluno(){
        estadoAluno = Estado.INATIVO;
    }

    public void ativarAluno(){
        estadoAluno = Estado.ATIVO;
    }


    @Override
    public String getId() {
        return cpf.getCpf();
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf.getCpf() +
                ", senha='" + senha + '\'' +
                '}';
    }
}
