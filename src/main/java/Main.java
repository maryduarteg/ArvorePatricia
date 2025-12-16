import Arvore.Arvore;

public class Main {
    public static void main(String []args)
    {
       Arvore pat = new Arvore();
       pat.iniciar();
        pat.inserir("Casamento");
        pat.inserir("Casarão");
        pat.inserir("Cavalo");

        pat.inserir("Madeleine");
        System.out.println();
        pat.inserir("Mary");
        System.out.println();
        pat.inserir("Martlin");
        pat.inserir("Casa");

        pat.exibirNivel();
        pat.exibirPalavras();

    }
}
