package Arvore;

public class Arvore {
    Nodo raiz;

    public Arvore()
    {
        raiz = null;
    }

    private Nodo localizaNoPai(String info)
    {
        Nodo aux, ant;
        aux = raiz.getLista().getInicio();
        ant = raiz;
        int pos = 0, i;

        while(aux != null) //enquanto não achou a posição
        {
            i = 0;

            //comparar a info com a info do nodo
            while((pos < info.length() && i < aux.getInfo().length()) &&
                    info.charAt(pos) == aux.getInfo().charAt(i))
            {
                pos++;
                i++;
            }


            if(i>0) // se houve match, então desce na lista
            {
                ant = aux;
                aux = aux.getLista().getInicio();
            }
            else //caso não, então tenta averiguar no vizinho
               aux = ant.getProxLista(aux);
        }
        return ant;
    }

    public void inserir(String info)
    {
        int i, j, pos = 0;
        //1° caso: Árvore vazia
        if(raiz.getLista().getInicio() == null)
        {
            raiz.inserir(info, true);
            //System.out.println("Caiu no 1° Caso");
        }
        else
        {
            //FAZER UMA VERIFICAÇÃO PARA VER SE A PALAVRA JÁ ESTÁ INSERIDA
           Nodo pai = estaInserida(info, raiz);

           //2° Caso: a palavra já esteja inserida, então apenas desmarcar o flag
           if(pai != null)
           {
               //System.out.println("Caiu no 2° Caso, info"+info);
               pai.setFlag(true);
               //System.out.println("Valor do pai voltou do estaInserida: "+pai.getInfo());
           }
           else
           {
               //achar o nodo pai
               pai =  localizaNoPai(info);
               if(pai != null)
               {
                   System.out.println("Valor do pai voltou do LocalizaNoPai: "+pai.getInfo()+" para a info: "+info);
               }
               //3° caso: palavra diferente que não tem match, então insere em uma posição da lista do nodo raiz
               if(pai.getInfo().equals(""))
               {
                   pai.inserir(info, true);
                   //System.out.println("Caiu no 3° caso, info"+info);
               }
               else
               {
                   i = 0;
                   j = 1;

                   // ACHAR O MÁXIMO PREFIXO EM COMUM
                   while (j <= pai.getInfo().length() && info.indexOf(pai.getInfo().substring(i, j)) >= 0)
                   {
                       pos = info.indexOf(pai.getInfo().substring(i, j));
                       j++;
                   }

                   // j passou 1 além quando quebrou, então volta 1
                   j--;

                   // PREFIXO COMUM: pai.getInfo().substring(0, j)
                   // RESTO DO PAI QUE VAI VIRAR FILHO
                   String restoPai = pai.getInfo().substring(j);

                   // RESTO DA PALAVRA INSERIDA (APÓS O PREFIXO)
                   String restoInserida = info.substring(pos +j);
                   System.out.println("RestoInserida: "+restoInserida);

                   // atualizar o pai para só o prefixo
                   String novoPai = pai.getInfo().substring(0, j);
                   boolean estadoOriginal = pai.isFlag();
                   pai.setInfo(novoPai);
                   pai.setFlag(false);

                   // guardar lista antiga
                   Lista antigaLista = pai.getLista();
                   pai.setLista(new Lista());

                   // filho 1 → parte antiga (resto do pai)
                   pai.inserir(restoPai, estadoOriginal);
                   pai.getLista().getInicio().setLista(antigaLista);

                   // filho 2 → parte nova (resto inserida)
                   pai.inserir(restoInserida, true);

               }
           }
        }
    }

    //palavra totalmente inserida
    public Nodo estaInserida(String info, Nodo raiz)
    {
        Nodo atual = raiz.getLista().getInicio();
        Nodo ant = raiz;

        int j = 0; // posição na palavra inteira

        while (atual != null && j < info.length())
        {
            int i = 0; // posição dentro do nó atual

            // avança enquanto os caracteres batem
            while (i < atual.getInfo().length() && j < info.length() &&
                    info.charAt(j) == atual.getInfo().charAt(i))
            {
                i++;
                j++;
            }

            // aqui: i = quantidade real de caracteres em comum
            // se i > 0 significa que existe algum prefixo comum

            if (i == atual.getInfo().length())  // combinou o nó inteiro
            {
                // desce para a lista interna
                ant = atual;
                atual = atual.getLista().getInicio();
            }
            else if (i == 0) // nenhum caractere bateu -> vai pro próximo irmão
            {
                atual = ant.getProxLista(atual);
            }
            else
            {
                // combinou parcialmente, mas não o nó inteiro -> não está inserida totalmente
                return null;
            }
        }

        // se percorreu todos os caracteres da palavra
        if (j == info.length())
            return ant; // retorna último nó completamente percorrido

        return null;
    }


    public void exibirNivel()
    {
        Fila f = new Fila();
        int nivel = 0;

        Nodo flag = new Nodo();
        flag.setInfo("skippularjumplinhaflag");

        f.enqueue(raiz);
        f.enqueue(flag);

        while(!f.isEmpty())
        {
            Nodo atual = f.dequeue();

            if(atual.getInfo().equals("skippularjumplinhaflag"))
            {
                nivel++;
                System.out.println("\nNível: " + nivel);

                // só adiciona novo flag se ainda houver nós reais na fila
                if(!f.isEmpty())
                    f.enqueue(flag);
            }
            else
            {
                System.out.print(atual.getInfo() + "   ");

                // enfileira filhos
                Nodo aux = atual.getLista().getInicio();
                while(aux != null)
                {
                    f.enqueue(aux);
                    aux = atual.getProxLista(aux);
                }
            }
        }
    }



    public void exibirPalavras()
    {
        Pilha p = new Pilha();
        p.push(new NodoP("", raiz)); // prefixo vazio pra raiz

        while(!p.isEmpty())
        {
            NodoP nodop = p.pop();
            Nodo atual = nodop.getNo();
            String infoaux = nodop.getInfo() + atual.getInfo();

            if(atual.isFlag())
                System.out.println(infoaux);

            Nodo aux = atual.getLista().getInicio();
            while(aux != null)
            {
                p.push(new NodoP(infoaux, aux));
                aux = atual.getProxLista(aux);
            }
        }
    }

    public void iniciar()
    {
        raiz = new Nodo();
        raiz.setInfo("");
    }
}
