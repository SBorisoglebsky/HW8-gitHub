package guru.qa.tests;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {
    private static final String REPOSITORY = "allure-framework/allure-gradle";

    private WebStepGitHubTest steps = new WebStepGitHubTest();

    @Test
    public void shouldSeeIssueInRepository(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldTextIssues();
        steps.shouldTextIssueName();
    }
}
