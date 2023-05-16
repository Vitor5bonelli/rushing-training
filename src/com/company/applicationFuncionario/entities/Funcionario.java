package com.company.applicationFuncionario.entities;

import com.company.dao.AlunoDAO;
import com.company.dao.ExercicioDAO;
import com.company.dao.FuncionarioDAO;
import com.company.dao.TreinoDAO;
import com.company.enums.Estado;
import com.company.enums.Cargo;
import com.company.interfaces.Entidade;

public class Funcionario implements Entidade<Integer> {
    //private String usuario; o usuario pode ser o cpf, nome ou email
    private int cpf;
    private String senha;
    private String nome;
    private String telefone;
    private Cargo cargo;
    private Estado estadoFuncionario;
    private static Integer idAutenticado;

    public void autenticar(String senha){
        if(this.senha == senha) idAutenticado = getId();
    }

    public static Integer getIdAutenticado(){
        return idAutenticado;
    }

    public Funcionario(int cpf, Cargo cargo, String nome, String senha, Estado estado) { //falta colocar mais parâmetros só
        this.cpf = cpf;
        this.cargo = cargo;
        this.senha = senha;
        this.nome = nome;
        this.estadoFuncionario = estado;
    }

    public boolean verificarAcesso(Cargo cargoEsperado){
        if(estadoFuncionario != Estado.ATIVO) return false;
        if(cargo != cargoEsperado) return false;
        if(!(this.getId().equals(idAutenticado))) return false;
        return true;
    }

    public void mudarEstado(Estado estado){
        estadoFuncionario = estado;
    }

    public void cadastrarAluno(Aluno aluno, AlunoDAO alunoDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.ADMIN)) return;
        alunoDAO.insert(aluno);
    }

    public void atualizarAluno(Aluno aluno, AlunoDAO alunoDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.ADMIN)) return;
        alunoDAO.update(aluno.getId(), aluno);
    }

    public void cadastrarInstrutor(Funcionario func, FuncionarioDAO funcDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.ADMIN)) return;
        funcDAO.insert(func);
    }

    public void atualizarInstrutor(Funcionario func, FuncionarioDAO funcDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.ADMIN)) return;
        if(func.getCargo() == Cargo.ADMIN) return;
        funcDAO.update(func.getId(), func);
    }

    public void adicionarExercicio(Exercicio ex, ExercicioDAO exDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        exDAO.insert(ex);
    }

    public void atualizarExercicio(Exercicio ex, ExercicioDAO exDAO){
        // só estou passando o DAO para poder adicionar no mesmo DAO da main, com banco de dados não vai ter
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        exDAO.update(ex.getId(), ex);
    }

    public void adicionarTreino(Treino treino, TreinoDAO treinoDAO){
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        treinoDAO.insert(treino);
    }

    public void atualizarTreino(Treino novoTreino, TreinoDAO treinoDAO){
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        treinoDAO.update(novoTreino.getId(), novoTreino);
    }

    public void excluirTreino(String nomeTreino, TreinoDAO treinoDAO){
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        treinoDAO.remove(nomeTreino);
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public Integer getId() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", senha='" + senha + '\'' +
                ", papel=" + cargo +
                ", estado=" + estadoFuncionario +
                '}';
    }
}
