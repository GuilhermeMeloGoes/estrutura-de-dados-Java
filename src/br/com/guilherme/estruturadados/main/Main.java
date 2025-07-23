package br.com.guilherme.estruturadados.main;

import br.com.guilherme.estruturadados.modelos.Pessoa;
import br.com.guilherme.estruturadados.vetores.Vetor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a opção desejada.");
        System.out.println("1. Gerenciamento de memória");
        System.out.println("2. Vetores (Arrays)");

        int opcao = sc.nextInt();


        switch (opcao) {
            case 1:
                fazerGerenciamentoMemoria();
                break;
            case 2:
                fazerVetor();
                break;
        }


        sc.close();
    }

    private static void fazerGerenciamentoMemoria() {
        int a = 3;
        System.out.println(a);
        int b = a;
        System.out.println(b);
        b = 2;
        System.out.println("-----------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(b == a);
        System.out.println("-----------------------------");
        Pessoa p1 = new Pessoa(1, "Guilherme");
        System.out.println(p1.toString());
        Pessoa p2 = new Pessoa(1, "Guilherme");
        System.out.println(p2.toString());
        System.out.println("-----------------------------");
        p2.setNome("Guilherme Modificado");
        System.out.println(p1.toString());
        System.out.println(p2.toString());

    }

    private static void fazerVetor() {
        Vetor<Pessoa> vetorPessoas = new Vetor<Pessoa>();
        vetorPessoas.inserir(new Pessoa(1, "Guilherme"));
        vetorPessoas.inserir(new Pessoa(2, "Pedro"));
        vetorPessoas.inserir(new Pessoa(3, "Maryana"));
        vetorPessoas.inserir(new Pessoa(4, "Luana"));
        System.out.println(vetorPessoas);

        vetorPessoas.inserirDados(2, new Pessoa(5, "Intruso"));

        System.out.println(vetorPessoas);

        System.out.println("Lista de Pessoas: ");
        for (int i = 0; i < vetorPessoas.tamanhoVetor(); i++) {
            System.out.println(vetorPessoas.recuperarDados(i));
        }

        Pessoa p = vetorPessoas.recuperarDados(3);
        Pessoa pessoaErrada = new Pessoa(100, "Jose");
        System.out.println(vetorPessoas.existeNoVetor(p));
        System.out.println(vetorPessoas.existeNoVetor(pessoaErrada));
        System.out.println(vetorPessoas.recuperarIndicie(p));
        System.out.println(vetorPessoas.recuperarIndicie(pessoaErrada));

        vetorPessoas.removerDados(2);

        System.out.println(vetorPessoas);
        vetorPessoas.removerDados(p);
        System.out.println(vetorPessoas);

        ArrayList<Pessoa> a; // Visualizar a Classe do ArrayList
        Vector<Pessoa> b; // Visualizar a Classe do Vector

        /*
            Principal diferença entre as duas apesar de implementarem métodos parecidos, é que o vector
            ele é synchronized, ou seja, o método é travado para que apenas uma thred seja executada.
         */

    }
}