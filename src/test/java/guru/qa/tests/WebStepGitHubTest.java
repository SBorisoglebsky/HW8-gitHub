package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebStepGitHubTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий [{repository}]")
    public void searchForRepository(String repository){
        $(".header-search-input").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий [{repository}]")
    public void goToRepository(String repository){
        $(linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openIssuesTab(){
        $$(".js-repo-nav li").findBy(text("Issues")).click();
    }

    @Step("Проверяем что мы в разделе Issues")
    public void shouldTextIssues(){
        $(byText("Issues")).should(Condition.exist);
    }

    @Step("Проверяем искомого [{issue_name}]")
    public void shouldTextIssueName(){
        $$("div[aria-label='Issues']").findBy(text("JCenter sundown")).shouldBe(visible);
    }
}
