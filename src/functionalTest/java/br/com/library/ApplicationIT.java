package br.com.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ApplicationIT{

    private WebDriver webDriver;

    @Before
    public void setUp() {
        this.webDriver = new FirefoxDriver();
    }

    private String getUrl() {
        return "http://localhost:8080";
    }

    @Test
    public void hasPageTitle() {
        this.webDriver.get(getUrl());
        assertThat(webDriver.getTitle()).isEqualTo("Library");
    }

    @Test
    public void hasThePredefinedBooks() {
        this.webDriver.get(getUrl());
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);

        WebElement firstBook = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("book")));

        assertThat(firstBook.getText()).contains("The Pragmatic Programmer");
    }

    @After
    public void tearDown() {
        this.webDriver.close();
    }
}
