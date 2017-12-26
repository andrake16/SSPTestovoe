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

    public static void switchToRightFrame() {
        switchToDefaultContext();
        wd.switchTo().frame("right");
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

    public static class OutDocForm {
        public static WebElement deliveryTypeSelector() {
            return  byXpath(IDs.OutDocForm.xpath_DELIVERY_TYPE_SELECTOR);
        }

        public static WebElement deliverySubTypeSelector() {
            return  byXpath(IDs.OutDocForm.xpath_DELIVERY_SUBTYPE_SELECTOR);
        }

        public static WebElement deliveryDetails() {
            return  byXpath(IDs.OutDocForm.xpath_DELIVERY_DETAILS);
        }

        public static WebElement type() {
            return  byXpath(IDs.OutDocForm.xpath_TYPE);
        }

        public static WebElement addCustomTypeBtn() {
            return  byXpath(IDs.OutDocForm.xpath_ADD_CUSTOM_TYPE_BTN);
        }

        public static WebElement fromTextField() {
            return  byXpath(IDs.OutDocForm.xpath_FROM);
        }

    }




}
