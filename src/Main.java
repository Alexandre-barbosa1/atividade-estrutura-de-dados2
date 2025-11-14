import estruturas.naolineares.dinamicas.arvorebinaria.ArvoreBinariaSimples;
import estruturas.naolineares.dinamicas.arvorebinaria.IArvoreBinaria;
import estruturas.naolineares.dinamicas.arvorebinaria.INoArvoreBinaria;
import estruturas.naolineares.dinamicas.arvorebinaria.NoArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        //Criando Nós
        INoArvoreBinaria<String> raiz = new NoArvoreBinaria<>("A");
        INoArvoreBinaria<String> noB = new NoArvoreBinaria<>("B");
        INoArvoreBinaria<String> noC = new NoArvoreBinaria<>("C");
        INoArvoreBinaria<String> noD = new NoArvoreBinaria<>("D");
        INoArvoreBinaria<String> noE = new NoArvoreBinaria<>("E");
        INoArvoreBinaria<String> noF = new NoArvoreBinaria<>("F");
        INoArvoreBinaria<String> noG = new NoArvoreBinaria<>("G");
        INoArvoreBinaria<String> noH = new NoArvoreBinaria<>("H");


        raiz.definirNoEsquerdo(noB);
        raiz.definirNoDireito(noC);
        noB.definirNoEsquerdo(noE);
        noB.definirNoDireito(noD);
        noC.definirNoDireito(noF);
        noF.definirNoEsquerdo(noG);
        noF.definirNoDireito(noH);


        // Cria a Árvore
        IArvoreBinaria<String> arvore = new ArvoreBinariaSimples<>(raiz);

        // Verificando Propriedades
        System.out.println("Tamanho de um nó: " + noC.tamanho());
        System.out.println("Altura de um nó: " + noC.altura());
        System.out.println("Grau de um nó: " + noC.grau());
        System.out.println("Vazia? " + arvore.estaVazia());

        // Percorrer em Pré - Ordém
        arvore.percorrerPreOrdem(System.out::print);  // A B E D C F G H

    }
}