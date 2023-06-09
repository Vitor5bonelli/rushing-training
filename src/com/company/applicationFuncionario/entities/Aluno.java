package com.company.applicationFuncionario.entities;

import com.company.CPF;
import com.company.enums.Estado;
import com.company.interfaces.Entidade;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Aluno implements Entidade<String> {
    private String matricula;
    private final int hashSenha;
    private String nome;
    private final CPF cpf;
    private String telefone;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private Estado estadoAluno;

    public Aluno(String senha, String nome, String cpf) {
        this.cpf = new CPF(cpf);
        hashSenha = senha.hashCode();
        this.nome = nome;
    }

    public void mudarEstado(Estado estado){
        estadoAluno = estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
                ", senha='" + hashSenha + '\'' +
                '}';
    }
}
