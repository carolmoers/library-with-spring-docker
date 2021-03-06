package br.com.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class ApplicationIT {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        DesiredCapabilities config = DesiredCapabilities.phantomjs();
        config.setJavascriptEnabled(true);
        config.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY
                , "phantomjs-2.1.1/bin/phantomjs");

        this.webDriver = new PhantomJSDriver(config);
    }

    private String getUrl() {
        return "http://localhost:8080";
    }

    @Test
    public void hasPageTitle() {
        this.webDriver.get(getUrl());
        assertThat(webDriver.getTitle(), is("Library"));
    }

    @Test
    public void hasThePredefinedBooks() {
        this.webDriver.get(getUrl());
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);

        WebElement firstBook = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("book")));

        assertThat(firstBook.getText(), containsString("The Pragmatic Programmer"));
    }

    @After
    public void tearDown() {
        this.webDriver.close();
    }
}
