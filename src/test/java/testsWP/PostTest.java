package testsWP;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.wordpress.HomePage;

public class PostTest extends TestBase {
    String header ="Заголовок";
    String text="Текст статьи";
    private static final By PUBLISH_ARTICLE = By.xpath("//button[contains(@class, 'components-button editor-post-publish-panel__toggle')]");
    private static final By PUBLISH_ARTICLE_IN = By.xpath("//button[contains(@class, 'components-button editor-post-publish-button')]");
    private static final By VIEW_POST = By.xpath("//div[contains(@class, 'post-publish-panel__postpublish-buttons')]/a[contains(@class, 'components-button')]");
    private static final By POST_HEADER = By.xpath("//article[contains(@id,'post')]/header");
    private static final By POST_CONTENT = By.xpath("//article[contains(@id,'post')]/div[@class='entry-content']");

    @Test
    @Parameters({"login", "password"})
    public void postSuccsess(String login, String password){
        HomePage homepage = new HomePage(driver);
        homepage.goToMainPage()
                .goToLoginPage()
                .loginEnter(login, password)
                .goToPostPage()
                .addArticle(header, text);

    }
}
