package estruturas.naolineares.dinamicas.arvorebinaria;

public class NoArvoreBinaria<T> implements INoArvoreBinaria<T> {

    private T dado;
    private INoArvoreBinaria<T> noEsquerdo;
    private INoArvoreBinaria<T> noDireito;

    public NoArvoreBinaria(T dado){
        this.dado = dado;
    }

    @Override
    public T obterDado() {
        return this.dado;
    }

    @Override
    public void definirDado(T dado) {
        this.dado = dado;
    }

    @Override
    public INoArvoreBinaria<T> obterNoEsquerdo() {
        return this.noEsquerdo;
    }

    @Override
    public void definirNoEsquerdo(INoArvoreBinaria<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    @Override
    public INoArvoreBinaria<T> obterNoDireito() {
        return this.noDireito;
    }

    @Override
    public void definirNoDireito(INoArvoreBinaria<T> noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public int tamanho(){
        int tamanhoSubArvoreEsquerda = (this.obterNoEsquerdo() != null) ? this.obterNoEsquerdo().tamanho() : 0;
        int tamanhoSubArvoreDireita = (this.obterNoDireito() != null) ? this.obterNoDireito().tamanho() : 0;
        return 1 + tamanhoSubArvoreEsquerda + tamanhoSubArvoreDireita;
    }

    @Override
    public int altura() {
        int alturaNoEsquerdo = this.obterNoEsquerdo() == null ? -1 : this.obterNoEsquerdo().altura();
        int alturaNoDireito = this.obterNoDireito() == null ? -1 : this.obterNoDireito().altura();
        return 1 + Math.max(alturaNoEsquerdo, alturaNoDireito);
    }

    @Override
    public int grau() {
        int grau = 0;
        if (this.obterNoEsquerdo() != null) grau++;
        if (this.obterNoDireito() != null) grau++;
        return grau;
    }

}
