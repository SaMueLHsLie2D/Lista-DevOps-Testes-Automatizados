# Selenium Bing Project

Este projeto demonstra a automação de testes usando Java e Selenium WebDriver para interagir com o site de busca Bing.

## Descrição

O projeto consiste em um script de automação que:
1. Abre o navegador Google Chrome
2. Navega até a página inicial do Bing (https://www.bing.com/?cc=br)
3. Pesquisa o termo "Hello World" na caixa de busca
4. Aguarda 10 segundos após a exibição dos resultados
5. Fecha o navegador automaticamente

## Tecnologias Utilizadas

- Java 11
- Maven
- Selenium WebDriver
- JUnit 5
- WebDriverManager

## Estrutura do Projeto

```
selenium-bing-project/
├── src/
│   ├── main/java/com/example/selenium/
│   │   └── BingSearch.java
│   └── test/java/com/example/selenium/
│       └── BingSearchTest.java
├── pom.xml
├── README.md
├── .gitignore
└── LICENSE
```

## Como Executar

1. Certifique-se de ter o JDK 11 (ou superior) e o Maven instalados
2. Clone este repositório
3. Execute o comando: `mvn clean test`

## Observações

- O WebDriverManager gerencia automaticamente o driver do Chrome, não sendo necessário baixá-lo manualmente
- O teste utiliza o padrão de projeto Page Object para melhor organização e manutenção

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.
