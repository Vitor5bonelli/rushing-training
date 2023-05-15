package com.company;

import com.company.dao.*;
import com.company.entities.Aluno;
import com.company.entities.Exercicio;
import com.company.entities.Funcionario;
import com.company.entities.Treino;
import com.company.enums.Estado;
import com.company.enums.Papel;

public class Main {

    public static void main(String[] args) {

        GenericDAO<String, Exercicio> exDAO = new ExercicioDAO();
        GenericDAO<String, Treino> treinoDAO = new TreinoDAO();

        System.out.println("______________________________funcionarios_______________________________");
        GenericDAO<Integer, Funcionario> funcDAO = new FuncionarioDAO();
        Funcionario instrutor1 = new Funcionario(789, Papel.INSTRUTOR, "renato", "senha123", Estado.ATIVO);
        Funcionario adm1 = new Funcionario(345,Papel.ADMIN, "melissa", "senha123", Estado.ATIVO);
        Funcionario adm2 = new Funcionario(346,Papel.ADMIN, "fred", "senha123", Estado.ATIVO);

        funcDAO.insert(adm1);
        funcDAO.insert(adm2);
        funcDAO.findOne(345).autenticar("senha123");
        funcDAO.findOne(345).cadastrarInstrutor(instrutor1, (FuncionarioDAO) funcDAO);

        funcDAO.findAll().values().forEach(System.out::println);


        /*System.out.println(func1);
        System.out.println(func2);
        System.out.println("alterando cpf func1");
        func1.alterarFuncionario(1111);
        System.out.println(func1);*/


        System.out.println();
        //////teste dao de exercicios
        System.out.println("\n______________________________exercicios_______________________________");

        Exercicio exercicio1 = new Exercicio("Agachamento", "Barra", 50, 100);
        Exercicio exercicio2 = new Exercicio("Supino", "Halteres", 20, 40);
        Exercicio exercicio3 = new Exercicio("Flexão de Braço", "Peso Corporal", 0, 0);


        funcDAO.findOne(789).autenticar("senha123"); //login do instrutor

        funcDAO.findOne(789).adicionarExercicio(exercicio1, (ExercicioDAO) exDAO);
        funcDAO.findOne(789).adicionarExercicio(exercicio2, (ExercicioDAO) exDAO);
        funcDAO.findOne(789).adicionarExercicio(exercicio3, (ExercicioDAO) exDAO);

        exDAO.findAll().values().forEach(System.out::println);

        /////teste dao de treinos
        System.out.println("\n______________________________treinos_______________________________");

        Treino treino1 = new Treino("treino1");
        Treino treino2 = new Treino("treino2");
        Treino treino3 = new Treino("treino3");

        funcDAO.findOne(789).autenticar("senha123"); //login do instrutor

        funcDAO.findOne(789).adicionarTreino(treino1, (TreinoDAO) treinoDAO);
        funcDAO.findOne(789).adicionarTreino(treino2, (TreinoDAO) treinoDAO);
        funcDAO.findOne(789).adicionarTreino(treino3, (TreinoDAO) treinoDAO);

        treinoDAO.findOne("treino1").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino2").inserirExercicio("Supino", 15);
        treinoDAO.findOne("treino2").inserirExercicio("Flexão de Braço", 10);
        treinoDAO.findOne("treino3").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino3").inserirExercicio("Flexão de Braço", 10);

        treinoDAO.findAll().values().forEach(System.out::println);

        ////teste dao de alunos
        System.out.println("\n______________________________alunos_______________________________");

        GenericDAO<Integer, Aluno> alunoDAO = new AlunoDAO();
        Aluno aluno1 = new Aluno("123", "luiz", 1234);
        Aluno aluno2 = new Aluno("123", "laura", 2345);
        Aluno aluno3 = new Aluno("123", "regina", 3456);
        Aluno aluno4 = new Aluno("123", "carlos", 4567);

        funcDAO.findOne(345).autenticar("senha123"); //login do admin

        funcDAO.findOne(345).cadastrarAluno(aluno1, (AlunoDAO) alunoDAO);
        funcDAO.findOne(345).cadastrarAluno(aluno2, (AlunoDAO) alunoDAO);
        funcDAO.findOne(345).cadastrarAluno(aluno3, (AlunoDAO) alunoDAO);
        funcDAO.findOne(345).cadastrarAluno(aluno4, (AlunoDAO) alunoDAO);

        aluno4.setNome("carlos antonio");

        funcDAO.findOne(345).atualizarAluno(aluno4, (AlunoDAO) alunoDAO);


        alunoDAO.findAll().values().forEach(System.out::println);

    }
}
