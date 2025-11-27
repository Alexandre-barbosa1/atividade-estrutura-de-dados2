package estruturas.naolineares.dinamicas.arvorebinariabusca;

import estruturas.naolineares.dinamicas.arvorebinariabusca.IArvoreBinaria;
import estruturas.naolineares.dinamicas.arvorebinariabusca.INoArvoreBinaria;

public interface IArvoreBinariaBusca<T extends Comparable<T>> extends IArvoreBinaria<T> {

    //Buscar um dado em arvóre binária de busca (BST)
    public INoArvoreBinaria<T> buscar(T dado);

    //Insere um dado respeitando a regra de inserção em arvóre binária de busca (BST)
    public void inserir(T dado);

    //Remove um dado respeitando a regra de remoção em arvóre binária de busca (BST)
    public void remover(T dado);

}
