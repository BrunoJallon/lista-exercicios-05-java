package questao3.model;

//Uma classe pode implementar varias interfaces ao mesmo tempo
public class Smartphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private String modelo;
    private int abasAbertas;
    private boolean tocandoMusica;

    public Smartphone(String modelo) {
        this.modelo = modelo;
        this.abasAbertas = 1;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAbasAbertas() {
        return abasAbertas;
    }

    public boolean isTocandoMusica() {
        return tocandoMusica;
    }

    @Override
    public void ligar() {
        //Se tiver musica tocando, pausa antes da ligacao
        if (tocandoMusica) {
            pausar();
        }
        System.out.println(modelo + " esta ligando...");
    }

    @Override
    public void atender() {
        if (tocandoMusica) {
            pausar();
        }
        System.out.println(modelo + " atendeu a ligacao.");
    }

    @Override
    public void exibirPagina() {
        System.out.println(modelo + " exibe a pagina. (abas abertas: " + abasAbertas + ")");
    }

    @Override
    public void adicionarNovaAba() {
        abasAbertas++;
        System.out.println(modelo + " abriu uma nova aba. (abas abertas: " + abasAbertas + ")");
    }

    @Override
    public void tocar() {
        tocandoMusica = true;
        System.out.println(modelo + " esta tocando musica.");
    }

    @Override
    public void pausar() {
        if (!tocandoMusica) {
            System.out.println(modelo + " nao esta tocando nenhuma musica.");
            return;
        }
        tocandoMusica = false;
        System.out.println(modelo + " pausou a musica.");
    }

}
