package com.company;

public class Main {

    public static void main(String[] args) {

        //////teste dao de exercicios
        System.out.println("");
        System.out.println("______________________________exercicios_______________________________");
        new Exercicio("Agachamento", "Barra", 50, 100);
        new Exercicio("Supino", "Halteres", 20, 40);
        new Exercicio("Flexão de Braço", "Peso Corporal", 0, 0);

        ExercicioDAO exDAO = ExercicioDAO.getInstance();
        TreinoDAO treinoDAO = TreinoDAO.getInstance();


        /////teste dao de treinos
        System.out.println("");
        System.out.println("______________________________treinos_______________________________");
        new Treino("treino1");
        new Treino("treino2");
        new Treino("treino3");
        treinoDAO.findOne("treino1").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino1").inserirExercicio("Supino", 15);
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
        new Aluno("123", "luiz", 1234);
        new Aluno("123", "laura", 2345);
        new Aluno("123", "regina", 3456);
        new Aluno("123", "carlos", 4567);

        AlunoDAO alunoDAO = new AlunoDAO();
        System.out.println(alunoDAO.findOne(1234));
        System.out.println(alunoDAO.findOne(2345));
        System.out.println(alunoDAO.findOne(3456));
        System.out.println(alunoDAO.findOne(4567));



        ////teste de funcionarios (falta o dao de funcionario)
        System.out.println("");
        System.out.println("______________________________funcionarios_______________________________");
        Funcionario func1 = new Funcionario(789,Papel.INSTRUTOR, "renato", "123");
        Funcionario func2 = new Funcionario(345,Papel.ADMIN, "melissa", "senha123");
        System.out.println(func1);
        System.out.println(func2);
        System.out.println("alterando cpf func1");
        func1.alterarFuncionario(1111);
        System.out.println(func1);


    }
}
