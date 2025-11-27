package estruturas.naolineares.dinamicas.arvorebinariabusca;

public class ArvoreBinariaBuscaComDuplicatas<T extends Comparable<T>> extends ArvoreBinariaBusca<T> {

    @Override
    public void inserir(T dado) {
        //Implemente o codigo para permitir valores duplicados (valores duplicados vão para a sub-árvore esquerda)
    }

    public int contarOcorrencias(T dado) {
        return 0;
    }

    @Override
    protected boolean validarArvoreBinariaBusca(INoArvoreBinaria<T> no, T minimo, T maximo) {
        return false;
    }

    @Override
    public boolean estaVazia() {
        return super.estaVazia();
    }
}