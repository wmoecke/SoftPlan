## Solução: GeradorObservacao
* O método `private String retornaCodigos(List lista)` da classe `GeradorObservacao` original viola um pouco o princípio de responsabilidade única (SRP): a meu ver, todo o bloco de código a partir da linha onde está o comentário `//Acha separador` até onde se fecha o loop `for` poderia estar contido dentro de um outro método, ex., `String achaSeparador(List lista)`, que faria as iterações na lista fornecida como parâmetro e retornaria a String com os valores já devidamente separados. Já no método `private String retornaCodigos(List lista)` a linha `return texto + cod;` seria simplesmente alterada para `return texto + achaSeparador(lista);`.
* Um ponto crítico de tomada de decisão foi sobre qual approach adotar - a meu ver, são dois os caminhos possíveis:
    1. Criar uma subclasse, `GeradorObservacaoCliente`, que herdaria os membros da classe `GeradorObservacao` original, fazendo somente a implementação (_override_) do método acima. Isso resultaria em uma economia de código (DRY).
    1. Criar uma classe desacoplada, cujo corpo seria quase um espelho da classe `GeradorObservacao` original, apenas mudando a implementação do método `public String achaSeparador(List lista)` a fim de atender ao requisito proposto.
* Desvantagens:
    * Em (i), haveria um acoplamento entre as duas classes (pai e filho), acarretando consequências potencialmente "desastrosas"; supondo que algum dia a classe `GeradorObservacao` original fosse alterada, ela "quebraria" a(s) classe(s) filha(s).
    * Em (ii), haveria uma violação do princípio DRY.
    
    Ou seja, adotando-se a solução em (i), cria-se o problema que se resolve com (ii), e vice-versa. A questão passa a ser escolher dentre os dois caminhos, qual "dói" menos. O caminho escolhido foi o de criar uma nova classe `GeradorObservacaoCliente`, mantendo as duas classes desacopladas. Uma interface provê o contrato para implementação do método `public String achaSeparador(List lista)` em ambas (Strategy Pattern).
    
    Assim sendo, foi implementada a interface `GeradorObservacaoInterface` a qual define o contrato para implementação do método `public String achaSeparador(List lista)`. Dessa forma, poder-se-á criar classes separadas que tratem de fazer o _override_ deste método, a cada nova necessidade específica. O que torna o sistema como um todo mais flexível.
    
    Isso posto, outra desvantagem é que não é mais possível deixar os métodos da classe `GeradorObservacao` original totalmente inalterados, pois foi necessário alterar o modificador de acesso original do método `String retornaCodigos(List lista)` de `private` para `public`, para viabilizar o _override_ do método `public String achaSeparador(List lista)`.
    
* Na saída, a string do enunciado pede, conforme exemplo:

    "Fatura da nota fiscal de simples remessa: 1 cujo valor é **R$** 10,00. Total = 10,00."
(Notar que o valor "Total" não é precedido por "_R$_").

    Porém, no código ficou este valor precedido por "_R$_", uma vez que o formatador utilizado na localização dos valores é o mesmo, o qual cumpre não somente a função de colocar os separadores numéricos (milhar, decimal, etc) mas também se encarrega de preceder cada valor com o indicador da moeda local. Se fosse requerimento absoluto que apenas o valor total não fosse precedido pelo "_R$_", então seria necessário uma outra instância do formatador, com parâmetros ligeiramente diferentes, armazenada em uma variável separada.
