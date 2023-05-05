package com.company;

public class Main {

    public static void main(String[] args) {
        new Exercicio("Agachamento", "Barra", 50, 100);
        new Exercicio("Supino", "Halteres", 20, 40);
        new Exercicio("Flexão de Braço", "Peso Corporal", 0, 0);

        ExercicioDAO exDAO = ExercicioDAO.getInstance();
        TreinoDAO treinoDAO = TreinoDAO.getInstance();


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


        Funcionario func1 = new Funcionario(389,Papel.INSTRUTOR);
        System.out.println(func1);
        func1.alterarFuncionario(1111);
        System.out.println(func1);
    }
}
