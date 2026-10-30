package questao5.model;

public interface Imprimivel {

    void imprimir();

    //Metodo default: por padrao, processar um documento e so imprimir.
    //As classes que fazem mais coisas (como enviar por e-mail) sobrescrevem
    default void processar() {
        imprimir();
    }

}
