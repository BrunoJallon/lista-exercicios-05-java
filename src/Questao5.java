import questao5.model.*;

import java.util.List;

void main() {

    //A lista e do tipo Imprimivel, porque todos os documentos podem ser impressos
    List<Imprimivel> documentos = List.of(
            new RelatorioFinanceiro("Outubro", 15000, 9500, "financeiro@empresa.com"),
            new Contrato("Aluguel de sala comercial", "Maria Souza"),
            new RelatorioFinanceiro("Novembro", 12000, 13250, "diretoria@empresa.com")
    );

    //Polimorfismo: cada documento sabe o que fazer em processar(), sem precisar de instanceof
    for (Imprimivel documento : documentos) {
        documento.processar();
        System.out.println();
    }

}
