package estruturas.naolineares.dinamicas.arvorebinaria;

public interface IArvoreBinaria<T> {

    //Retorna o nó raiz da árvore.
    public INoArvoreBinaria<T> obterNoRaiz();

    //Define o filho esquerdo do nó.
    void definirNoRaiz(INoArvoreBinaria<T> noRaiz);

    //Verifica se a árvore está vazia.
    default boolean estaVazia() {
        return this.obterNoRaiz() == null;
    }

    //Retorna o número/quantidade de nós da árvore.
    public int tamanho();

    //Retorna a altura da árvore
    //Retorna -1 para uma árvore vazia, 0 para uma árvore com um único nó.
    public int altura();

    //Retorna o grau da árvore
    //Retorna -1 para uma árvore vazia
    public int grau();

    //Retorna o número de arestas da árvore
    //Retorna -1 para uma árvore vazia, 0 para uma árvore com um único nó.
    public int arestas();

    //Retorna o nível do nó que contém o dado especificado.
    //A raiz está no nível 0, seus filhos no nível 1, e assim por diante.
    //Retorna -1 se os dados não forem encontrados
    //@param dado a ser pesquisado ​​na árvore
    public int nivelNo(T dado);

    //Atravessa a árvore em pré-ordem
    //@param acao é uma função para processar os dados de cada nó (Ex.: impressão)
    void percorrerPreOrdem(java.util.function.Consumer<T> acao);

    //Atravessa a árvore em ordem
    //@param acao é uma função para processar os dados de cada nó (Ex.: impressão)
    void percorrerEmOrdem(java.util.function.Consumer<T> acao);

    //Atravessa a árvore em pós-ordem
    //@param acao é uma função para processar os dados de cada nó (Ex.: impressão)
    void percorrerPosOrdem(java.util.function.Consumer<T> acao);

    //Atravessa a árvore em ordem de nível
    //@param acao é uma função para processar os dados de cada nó (Ex.: impressão)
    void percorrerEmOrdemNivel(java.util.function.Consumer<T> acao);

}
