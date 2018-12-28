import com.codeborne.selenide.WebDriverRunner;
import com.gsmserver.pages.HomePage;
import com.gsmserver.testbase.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@RunWith(Parameterized.class)
public class HomePageTest extends TestBase {
    private String query;

    public HomePageTest(String query){
        this.query = query;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[] {"Octoplus Pro Box", "Battery Activation Cable for Apple", "Power Supply Test"};
    }

    @Before
    public void setBrowser(){
         initialization();
    }

    @Test
    public void searchProductOnPage(){
        HomePage page = open("https://gsmserver.com", HomePage.class);
        page.searchFor(query);
        $$(By.xpath("//ul[@class='product-list-wrapper product-view-list']//li")).shouldHave(size(20));
        $(By.xpath("//ul[@class='product-list-wrapper product-view-list']//li")).shouldHave(text(query));
    }

    @After
    public void tearDown (){
        WebDriverRunner.getWebDriver().close();
    }
}
