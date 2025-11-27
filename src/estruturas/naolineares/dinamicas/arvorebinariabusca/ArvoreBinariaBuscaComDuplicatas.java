package estruturas.naolineares.dinamicas.arvorebinariabusca;

public class ArvoreBinariaBuscaComDuplicatas<T extends Comparable<T>> extends ArvoreBinariaBusca<T> {

    @Override
    public void inserir(T dado) {
        //Implemente o codigo para permitir valores duplicados (valores duplicados vão para a sub-árvore esquerda)
    }

    public int contarOcorrencias(T dado) {
        //Implemente a contagem recursiva de ocorrências
    }

    @Override
    protected boolean validarArvoreBinariaBusca(INoArvoreBinaria<T> no, T minimo, T maximo) {
        //Refatore para a validação da nova regra de duplicatas
    }

}