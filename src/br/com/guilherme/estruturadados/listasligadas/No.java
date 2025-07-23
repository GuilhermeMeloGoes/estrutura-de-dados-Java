package br.com.guilherme.estruturadados.listasligadas;

class No<T> {

    private T elemento;
    private No<T> noProximo;

    public No() {
        this.noProximo = null;
    }

    public No(T elemento) {
        this.elemento = elemento;
        this.noProximo = null;
    }

    public No(T elemento, No<T> noProximo) {
        this.elemento = elemento;
        this.noProximo = noProximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(No<T> noProximo) {
        this.noProximo = noProximo;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                ", noProximo=" + noProximo +
                '}';
    }
}
