package org.springframework.samples.petclinic.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.HashMap;
import java.util.Map;

@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-core-config.xml", "classpath:spring/mvc-test-config.xml"})
public class FirstTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\env\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void first() throws Exception {
        driver.get("https://pwc-test1-app.azurewebsites.net/petclinic/");
        driver.manage().window().setSize(new Dimension(1936, 1186));
        driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Jeff Black")).click();
    }

}
