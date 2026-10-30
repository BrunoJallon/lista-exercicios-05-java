package questao5.model;

public class RelatorioFinanceiro implements Imprimivel, EnviavelPorEmail {

    private String mes;
    private double receitas;
    private double despesas;
    private String emailDestino;

    public RelatorioFinanceiro(String mes, double receitas, double despesas, String emailDestino) {
        this.mes = mes;
        this.receitas = receitas;
        this.despesas = despesas;
        this.emailDestino = emailDestino;
    }

    public String getMes() {
        return mes;
    }

    public double getReceitas() {
        return receitas;
    }

    public double getDespesas() {
        return despesas;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public double calcularSaldo() {
        return receitas - despesas;
    }

    @Override
    public void imprimir() {
        System.out.println("[Impressao] Relatorio financeiro de " + mes);
        System.out.printf("  Receitas: R$ %.2f%n", receitas);
        System.out.printf("  Despesas: R$ %.2f%n", despesas);
        System.out.printf("  Saldo:    R$ %.2f%n", calcularSaldo());
    }

    @Override
    public void enviar(String email) {
        System.out.println("[E-mail] Relatorio de " + mes + " enviado para " + email);
    }

    //Sobrescreve o default de Imprimivel: alem de imprimir, envia por e-mail
    @Override
    public void processar() {
        imprimir();
        enviar(emailDestino);
    }

}
