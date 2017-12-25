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

    public static void switchToDefaultContext() {
        wd.switchTo().defaultContent();
    }

    public static WebElement byXpath(String xpath) {
        return wd.findElement(By.xpath(xpath));
    }


    public static class LoginPage {

        public static WebElement loginInput()  { return byXpath(IDs.LoginPage.xpath_LOGIN);  };
        public static WebElement passwdInput() { return byXpath(IDs.LoginPage.xpath_PASSWD); };
        public static WebElement submitBtn()    { return byXpath(IDs.LoginPage.xpath_SUBMIT_BTN); };

    }

    public static class NaviPage {
        public static WebElement createOutDocBtn() {
            wd.switchTo().frame("left");
            return byXpath(IDs.NaviPage.xpath_LPANEL_CREATE_OUT_DOC);
        }
    }




}
