package com.company;

import java.util.HashMap;
import java.util.Map;

public class AlunoDAO extends GenericDAO2<Integer, Aluno>{
    private static final Map<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();


    @Override
    public void insert(Aluno aluno) {
        alunos.put(aluno.getCpf(), aluno);
    }

    @Override
    public Aluno findOne(Integer cpf) {
        return alunos.get(cpf);
    }

    @Override
    public Map<Integer, Aluno> findAll() {
        return alunos;
    }

    @Override
    public void remove(Integer cpf) {
        alunos.remove(cpf);
    }

    @Override
    public void update(Integer cpf, Aluno aluno) {
        alunos.put(cpf, aluno); //so vai ser usado no banco de dados
    }

    public void tamanho(){
        System.out.println(alunos.size());
    }
}
