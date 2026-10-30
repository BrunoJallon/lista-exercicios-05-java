# Lista 05: Interfaces

## Questão 1

A partir do **Java 8** ficou possível criar métodos com corpo dentro de interfaces, usando `default` e `static`.

O método `default` serve para adicionar um método novo em uma interface sem quebrar as classes que já implementam ela. Antes do Java 8, se um método fosse adicionado em uma interface, todas as classes que a implementavam davam erro de compilação até implementarem esse método. Com o `default`, as classes já recebem uma implementação pronta e só sobrescrevem se precisarem de um comportamento diferente. Foi assim que o próprio Java 8 adicionou o `forEach` em todas as coleções sem quebrar o código que já existia.

O método `static` serve para colocar métodos auxiliares dentro da própria interface, sem precisar criar uma classe separada só para eles. Ele pertence à interface, é chamado pelo nome dela (por exemplo, `List.of(1, 2, 3)`) e não é herdado pelas classes que implementam a interface.

Na questão 5 eu usei um método `default`:

```java
public interface Imprimivel {

    void imprimir();

    default void processar() {
        imprimir();
    }

}
```

Toda classe que implementa `Imprimivel` já ganha o `processar()` pronto. O `RelatorioFinanceiro` sobrescreve esse método para também enviar o relatório por e-mail.

## Questão 2

Uma interface define **o que** uma classe deve fazer, mas não **como**. Quando uma classe depende de uma interface, e não de uma classe concreta, ela não precisa saber qual implementação está sendo usada. Assim, dá para trocar uma implementação por outra, ou criar uma nova, sem mexer no código que usa a interface. Isso deixa o sistema desacoplado e facilita a manutenção, porque cada mudança fica concentrada em uma classe só.

Por exemplo, um sistema de estoque que hoje salva os produtos em um arquivo, mas no futuro vai salvar em um banco de dados:

```java
public interface Armazenamento {
    void salvar(Produto produto);
}

public class ArmazenamentoArquivo implements Armazenamento {
    @Override
    public void salvar(Produto produto) {
        //grava o produto em um arquivo
    }
}

public class ArmazenamentoBancoDeDados implements Armazenamento {
    @Override
    public void salvar(Produto produto) {
        //grava o produto no banco de dados
    }
}

public class Estoque {

    private Armazenamento armazenamento;

    public Estoque(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void cadastrar(Produto produto) {
        armazenamento.salvar(produto);
    }

}
```

A classe `Estoque` só conhece a interface `Armazenamento`. Para trocar o arquivo pelo banco de dados, basta criar o estoque com `new Estoque(new ArmazenamentoBancoDeDados())`, sem alterar nada dentro de `Estoque`. Se `Estoque` usasse direto a classe `ArmazenamentoArquivo`, eu teria que modificar a classe `Estoque` para fazer essa troca.

## Questões 3, 4 e 5

O código está na pasta `src` (Java 25, com `void main()` igual à lista 04).

- **Questão 3** (`Questao3.java` e `questao3/model`): o `Smartphone` implementa as três interfaces. No `main`, o mesmo objeto é usado como navegador, reprodutor de música e telefone. Fazer ou atender uma ligação pausa a música, se ela estiver tocando.
- **Questão 4** (`Questao4.java` e `questao4/model`): cada operação é uma expressão lambda que implementa o método `executar(a, b)`. Como os valores são `double`, dividir por 0 não dá erro: por exemplo, `10 / 0` resulta em `Infinity`.
- **Questão 5** (`Questao5.java` e `questao5/model`): usei polimorfismo em vez de `instanceof`. O `Contrato` usa o `processar()` padrão de `Imprimivel`, que só imprime, e o `RelatorioFinanceiro` sobrescreve para imprimir e enviar por e-mail. Assim o `main` só chama `documento.processar()` e não precisa testar o tipo de cada documento. Se surgir um novo tipo de documento, o `main` continua igual.
