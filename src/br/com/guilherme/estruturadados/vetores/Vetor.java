package br.com.guilherme.estruturadados.vetores;

import java.util.Arrays;

public class Vetor<T> {

    private Object[] elementos;
    private int posicao;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.posicao = 0;
    }

    public Vetor() {
        this.elementos = new Object[3];
        this.posicao = 0;
    }

    public void inserir(T elemento) {
        if (this.posicao >= this.elementos.length) {
            this.elementos = Arrays.copyOf(this.elementos, this.elementos.length + 1);
        }
        this.elementos[this.posicao] = elemento;
        this.posicao++;
    }

    public void inserirDados(int posicao, T elemento) {
        if (posicao > this.elementos.length) {
            throw new IllegalArgumentException(String.format("A posição [%d] não existe no vetor!", posicao));
        }

        if (this.elementos[posicao] != null) {
            Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao, this.elementos.length);
            Object[] arrayInicio = new Object[posicao + 1];
            System.arraycopy(this.elementos, 0, arrayInicio, 0, posicao);
            arrayInicio[arrayInicio.length - 1] = elemento;

            int novoTamanho = arrayFinal.length + arrayInicio.length;
            this.elementos = new Object[novoTamanho];
            System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
            System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);
            this.posicao++;
        } else {
            this.elementos[posicao] = elemento;
        }
    }

    public int tamanhoVetor() {
        return this.elementos.length;
    }

    public boolean existeNoVetor(T elemento) {
        for (int i = 0; i < tamanhoVetor(); i++) {
            T elem = recuperarDados(i);
            if (elem != null && elem.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int recuperarIndicie(T elemento) {
        for (int i = 0; i < tamanhoVetor(); i++) {
            T elem = recuperarDados(i);
            if (elem != null && elem.equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void removerDados(int posicao) {
        if (posicao >= tamanhoVetor()) {
            throw new IllegalArgumentException(String.format("Posição inválida %d!", posicao));
        }

        Object[] arrayFinal = Arrays.copyOfRange(this.elementos, posicao + 1, this.elementos.length);
        Object[] arrayInicio = Arrays.copyOfRange(this.elementos, 0, posicao);
        this.elementos = new Object[tamanhoVetor() - 1];
        this.posicao--;
        System.arraycopy(arrayInicio, 0, this.elementos, 0, arrayInicio.length);
        System.arraycopy(arrayFinal, 0, this.elementos, arrayInicio.length, arrayFinal.length);
    }

    public void removerDados(T elemento) {
        int indicieRemover = recuperarIndicie(elemento);
        if (indicieRemover >= tamanhoVetor() || indicieRemover == -1) {
            throw new IllegalArgumentException("Elemento inválido " + elemento);
        }

        removerDados(indicieRemover);
    }

    @SuppressWarnings("unchecked")
    public T recuperarDados(int posicao) {
        if (posicao >= tamanhoVetor()) {
            throw new IllegalArgumentException(String.format("Posição %d inválida no vetor ", posicao));
        }
        return (T) this.elementos[posicao];
    }

    @Override
    public String toString() {
        return "Vetor{" +
                "elementos=" + Arrays.toString(elementos) +
                '}';
    }
}
