import questao4.model.OperacaoMatematica;

void main() {

    //Cada lambda implementa o metodo executar(a, b) da interface funcional
    OperacaoMatematica soma = (a, b) -> a + b;
    OperacaoMatematica subtracao = (a, b) -> a - b;
    OperacaoMatematica multiplicacao = (a, b) -> a * b;
    OperacaoMatematica divisao = (a, b) -> a / b;

    double x = 10;
    double y = 4;

    System.out.printf("%.2f + %.2f = %.2f%n", x, y, soma.executar(x, y));
    System.out.printf("%.2f - %.2f = %.2f%n", x, y, subtracao.executar(x, y));
    System.out.printf("%.2f * %.2f = %.2f%n", x, y, multiplicacao.executar(x, y));
    System.out.printf("%.2f / %.2f = %.2f%n", x, y, divisao.executar(x, y));

}
