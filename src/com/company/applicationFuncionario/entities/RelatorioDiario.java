package com.company.applicationFuncionario.entities;

import com.company.dao.AlunoDAO;

import java.util.HashMap;
import java.util.Map;

public class RelatorioDiario {
    private Map<String, Aluno> alunos = new HashMap<>();
    //como posso pegar o horario de entrada e saida???
    //na descrição do relatorio fala relatorio diario, porém embaixo diz que pode ser selecionado dia e horario?? nao entendi

    public RelatorioDiario(AlunoDAO alunoDAO) {
        alunos = alunoDAO.findAll();
    }
}
