package com.company.applicationFuncionario.entities;

import com.company.dao.AlunoDAO;
import com.company.dao.ExercicioDAO;
import com.company.dao.FuncionarioDAO;
import com.company.dao.TreinoDAO;
import com.company.enums.Estado;
import com.company.enums.Papel;
import com.company.interfaces.Entidade;

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
    private static Integer idAutenticado;

    public void autenticar(String senha){
        if(this.senha == senha) idAutenticado = getId();
    }

    public static Integer getIdAutenticado(){
        return idAutenticado;
    }

    public Funcionario(int cpf, Papel papel, String nome, String senha, Estado estado) { //falta colocar mais parâmetros só
        this.cpf = cpf;
        this.papel = papel;
        this.senha = senha;
        this.nome = nome;
        this.estadoFuncionario = estado;
    }

    public int getCpf() {
        return cpf;
    }

    /*  discutir melhor esse método depois
    public void alterarFuncionario(int newCpf){  //também falta adicionar mais paramentros
        this.cpf = newCpf;
    }
     */

    public boolean verificarAdmin(){
        if (estadoFuncionario == Estado.INATIVO) return false;
        return papel == Papel.ADMIN;
    }

    public void mudarEstado(Estado estado){
        estadoFuncionario = estado;
    }

    public void cadastrarAluno(Aluno aluno, AlunoDAO alunoDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.ADMIN) return;
        if(!(this.getId().equals(idAutenticado))) return;
        alunoDAO.insert(aluno);
    }

    public void atualizarAluno(Aluno aluno, AlunoDAO alunoDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.ADMIN) return;
        if(!(this.getId().equals(idAutenticado))) return;
        alunoDAO.update(aluno.getId(), aluno);
    }

    public void cadastrarInstrutor(Funcionario func, FuncionarioDAO funcDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.ADMIN) return;
        if(!(this.getId().equals(idAutenticado))) return;
        funcDAO.insert(func);
    }

    public void atualizarInstrutor(Funcionario func, FuncionarioDAO funcDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.ADMIN) return;
        if(func.getPapel() == Papel.ADMIN) return;
        if(!(this.getId().equals(idAutenticado))) return;
        funcDAO.update(func.getId(), func);
    }

    public void adicionarExercicio(Exercicio ex, ExercicioDAO exDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.INSTRUTOR) return;
        if(!(this.getId().equals(idAutenticado))) return;
        exDAO.insert(ex);
    }

    public void atualizarExercicio(Exercicio ex, ExercicioDAO exDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.INSTRUTOR) return;
        if(!(this.getId().equals(idAutenticado))) return;
        exDAO.update(ex.getId(), ex);
    }

    public Papel getPapel() {
        return papel;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome +
                ", cpf=" + cpf +
                ", senha='" + senha +
                ", papel=" + papel +
                ", estado=" + estadoFuncionario +
                '}';
    }

    @Override
    public Integer getId() {
        return cpf;
    }

    public void adicionarTreino(Treino treino, TreinoDAO treinoDAO){
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.INSTRUTOR) return;
        if(!(this.getId().equals(idAutenticado))) return;
        treinoDAO.insert(treino);
    }

    public void atualizarTreino(Treino novoTreino, TreinoDAO treinoDAO){
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.INSTRUTOR) return;
        if(!(this.getId().equals(idAutenticado))) return;
        treinoDAO.update(novoTreino.getId(), novoTreino);
    }

    public void excluirTreino(String nomeTreino, TreinoDAO treinoDAO){
        if(estadoFuncionario != Estado.ATIVO) return;
        if(papel != Papel.INSTRUTOR) return;
        if(!(this.getId().equals(idAutenticado))) return;
        treinoDAO.remove(nomeTreino);
    }
}
