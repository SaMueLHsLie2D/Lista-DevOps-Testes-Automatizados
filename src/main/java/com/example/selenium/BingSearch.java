package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Classe responsável por realizar uma busca no Bing
 */
public class BingSearch {

    private WebDriver driver;

    /**
     * Inicializa o WebDriver do Chrome
     */
    public void setupDriver() {
        // Configura o WebDriverManager para gerenciar o driver do Chrome
        WebDriverManager.chromedriver().setup();

        // Configura opções do Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        // Inicializa o driver do Chrome com as opções configuradas
        driver = new ChromeDriver(options);
    }

    /**
     * Navega para a página inicial do Bing
     */
    public void navigateToBing() {
        driver.get("https://www.bing.com/?cc=br");
    }

    /**
     * Realiza uma busca no Bing
     * 
     * @param searchTerm Termo a ser pesquisado
     */
    public void searchOnBing(String searchTerm) {
        // Localiza o campo de busca
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));

        // Limpa o campo de busca e insere o termo de pesquisa
        searchBox.clear();
        searchBox.sendKeys(searchTerm);

        // Submete o formulário de busca
        searchBox.submit();
    }

    /**
     * Aguarda um tempo específico em segundos
     * 
     * @param seconds Tempo em segundos para aguardar
     */
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fecha o navegador
     */
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Executa o fluxo completo: abrir navegador, acessar Bing, pesquisar, aguardar
     * e fechar
     * 
     * @param searchTerm        Termo a ser pesquisado
     * @param waitTimeInSeconds Tempo em segundos para aguardar após a pesquisa
     */
    public void executeSearchFlow(String searchTerm, int waitTimeInSeconds) {
        try {
            setupDriver();
            navigateToBing();
            searchOnBing(searchTerm);
            waitForSeconds(waitTimeInSeconds);
        } finally {
            closeBrowser();
        }
    }

    /**
     * Método principal para execução direta
     * 
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        BingSearch bingSearch = new BingSearch();
        bingSearch.executeSearchFlow("Hello World", 10);
    }
}
