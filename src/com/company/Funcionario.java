package com.company;

import javax.print.DocFlavor;
import java.util.List;

public class Funcionario {
    //private String usuario; o usuario pode ser o cpf, nome ou email
    private int cpf;
    private String senha;
    private String nome;
    private List<String> telefones;
    private String email;
    private Papel papel; //pode ser renomeado para função, fica mais claro
    private Estado estadoFuncionario;


    public Funcionario(int cpf, Papel papel) { //falta colocar mais paramentros só
        this.cpf = cpf;
        this.papel = papel;
    }

    public void alterarFuncionario(int newCpf){  //também falta adicionar mais paramentros
        this.cpf = newCpf;
    }

    public boolean verificarAdmin(){
        if (estadoFuncionario == Estado.INATIVO) return false;
        return papel == Papel.ADMIN;
    }

    public void inativarFuncionario(){
        estadoFuncionario = Estado.INATIVO;
    }

    public void ativarFuncionario(){
        estadoFuncionario = Estado.ATIVO;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf=" + cpf +
                ", papel=" + papel +
                '}';
    }
}
