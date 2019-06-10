package pages.wordpress;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PostPage extends BasePage {


    private static final By NEW_POST = By.xpath("//li[@id='menu-posts' and contains(@class, 'wp-has-submenu')]/a[contains(@class, 'wp-has-submenu')]");
    private static final By ADD_POST = By.xpath("//a[contains(@class, 'page-title-action')]");
    private static final By MESSAGE = By.cssSelector("button.components-button.components-icon-button.nux-dot-tip__disable > svg.dashicon.dashicons-no-alt");
    private static final By HEADER_ARTICLE = By.xpath("//textarea[@id='post-title-0']");
    private static final By CONTENT_ARTICLE = By.xpath("//div[contains(@class, 'editor-block-list__layout')]");
    private static final By CONTENT_ARTICLE_IN = By.xpath("//p[contains(@class, 'wp-block-paragraph')]");


    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void addArticle(String text_header, String text_content)  {

        click(NEW_POST);
        click(ADD_POST);
        click(MESSAGE);
        writeText(HEADER_ARTICLE, text_header);
        click(CONTENT_ARTICLE);
        writeText(CONTENT_ARTICLE_IN,text_content);

    }
}
