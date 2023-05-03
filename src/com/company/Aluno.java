package com.company;

import java.time.LocalDate;
import java.util.List;

public class Aluno {
    private String matricula;
    private String senha;
    private String nome;
    private String email;
    private int cpf; // criar classe cpf
    private List<String> telefones;
    private LocalDate dataNasc;
    private float peso;
    private float altura;
    private boolean temDeficiencia;//no documento o atributo é string, mas se for pra listar todas as deficiencias melhor usar uma list, mas não vejo muito sentido
    //fichaMedica é boolean no documento???? kk
    private Estado estadoAluno;
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
}
