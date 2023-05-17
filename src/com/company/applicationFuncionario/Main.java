package com.company.applicationFuncionario;

import com.company.CPF;
import com.company.applicationAluno.usecases.ControlarTreinoVinculado;
import com.company.applicationFuncionario.entities.*;
import com.company.dao.*;
import com.company.enums.Estado;
import com.company.enums.Cargo;

import java.util.List;

public class Main{

    public static void main(String[] args) {

        GenericDAO<String, Exercicio> exDAO = new ExercicioDAO();
        GenericDAO<String, Treino> treinoDAO = new TreinoDAO();
        GenericDAO<String, Funcionario> funcDAO = new FuncionarioDAO();
        GenericDAO<String, Aluno> alunoDAO = new AlunoDAO();
        TreinoAlunoDAO treinoAlunoDAO = new TreinoAlunoDAO();

        System.out.println("______________________________funcionarios_______________________________");
        Funcionario instrutor1 = new Funcionario("55638129529", Cargo.INSTRUTOR, "renato", "senha123", Estado.ATIVO);
        Funcionario adm1 = new Funcionario("18276727140", Cargo.ADMIN, "melissa", "senha123", Estado.ATIVO);
        Funcionario adm2 = new Funcionario("41911467930", Cargo.ADMIN, "fred", "senha123", Estado.ATIVO);

        funcDAO.insert(adm1);
        funcDAO.insert(adm2);
        funcDAO.findOne("18276727140").autenticar("senha123");

        funcDAO.findOne("18276727140").cadastrarInstrutor(instrutor1, (FuncionarioDAO) funcDAO);

        funcDAO.findAll().values().forEach(System.out::println);

        System.out.println("\n______________________________exercicios_______________________________");

        Exercicio exercicio1 = new Exercicio("Agachamento", "Barra", 50, 100);
        Exercicio exercicio2 = new Exercicio("Supino", "Halteres", 20, 40);
        Exercicio exercicio3 = new Exercicio("Flexão de Braço", "Peso Corporal", 0, 0);


        funcDAO.findOne("55638129529").autenticar("senha123"); //login do instrutor

        funcDAO.findOne("55638129529").adicionarExercicio(exercicio1, (ExercicioDAO) exDAO);
        funcDAO.findOne("55638129529").adicionarExercicio(exercicio2, (ExercicioDAO) exDAO);
        funcDAO.findOne("55638129529").adicionarExercicio(exercicio3, (ExercicioDAO) exDAO);

        exDAO.findAll().values().forEach(System.out::println);

        System.out.println("\n______________________________treinos_______________________________");

        Treino treino1 = new Treino("treino1");
        Treino treino2 = new Treino("treino2");
        Treino treino3 = new Treino("treino3");

        funcDAO.findOne("55638129529").autenticar("senha123"); //login do instrutor

        funcDAO.findOne("55638129529").adicionarTreino(treino1, (TreinoDAO) treinoDAO);
        funcDAO.findOne("55638129529").adicionarTreino(treino2, (TreinoDAO) treinoDAO);
        funcDAO.findOne("55638129529").adicionarTreino(treino3, (TreinoDAO) treinoDAO);

        treinoDAO.findOne("treino1").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino2").inserirExercicio("Supino", 15);
        treinoDAO.findOne("treino2").inserirExercicio("Flexão de Braço", 10);
        treinoDAO.findOne("treino3").inserirExercicio("Agachamento", 20);
        treinoDAO.findOne("treino3").inserirExercicio("Flexão de Braço", 10);

        treinoDAO.findAll().values().forEach(System.out::println);

        System.out.println("\n______________________________alunos_______________________________");

        Aluno aluno1 = new Aluno("123", "luiz", "43149910706");
        Aluno aluno2 = new Aluno("123", "laura", "37984078785");
        Aluno aluno3 = new Aluno("123", "regina", "66454801055");
        Aluno aluno4 = new Aluno("123", "carlos", "81571431608");

        funcDAO.findOne("18276727140").autenticar("senha123"); //login do admin

        funcDAO.findOne("18276727140").cadastrarAluno(aluno1, (AlunoDAO) alunoDAO);
        funcDAO.findOne("18276727140").cadastrarAluno(aluno2, (AlunoDAO) alunoDAO);
        funcDAO.findOne("18276727140").cadastrarAluno(aluno3, (AlunoDAO) alunoDAO);
        funcDAO.findOne("18276727140").cadastrarAluno(aluno4, (AlunoDAO) alunoDAO);

        aluno4.setNome("carlos antonio");

        funcDAO.findOne("18276727140").atualizarAluno(aluno4, (AlunoDAO) alunoDAO);

        alunoDAO.findAll().values().forEach(System.out::println);

        System.out.println("\n___________________________vinculando treinos____________________________");

        funcDAO.findOne("55638129529").autenticar("senha123");

        funcDAO.findOne("55638129529")
                .vincularTreinoAoAluno("43149910706", "treino1", treinoAlunoDAO);
        funcDAO.findOne("55638129529")
                .vincularTreinoAoAluno("43149910706", "treino3", treinoAlunoDAO);

        funcDAO.findOne("55638129529")
                .vincularTreinoAoAluno("37984078785", "treino2", treinoAlunoDAO);

        treinoAlunoDAO.findTreinosAluno("43149910706").forEach(System.out::println);
        System.out.println();
        treinoAlunoDAO.findTreinosAluno("37984078785").forEach(System.out::println);

        System.out.println("\n___________________________Exibindo Informações do____________________________");
        System.out.println("________________________________Treino do Dia_________________________________");
        List<TreinoAluno> treinosAluno = treinoAlunoDAO.findTreinosAluno("37984078785");

        ControlarTreinoVinculado usecaseTreinoAluno = new ControlarTreinoVinculado(treinosAluno.get(treinosAluno.size() - 1), treinoDAO);

        System.out.println("Total de Exercícios: " + usecaseTreinoAluno.getTotalExerciciosTreino());

        System.out.println("Exercicios Concluidos: ");

        usecaseTreinoAluno.concluirExercicio("Supino", 50);
        usecaseTreinoAluno.concluirExercicio("Flexão de Braço", 0);

        System.out.println("Exercicios Concluidos: ");
        for (String exercicio : usecaseTreinoAluno.getSetExerciciosConcluidos()) {
            System.out.println(exercicio);
        }

    }
}
