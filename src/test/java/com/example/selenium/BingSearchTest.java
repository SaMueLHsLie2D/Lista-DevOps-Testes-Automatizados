package com.example.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

/**
 * Testes para a classe BingSearch
 */
public class BingSearchTest {

    private BingSearch bingSearch;

    @BeforeEach
    public void setUp() {
        bingSearch = new BingSearch();
    }

    @AfterEach
    public void tearDown() {
        // Garantir que o navegador seja fechado após cada teste
        if (bingSearch != null) {
            bingSearch.closeBrowser();
        }
    }

    @Test
    public void testBingSearch() {
        // Executa o fluxo completo de busca no Bing
        bingSearch.executeSearchFlow("Hello World", 10);
    }
}
