package br.com.library;

import br.com.library.models.Book;
import br.com.library.repository.BookRepository;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationIT extends FluentTest {

    @Autowired
    private BookRepository bookRepository;
    private List<Book> books;
    @Value("${local.server.port}")
    private int serverPort;
    private WebDriver webDriver;

    @Before
    public void setUp() {
        this.books = this.bookRepository.all();
        this.webDriver = new FirefoxDriver();
    }

    private String getUrl() {
        return "http://localhost:" + this.serverPort;
    }

    @Test
    public void hasPageTitle() {
        goTo(getUrl());
        assertThat(find(".page-header").getText()).isEqualTo("A checklist");
    }

    @Test
    public void hasThePredefinedBooks() {
        goTo(getUrl());
        await().atMost(5, TimeUnit.SECONDS).until(".checkbox").hasSize(3);
        assertThat(find(".checkbox").getTexts()).containsOnly(this.books.get(0).getTitle(), this.books.get(1).getTitle());
        assertThat(find(".checkbox").first().find(":checked")).isNotEmpty();
        assertThat(find(".checkbox").get(1).find(":checked")).isEmpty();
    }

    @Override
    public WebDriver getDefaultDriver() {
        return this.webDriver;
    }
}
