package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class GitHubTest {

    private static final String REPOSITORY = "allure-framework/allure-gradle";
    private static final String ISSUE_NAME = "JCenter sundown";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void searchIssueName() {
        open("");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY).submit();

        $(linkText(REPOSITORY)).click();

        $(".js-repo-nav").find(byText("Issues")).click();
        //проверка, что вкладка существет
        $("span[data-content='Issues']").shouldBe(visible);
        //Проверка искомого ISSUE_NAME
        $$("div[aria-label='Issues']").findBy(text(ISSUE_NAME)).shouldBe(visible);
    }
}
