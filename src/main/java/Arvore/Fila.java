package Arvore;

public class Fila {
    private NodoF inicio;
    private NodoF fim;

    public Fila()
    {
        inicio  = null;
    }

    public boolean isEmpty()
    {
        return inicio == null;
    }

    public void enqueue(Nodo no)
    {

        NodoF novo = new NodoF(no);

        if(inicio == null)
            fim = inicio = novo;

        else
        {
            fim.setProx(novo);
            fim = novo;
        }
    }

    public Nodo dequeue()
    {
        Nodo aux = inicio.getNo();
        if(inicio == fim)
            inicio = fim = null;
        else
            inicio = inicio.getProx();
        return aux;
    }

    public NodoF getInicio() {
        return inicio;
    }

    public void setInicio(NodoF inicio) {
        this.inicio = inicio;
    }

    public NodoF getFim() {
        return fim;
    }

    public void setFim(NodoF fim) {
        this.fim = fim;
    }
}
