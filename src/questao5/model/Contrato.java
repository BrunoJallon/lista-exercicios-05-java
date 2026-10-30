package questao5.model;

public class Contrato implements Imprimivel {

    private String descricao;
    private String cliente;

    public Contrato(String descricao, String cliente) {
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public void imprimir() {
        System.out.println("[Impressao] Contrato: " + descricao);
        System.out.println("  Cliente: " + cliente);
    }

    //Nao sobrescreve processar(): usa o default de Imprimivel, que so imprime

}
