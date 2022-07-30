import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {

    @BeforeSuite
    public void BeforeSuite() {
        Configuration.baseUrl = "https://www.google.ru/";
        Configuration.browser = "chrome";
    }

    @Test
    public void googleTest() {
        var title = "Selenide: лаконичные и стабильные UI тесты на Java";

        open("/");
        $(byName("q")).val("selenide").pressEnter();
        var resultCollection = $$(".LC20lb.MBeuO.DKV0Md");
        resultCollection.shouldHave(size(11));
        $(".LC20lb.MBeuO.DKV0Md", 0).shouldHave(text(title));

    }
}
