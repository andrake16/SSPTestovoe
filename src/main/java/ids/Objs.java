package ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import verdox.Environment;


public class Objs {

    private static WebDriver wd;

    public Objs() {
        wd = Environment.getWebDriver();

    }

    private static WebElement byXpath(String xpath) {
        return wd.findElement(By.xpath(xpath));
    }


    public static class LoginPage {
        public static WebElement loginInput() {
            return byXpath(IDs.LoginPage.xpath_LOGIN);
        };
    }
}
