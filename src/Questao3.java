import questao3.model.*;

void main() {

    Smartphone celular = new Smartphone("Moto G84");

    //O mesmo objeto pode ser usado como qualquer uma das interfaces que ele implementa
    NavegadorInternet navegador = celular;
    ReprodutorMusical reprodutor = celular;
    AparelhoTelefonico telefone = celular;

    System.out.println("=== Navegando na internet ===");
    navegador.exibirPagina();
    navegador.adicionarNovaAba();
    navegador.exibirPagina();

    System.out.println("\n=== Ouvindo musica ===");
    reprodutor.tocar();

    //Como e o mesmo objeto, atender a ligacao pausa a musica
    System.out.println("\n=== Recebendo uma ligacao ===");
    telefone.atender();

    System.out.println("\n=== Voltando para a musica ===");
    reprodutor.tocar();
    reprodutor.pausar();

    System.out.println("\n=== Fazendo uma ligacao ===");
    telefone.ligar();

}
