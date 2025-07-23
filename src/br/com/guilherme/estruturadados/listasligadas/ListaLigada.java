package br.com.guilherme.estruturadados.listasligadas;

public class ListaLigada<T> {

    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private int tamanho;

    public ListaLigada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public void inserirElemento(T elemento) {
        No<T> novoNo = new No<T>(elemento);

        if (estaVazia()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setNoProximo(novoNo);
            this.ultimoNo = novoNo;
        }
        this.tamanho++;
    }

    public void inserirElementoEm(int posicao, T elemento) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException(String.format("Posição invpalida %d", posicao));
        }

        No<T> novoNo = new No<T>(elemento);

        if (posicao == 0) {
            novoNo.setNoProximo(this.primeiroNo);
            this.primeiroNo = novoNo;
        } else if (posicao == this.tamanho() - 1) {
            this.ultimoNo.setNoProximo(novoNo);
            this.ultimoNo = novoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> noAtual = recuperarNo(posicao);

            noAnterior.setNoProximo(novoNo);
            novoNo.setNoProximo(noAtual);
        }
        this.tamanho++;
    }

    public void inserirPrimeiro(T elemento) {
        inserirElementoEm(0, elemento);
    }

    public void inserirUltimo(T elemento) {
        inserirElementoEm(tamanho - 1, elemento);
    }

    public T recuperarElemento(int posicao) {
        No<T> no = recuperarNo(posicao);
        if (no != null) {
            return no.getElemento();
        } else {
            return null;
        }
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean contem(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int indicie(T elemento) {
        for (int i = 0; i < tamanho(); i++) {
            No<T> noAtual = recuperarNo(i);
            if (noAtual.getElemento() != null && noAtual.getElemento().equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public void remover(int posicao) {
        if (posicao >= tamanho()) {
            throw new IllegalArgumentException(String.format("Posição invpalida %d", posicao));
        }
        No<T> noAtual = recuperarNo(posicao);

        if (posicao == 0) {
            No<T> proximoNo = this.primeiroNo.getNoProximo();
            this.primeiroNo.setNoProximo(null);
            this.primeiroNo = proximoNo;
        } else if (posicao == tamanho() - 1) {
            No<T> penultimoNo = recuperarNo(tamanho() - 2);
            penultimoNo.setNoProximo(null);
            this.ultimoNo = penultimoNo;
        } else {
            No<T> noAnterior = recuperarNo(posicao - 1);
            No<T> proximoNo = recuperarNo(posicao + 1);

            noAnterior.setNoProximo(proximoNo);
            noAtual.setNoProximo(null);
        }
        this.tamanho--;
    }

    public void remover(T elemento) {
        int indicie = indicie(elemento);
        if (indicie == -1) {
            throw new IllegalArgumentException(String.format("Elemento inválido - " + elemento.toString()));
        }
        remover(indicie);
    }

    private No<T> recuperarNo(int posicao) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException(String.format("Posição invpalida %d", posicao));
        }
        No<T> resultado = null;
        for (int i = 0; i <= posicao; i++) {
            if (i == 0) {
                resultado = this.primeiroNo;
            } else {
                resultado = resultado.getNoProximo();
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "Lista []";
        } else {
            No<T> noAtual = this.primeiroNo;
            StringBuilder sb = new StringBuilder();
            sb.append("Lista [");
            sb.append(noAtual.getElemento() != null ? noAtual.getElemento().toString() : "<NULO>");
            sb.append(",");
            while (noAtual.getNoProximo() != null) {
                sb.append(noAtual.getNoProximo().getElemento() != null ? noAtual.getNoProximo().getElemento().toString() : "<NULO>");
                sb.append(", ");
                noAtual = noAtual.getNoProximo();
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
