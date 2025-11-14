package estruturas.naolineares.dinamicas.arvorebinaria;

public interface INoArvoreBinaria<T> {

    //Retorna os dados armazenados no nó.
    public T obterDado();

    //Define o dado a ser armazenado no nó.
    //Obs.: A semântica de uma árvore binária de busca (BST) exige a definição/substituição de dados durante a remoção.
    public void definirDado(T dado);

    //Retorna o filho esquerdo do nó.
    public INoArvoreBinaria<T> obterNoEsquerdo();

    //Define o filho esquerdo do nó.
    public void definirNoEsquerdo(INoArvoreBinaria<T> noEsquerdo);

    //Retorna o filho direito do nó.
    public INoArvoreBinaria<T> obterNoDireito();

    //Define o filho direito do nó.
    public void definirNoDireito(INoArvoreBinaria<T> noDireito);

    //Retorna o tamanho da subárvore com raiz neste nó.
    //O tamanho é definido como o número de nós na subárvore, incluindo este nó.
    public int tamanho();

    //Retorna a altura da subárvore com raiz neste nó.
    //A altura é definida como o número de arestas no caminho mais longo deste nó até um nó folha em sua subárvore.
    //A altura de um nó folha (sem filhos) é 0
    //A altura de um nó inexistente (nulo) é -1
    public int altura();

    //Retorna o grau deste nó (número de nós filhos diretos)
    //O grau é definido como o número de filhos diretos (subnós) que este nó possui atualmente.
    //Em uma árvore binária, os valores possíveis são: 0 (nó folha) 1 (um filho) 2 (dois filhos)
    public int grau();
}

