package com.company.entities;

import com.company.enums.Estado;
import com.company.interfaces.Entidade;

import java.time.LocalDate;
import java.util.List;

public class Aluno implements Entidade<Integer> {
    private String matricula;
    private String senha;
    private String nome;
    private String email;
    private final int cpf; // criar classe cpf
    private List<String> telefones;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private boolean temDeficiencia;//no documento o atributo é string, mas se for pra listar todas as deficiencias melhor usar uma list, mas não vejo muito sentido
    //fichaMedica é boolean no documento???? kk
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


    public int getCpf() {
        return cpf;
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
