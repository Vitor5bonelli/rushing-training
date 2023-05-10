package com.company;

import javax.print.DocFlavor;
import java.util.List;

public class Funcionario implements Entidade<Integer> {
    //private String usuario; o usuario pode ser o cpf, nome ou email
    private int cpf;
    private String senha;
    private String nome;
    private List<String> telefones;
    private String email;
    private Papel papel; //pode ser renomeado para função, fica mais claro
    private Estado estadoFuncionario;


    public Funcionario(int cpf, Papel papel, String nome, String senha) { //falta colocar mais parâmetros só
        this.cpf = cpf;
        this.papel = papel;
        this.senha = senha;
        this.nome = nome;
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        funcDAO.insert(this);

    }

    public int getCpf() {
        return cpf;
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
                "nome='" + nome +
                ", cpf=" + cpf +
                ", senha='" + senha +
                ", papel=" + papel +
                '}';
    }

    @Override
    public Integer getId() {
        return cpf;
    }
}
