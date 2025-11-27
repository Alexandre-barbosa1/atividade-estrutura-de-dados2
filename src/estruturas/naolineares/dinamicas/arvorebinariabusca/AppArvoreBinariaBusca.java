package estruturas.naolineares.dinamicas.arvorebinariabusca;

public class AppArvoreBinariaBusca {

    public static void main(String[] args) {

        IArvoreBinariaBusca<Integer> bst = new ArvoreBinariaBusca<>();
        bst.inserir(50);
        bst.inserir(30);
        bst.inserir(70);
        bst.inserir(20);
        bst.inserir(40);

        System.out.println(bst.buscar(30));
        System.out.println(bst.buscar(99));

        bst.remover(30);
        System.out.println(bst.buscar(30));

        // Travessia mostra a ordem de classificação
        bst.percorrerEmOrdem(System.out::println);  // 20, 40, 50, 70

    }

}