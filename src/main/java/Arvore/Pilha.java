package Arvore;

public class Pilha {
    NodoP top;

    public Pilha() {
        this.top = null;
    }

    public void iniciar() {
        this.top = null;
    }

    public void push(NodoP novo)
    {
        if(top == null)
            top = novo;
        else
        {
            novo.setAnt(top);
            top = novo;
        }
    }

    public NodoP pop()
    {
        NodoP aux = top;
        top = top.getAnt();
        return aux;
    }

    public boolean isEmpty()
    {
        return top == null;
    }
}
