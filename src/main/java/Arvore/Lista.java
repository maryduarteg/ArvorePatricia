package Arvore;

public class Lista {
    private Nodo inicio;
    private Nodo fim;

    public Lista() {
        inicio = null;
    }

    public void inserir(String info, boolean terminal)
    {
        Nodo novo = new Nodo();
        novo.setFlag(terminal);
        novo.setInfo(info);

        if(this.inicio == null)
        {
            this.inicio = novo;
            this.fim = novo;
        }
        else
        {
            this.fim.setProx(novo);
            this.fim = novo;
        }
    }

    //Rever como fazer esse remover
    //public void remover() {}

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFim() {
        return fim;
    }

    public void setFim(Nodo fim) {
        this.fim = fim;
    }
}
