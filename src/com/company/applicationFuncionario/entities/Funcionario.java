package com.company.applicationFuncionario.entities;

import com.company.CPF;
import com.company.dao.*;
import com.company.enums.Estado;
import com.company.enums.Cargo;
import com.company.interfaces.Entidade;

public class Funcionario implements Entidade<String> {
    //private String usuario; o usuario pode ser o cpf, nome ou email
    private CPF cpf;
    private int hashSenha;
    private String nome;
    private String telefone;
    private Cargo cargo;
    private Estado estadoFuncionario;
    private static CPF idAutenticado;

    public Funcionario(String cpf, Cargo cargo, String nome, String senha, Estado estado) { //falta colocar mais parâmetros só
        this.cpf = new CPF(cpf);
        this.cargo = cargo;
        this.nome = nome;
        this.estadoFuncionario = estado;
        hashSenha = senha.hashCode();
    }

    public void autenticar(String senha){
        if(hashSenha == senha.hashCode()) idAutenticado = getCPF();
    }

    public static CPF getIdAutenticado(){
        return idAutenticado;
    }

    public boolean verificarAcesso(Cargo cargoEsperado){
        if(estadoFuncionario != Estado.ATIVO) return false;
        if(cargo != cargoEsperado) return false;
        return cpf.equals(idAutenticado);
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

    public void vincularTreinoAoAluno(String cpfAluno, String nomeTreino, TreinoAlunoDAO treinoAlunoDAO){
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        CPF cpf = new CPF(cpfAluno);
        treinoAlunoDAO.insert(new TreinoAluno(cpf, nomeTreino));
    }

    public void desvincularTreinoAoAluno(String cpfAluno, String nomeTreino, TreinoAlunoDAO treinoAlunoDAO){
        if (!verificarAcesso(Cargo.INSTRUTOR)) return;
        CPF cpf = new CPF(cpfAluno);
        treinoAlunoDAO.remove(cpf, nomeTreino);
    }

    private CPF getCPF(){
        return cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    @Override
    public String getId() {
        return cpf.getCpf();
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf.getCpf() +
                ", senha='" + hashSenha + '\'' +
                ", papel=" + cargo +
                ", estado=" + estadoFuncionario +
                '}';
    }
}
