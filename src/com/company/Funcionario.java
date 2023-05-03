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

}
