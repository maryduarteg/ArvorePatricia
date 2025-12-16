package Arvore;

public class Nodo {
    private String info;
    private boolean flag;
    private Lista lista;
    private Nodo prox;
    private Nodo ant;

    public Nodo getProx() {
        return prox;
    }

    public void setProx(Nodo prox) {
        this.prox = prox;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo() {
        prox = ant = null;
        lista = new Lista();
    }

    public Nodo getNoPos(int pos)
    {
        Nodo aux = lista.getInicio();
        for(int i = 0; i<pos; i++)
           aux = aux.getProx();

        return aux;
    }
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void inserir(String info, boolean terminal)
    {
        lista.inserir(info, terminal);
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }


    // dentro da classe Nodo
    public Nodo getProxLista(Nodo nodo) {
        if (this.lista == null || this.lista.getInicio() == null || nodo == null)
            return null;

        Nodo atual = this.lista.getInicio();
        while (atual != null && atual != nodo) {
            atual = atual.getProx();
        }

        // se não achou, retorna null; se achou, retorna o próximo (pode ser null)
        if(atual == null)
            return null;
        else
            return atual.getProx();
    }








}
