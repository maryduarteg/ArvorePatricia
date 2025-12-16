package Arvore;

public class NodoF {
    private Nodo no;
    private NodoF prox;

    public NodoF(Nodo no) {
        this.no = no;
        prox = null;
    }

    public Nodo getNo() {
        return no;
    }

    public void setNo(Nodo no) {
        this.no = no;
    }

    public NodoF getProx() {
        return prox;
    }

    public void setProx(NodoF prox) {
        this.prox = prox;
    }
}
