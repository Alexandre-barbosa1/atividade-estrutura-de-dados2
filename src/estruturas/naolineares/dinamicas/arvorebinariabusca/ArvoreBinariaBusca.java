package estruturas.naolineares.dinamicas.arvorebinariabusca;

public abstract class ArvoreBinariaBusca<T extends Comparable<T>>
        extends ArvoreBinariaSimples<T>
        implements IArvoreBinariaBusca<T> {

    //Sobrescreve definirNoRaiz para evitar estruturas BST inválidas
    //A validação previne estados iniciais inválidos para árvores binárias de busca (BST)
    @Override
    public void definirNoRaiz(INoArvoreBinaria<T> noRaiz) {
        if (noRaiz != null && !validarArvoreBinariaBusca(noRaiz)) {
            throw new IllegalArgumentException("O nó raiz viola as propriedades de uma árvore binária de busca (BST)");
        }
        super.definirNoRaiz(noRaiz);
    }

    //Valida se é uma árvore ou subárvore é uma árvore binária de busca (BST) válida
    private boolean validarArvoreBinariaBusca(INoArvoreBinaria<T> no) {
        return validarArvoreBinariaBusca(no, null, null);
    }

    private boolean validarArvoreBinariaBusca(INoArvoreBinaria<T> no, T minimo, T maximo) {
        if (no == null) return true;
        T dado = no.obterDado();
        if ((minimo != null && dado.compareTo(minimo) <= 0) ||
                (maximo != null && dado.compareTo(maximo) >= 0)) {
            return false;
        }
        return validarArvoreBinariaBusca(no.obterNoEsquerdo(), minimo, dado) &&
                validarArvoreBinariaBusca(no.obterNoDireito(), dado, minimo);
    }

    @Override
    public INoArvoreBinaria<T> buscar(T dado) {
        return buscar(this.obterNoRaiz(), dado);
    }

    private INoArvoreBinaria<T> buscar(INoArvoreBinaria<T> no, T dado) {
        if (no == null) return null;
        int comparacao = dado.compareTo(no.obterDado());
        if (comparacao < 0) return buscar(no.obterNoEsquerdo(), dado);
        else if (comparacao > 0) return buscar(no.obterNoDireito(), dado);
        else return no;
    }

    @Override
    public void inserir(T dado) {
        if (dado == null) throw new IllegalArgumentException("Dado não pode ser nulo");
        if (this.estaVazia()) {
            super.definirNoRaiz(new NoArvoreBinaria<>(dado));
        } else {
            inserir(this.obterNoRaiz(), dado);
        }
    }

    private void inserir(INoArvoreBinaria<T> no, T dado) {
        int comparacao = dado.compareTo(no.obterDado());
        if (comparacao < 0) {
            if (no.obterNoEsquerdo() == null) {
                no.definirNoEsquerdo(new NoArvoreBinaria<>(dado));
            } else {
                inserir(no.obterNoEsquerdo(), dado);
            }
        } else if (comparacao > 0) {
            if (no.obterNoDireito() == null) {
                no.definirNoDireito(new NoArvoreBinaria<>(dado));
            } else {
                inserir(no.obterNoDireito(), dado);
            }
        }
    }

    @Override
    public void remover(T dado) {
        if (dado == null || this.estaVazia()) return;
        this.definirNoRaiz(remover(this.obterNoRaiz(), dado));
    }

    private INoArvoreBinaria<T> remover(INoArvoreBinaria<T> no, T dado) {
        if (no == null) return null;
        int comparacao = dado.compareTo(no.obterDado());
        if (comparacao < 0) {
            no.definirNoEsquerdo(remover(no.obterNoEsquerdo(), dado));
        } else if (comparacao > 0) {
            no.definirNoDireito(remover(no.obterNoDireito(), dado));
        } else {
            //Nó com apenas um filho ou nenhum filho
            if (no.obterNoEsquerdo() == null) return no.obterNoDireito();
            if (no.obterNoDireito() == null) return no.obterNoEsquerdo();

            //Nó com dois filhos: Obter sucessor em ordem
            T dadoSucessor = encontrarMenorDado(no.obterNoDireito());
            no.definirDado(dadoSucessor);
            no.definirNoDireito(remover(no.obterNoDireito(), dadoSucessor));
        }
        return no;
    }

    private T encontrarMenorDado(INoArvoreBinaria<T> no) {
        return no.obterNoEsquerdo() == null ? no.obterDado() : encontrarMenorDado(no.obterNoEsquerdo());
    }
}

