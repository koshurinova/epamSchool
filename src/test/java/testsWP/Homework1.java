import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;



public class Homework1 {
    public WebDriver driver;
    private String login="admin";
    private String password="secret";
    private String text_header="Статья_new";
    private String text_content="Статья текст";

    //Варианты считывания контента из файла
//    String contents = readUsingFiles("C:/Users/Svatlana/Desktop/Тестирование/КурсJava/epamschool/tools/article.txt");
    String contents = (readUsingBufferedReader("C:/Users/Svatlana/Desktop/Тестирование/КурсJava/epamschool/tools/article.txt"));


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Homework1 homework1 = (Homework1) o;

        return contents.equals(homework1.contents);
    }

    @Override
    public int hashCode() {
        return contents.hashCode();
    }

    //Записи
    private static final By NEW_POST = By.xpath("//li[@id='menu-posts' and contains(@class, 'wp-has-submenu')]/a[contains(@class, 'wp-has-submenu')]");
    //Добавить новую запись
    private static final By ADD_POST = By.xpath("//a[contains(@class, 'page-title-action')]");
    private static final By MESSAGE = By.cssSelector("button.components-button.components-icon-button.nux-dot-tip__disable > svg.dashicon.dashicons-no-alt");
    private static final By HEADER_ARTICLE = By.xpath("//textarea[@id='post-title-0']");
    private static final By CONTENT_ARTICLE = By.xpath("//div[contains(@class, 'editor-block-list__layout')]");
    private static final By CONTENT_ARTICLE_IN = By.xpath("//p[contains(@class, 'wp-block-paragraph')]");
    private static final By PUBLISH_ARTICLE = By.xpath("//button[contains(@class, 'components-button editor-post-publish-panel__toggle')]");
    private static final By PUBLISH_ARTICLE_IN = By.xpath("//button[contains(@class, 'components-button editor-post-publish-button')]");
    private static final By VIEW_POST = By.xpath("//div[contains(@class, 'post-publish-panel__postpublish-buttons')]/a[contains(@class, 'components-button')]");
    private static final By POST_HEADER = By.xpath("//article[contains(@id,'post')]/header");
    private static final By POST_CONTENT = By.xpath("//article[contains(@id,'post')]/div[@class='entry-content']");

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader (fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
    public Homework1() throws IOException {
    }


        @BeforeSuite
    public void precondition() {
        System.setProperty("webdriver.chrome.driver","/tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost/wordpress/wp-login.php");
    }

    @Test //потом перенести в TestBase или прекондишн

    public void authorizationTest(){
        driver.findElements(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).clear();
        driver.findElement(By.id("user_login")).sendKeys(login);
        driver.findElement(By.id("user_pass")).clear();
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account' and contains(@class, 'menupop')]/a[contains(@class, 'ab-item')]")).getText(), "Привет, "+login);
    }

    @Test
    public void addArticle()  {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationTest();

//        driver.findElement(By.id("user_login")).sendKeys(login);
//        driver.findElement(By.id("user_pass")).sendKeys(password);
//        driver.findElement(By.id("wp-submit")).click();

        //Добавление статьи
        driver.findElement(NEW_POST).click();
        driver.findElement(ADD_POST).click();
        driver.findElement(MESSAGE).click();
        driver.findElement(HEADER_ARTICLE).sendKeys(text_header);
        driver.findElement(CONTENT_ARTICLE).click();
//        driver.findElement(CONTENT_ARTICLE_IN).sendKeys(text_content);

        //если загрузка из файла
        driver.findElement(CONTENT_ARTICLE_IN).sendKeys(contents);
        driver.findElement(PUBLISH_ARTICLE).click();
        driver.findElement(PUBLISH_ARTICLE_IN).click();

        //Проверка добавленной статьи
        driver.findElement(VIEW_POST).click();
        String post_header=driver.findElement(POST_HEADER).getText();
        System.out.println("заголовок "+post_header);
        Assert.assertEquals(post_header, text_header);
        String post_content=driver.findElement(POST_CONTENT).getText();
        System.out.println("контент "+post_content);

        //Если сравниваем с текстом из переменной
        Assert.assertEquals(post_content, text_content);

        //если сравниваем загрузку из файла
//        Assert.assertFalse(post_content.equals(contents));

    }

@AfterSuite
public void postcondition() {
        driver.quit();
    }


}
