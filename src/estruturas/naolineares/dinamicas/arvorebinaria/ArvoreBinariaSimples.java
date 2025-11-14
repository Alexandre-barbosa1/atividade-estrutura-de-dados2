package estruturas.naolineares.dinamicas.arvorebinaria;

import java.util.function.Consumer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Implementação da árvore binária simples.
 * Métodos de tamanho, altura e grau são calculados no nível da árvore
 * (percorrendo todos os nós) em vez de apenas delegar ao nó raiz.
 */
public class ArvoreBinariaSimples<T> implements IArvoreBinaria<T> {

    private INoArvoreBinaria<T> noRaiz;

    public ArvoreBinariaSimples() {}

    public ArvoreBinariaSimples(INoArvoreBinaria<T> noRaiz) {
        this.noRaiz = noRaiz;
    }

    @Override
    public INoArvoreBinaria<T> obterNoRaiz() {
        // Retorna a referência ao nó raiz da árvore (pode ser null).
        return this.noRaiz;
    }

    @Override
    public void definirNoRaiz(INoArvoreBinaria<T> noRaiz) {
        // Define ou substitui a raiz da árvore.
        this.noRaiz = noRaiz;
    }

    @Override
    public int tamanho() {
        // Calcula o número total de nós da árvore,
        // iniciando a contagem a partir da raiz.
        return tamanhoRec(this.noRaiz);
    }

    // Auxiliar recursivo que retorna 0 para nó nulo;
    // caso contrário conta 1 (o próprio nó) + tamanho das subárvores.
    private int tamanhoRec(INoArvoreBinaria<T> no) {
        if (no == null) return 0;
        return 1 + tamanhoRec(no.obterNoEsquerdo()) + tamanhoRec(no.obterNoDireito());
    }

    @Override
    public int altura() {
        // Retorna a altura da árvore definida como número de arestas
        // no maior caminho da raiz até uma folha.
        // Convenção: árvore vazia -> -1, único nó -> 0.
        return alturaRec(this.noRaiz);
    }

    // Auxiliar recursivo: altura de nó nulo = -1; senão 1 + max(alturaEsq, alturaDir).
    private int alturaRec(INoArvoreBinaria<T> no) {
        if (no == null) return -1;
        int he = alturaRec(no.obterNoEsquerdo());
        int hd = alturaRec(no.obterNoDireito());
        return 1 + Math.max(he, hd);
    }

    @Override
    public int grau() {
        // Retorna o grau máximo presente em toda a árvore.
        // Convenção: árvore vazia -> -1.
        if (this.noRaiz == null) return -1;
        return grauMaxRec(this.noRaiz);
    }

    // Percorre todos os nós e calcula o maior valor de grau encontrado
    // (0, 1 ou 2 em árvore binária).
    private int grauMaxRec(INoArvoreBinaria<T> no) {
        if (no == null) return 0;
        int atual = no.grau(); // grau do próprio nó
        int ge = grauMaxRec(no.obterNoEsquerdo());
        int gd = grauMaxRec(no.obterNoDireito());
        return Math.max(atual, Math.max(ge, gd));
    }

    @Override
    public int arestas() {
        // Número de arestas = número de nós - 1.
        // Convenção: árvore vazia -> -1; árvore com 1 nó -> 0.
        if (this.noRaiz == null) return -1;
        int n = this.tamanho();
        return Math.max(0, n - 1);
    }

    @Override
    public int nivelNo(T dado){
        // Busca o nível do nó que contém 'dado'.
        // A raiz está no nível 0; retorna -1 se não encontrado.
        return nivelNoRec(this.noRaiz, dado, 0);
    }

    // Auxiliar recursivo que realiza busca em pré-ordem mantendo o nível atual.
    // Compara valores de forma segura com nulls.
    private int nivelNoRec(INoArvoreBinaria<T> no, T dado, int nivel) {
        if (no == null) return -1;
        T d = no.obterDado();
        boolean iguais = (d == null && dado == null) || (d != null && d.equals(dado));
        if (iguais) return nivel;
        int esquerda = nivelNoRec(no.obterNoEsquerdo(), dado, nivel + 1);
        if (esquerda != -1) return esquerda; // encontrado na subárvore esquerda
        return nivelNoRec(no.obterNoDireito(), dado, nivel + 1); // procura direita
    }

    @Override
    public void percorrerPreOrdem(Consumer<T> acao) {
        // Inicia travessia em pré-ordem (nó, esquerda, direita) a partir da raiz.
        percorrerPreOrdem(this.noRaiz, acao);
    }

    // Auxiliar recursivo para pré-ordem; caso base: nó nulo -> retorna.
    private void percorrerPreOrdem(INoArvoreBinaria<T> no, java.util.function.Consumer<T> acao) {
        if (no == null) return;
        acao.accept(no.obterDado()); // processa o nó atual
        percorrerPreOrdem(no.obterNoEsquerdo(), acao);
        percorrerPreOrdem(no.obterNoDireito(), acao);
    }

    @Override
    public void percorrerEmOrdem(Consumer<T> acao) {
        // Inicia travessia em ordem/in-order (esquerda, nó, direita).
        percorrerEmOrdem(this.noRaiz, acao);
    }

    // Auxiliar recursivo para in-order; visita subárvore esquerda, processa nó, depois direita.
    private void percorrerEmOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null) return;
        percorrerEmOrdem(no.obterNoEsquerdo(), acao);
        acao.accept(no.obterDado());
        percorrerEmOrdem(no.obterNoDireito(), acao);
    }

    @Override
    public void percorrerPosOrdem(Consumer<T> acao) {
        // Inicia travessia em pós-ordem (esquerda, direita, nó).
        percorrerPosOrdem(this.noRaiz, acao);
    }

    // Auxiliar recursivo para pós-ordem; processa o nó apenas após as subárvores.
    private void percorrerPosOrdem(INoArvoreBinaria<T> no, Consumer<T> acao) {
        if (no == null) return;
        percorrerPosOrdem(no.obterNoEsquerdo(), acao);
        percorrerPosOrdem(no.obterNoDireito(), acao);
        acao.accept(no.obterDado());
    }

    @Override
    public void percorrerEmOrdemNivel(Consumer<T> acao) {
        // Travessia em ordem de nível (BFS): visita nós por níveis usando fila.
        if (this.noRaiz == null) return; // nada a percorrer em árvore vazia
        Queue<INoArvoreBinaria<T>> fila = new LinkedList<>();
        fila.add(this.noRaiz);
        while (!fila.isEmpty()) {
            INoArvoreBinaria<T> no = fila.poll();
            acao.accept(no.obterDado()); // processa nó do nível atual
            // adiciona filhos na fila (esquerdo primeiro para manter ordem por nível)
            if (no.obterNoEsquerdo() != null) fila.add(no.obterNoEsquerdo());
            if (no.obterNoDireito() != null) fila.add(no.obterNoDireito());
        }
    }

}