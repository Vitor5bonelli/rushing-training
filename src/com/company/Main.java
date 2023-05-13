package com.company;

import com.company.dao.AlunoDAO;
import com.company.dao.FuncionarioDAO;
import com.company.dao.TreinoDAO;

public class Main {

    public static void main(String[] args) {

        GenericDAO<String, Treino> exDAO = new TreinoDAO();

        GenericDAO<String, Treino> treinoDAO = new TreinoDAO();

        //////teste dao de exercicios
        System.out.println("");
        System.out.println("______________________________exercicios_______________________________");
        new Exercicio("Agachamento", "Barra", 50, 100);
        new Exercicio("Supino", "Halteres", 20, 40);
        new Exercicio("Flexão de Braço", "Peso Corporal", 0, 0);

        System.out.println("");
        System.out.println(exDAO.findOne("Agachamento"));
        System.out.println(exDAO.findOne("Supino"));
        System.out.println(exDAO.findOne("Flexão de Braço"));



        /////teste dao de treinos
        System.out.println("");
        System.out.println("______________________________treinos_______________________________");
        treinoDAO.insert(new Treino("treino1"));
        treinoDAO.insert(new Treino("treino2"));
        treinoDAO.insert(new Treino("treino3"));

        treinoDAO.findOne("treino1").inserirExercicio("Agachamento", 20);

        treinoDAO.findOne("treino2").inserirExercicio("Supino", 15);
        treinoDAO.findOne("treino2").inserirExercicio("Flexão de Braço", 10);
        treinoDAO.findOne("treino3").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino3").inserirExercicio("Flexão de Braço", 10);

        System.out.println("");
        System.out.println(treinoDAO.findOne("treino1"));
        System.out.println(treinoDAO.findOne("treino2"));
        System.out.println(treinoDAO.findOne("treino3"));


        ////teste dao de alunos
        System.out.println("");
        System.out.println("______________________________alunos_______________________________");

        GenericDAO<Integer, Aluno> alunoDAO = new AlunoDAO();
        alunoDAO.insert(new Aluno("123", "luiz", 1234));
        alunoDAO.insert(new Aluno("123", "laura", 2345));
        alunoDAO.insert(new Aluno("123", "regina", 3456));
        alunoDAO.insert(new Aluno("123", "carlos", 4567));

        System.out.println(alunoDAO.findOne(1234));
        System.out.println(alunoDAO.findOne(2345));
        System.out.println(alunoDAO.findOne(3456));
        System.out.println(alunoDAO.findOne(4567));



        ////teste de funcionarios (falta o dao de funcionario)
        System.out.println("");
        System.out.println("______________________________funcionarios_______________________________");
        GenericDAO<Integer, Funcionario> funcDAO = new FuncionarioDAO();
        funcDAO.insert(new Funcionario(789,Papel.INSTRUTOR, "renato", "123"));
        funcDAO.insert(new Funcionario(345,Papel.ADMIN, "melissa", "senha123"));
        funcDAO.insert(new Funcionario(346,Papel.ADMIN, "melissa2", "senha123"));
        System.out.println(funcDAO.findOne(789));
        System.out.println(funcDAO.findOne(345));
        System.out.println(funcDAO.findOne(346));

        /*System.out.println(func1);
        System.out.println(func2);
        System.out.println("alterando cpf func1");
        func1.alterarFuncionario(1111);
        System.out.println(func1);*/


    }
}
