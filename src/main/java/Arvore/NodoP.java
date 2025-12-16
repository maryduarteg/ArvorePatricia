package Arvore;

public class NodoP {
    String info;
    Nodo no;
    NodoP ant;

    public NodoP() {}

    public NodoP(String info, Nodo no) {
        this.info = info;
        this.no = no;
        this.ant = null;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Nodo getNo() {
        return no;
    }

    public void setNo(Nodo no) {
        this.no = no;
    }

    public NodoP getAnt() {
        return ant;
    }

    public void setAnt(NodoP ant) {
        this.ant = ant;
    }
}
