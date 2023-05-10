package com.company;

import java.util.HashMap;
import java.util.Map;

public class FuncionarioDAO extends GenericDAO2<Integer, Funcionario> {

    private static final Map<Integer, Funcionario> funcionarios = new HashMap<>();

    private static FuncionarioDAO FUNCIONARIO_DAO;

    @Override
    public void insert(Funcionario funcionario) {
        funcionarios.put(funcionario.getCpf(), funcionario);
    }

    @Override
    public Funcionario findOne(Integer cpf) {
        return funcionarios.get(cpf);
    }

    @Override
    public Map<Integer, Funcionario> findAll() {
        return funcionarios;
    }

    @Override
    public void remove(Integer cpf) {
        funcionarios.remove(cpf);
    }

    @Override
    public void update(Integer cpf, Funcionario funcionario) {
        funcionarios.put(cpf, funcionario);
    }

}
