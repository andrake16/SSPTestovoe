package ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import verdox.ComboActions;
import verdox.Environment;

import java.util.List;
import java.util.Set;

public class WaitStates {
    private static int DEFAULT_WAIT_TIME = 7;

    public static void waitJSdone() {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {

                    Boolean isJSdone = Environment.getJSexecutor().
                            executeScript("return document.readyState").toString().equals("complete");

                    Boolean isJQueryDone = (Boolean) Environment.getJSexecutor().
                            executeScript("return jQuery.active == 0");

                    return isJSdone && isJQueryDone;
                }
        });

    }

    public static void waitAppearsByXpath(final String xpath) {
        System.out.println("wait appears element xpath: " + xpath);
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                List<WebElement> wes = wd.findElements(By.xpath(xpath));
                if(wes.size()>0) {
                    ComboActions.delay();
                    return true;
                }
                return false;

            }
        });

    }


    public static void waitLeftFrameAppears() {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                List<WebElement> wes = wd.findElements(By.xpath(IDs.NaviPage.xpath_LEFT_FRAME));
                if(wes.size()>0)
                    return wes.get(0).getAttribute("name").equals("left");
                return false;

            }
        });
    }

    public static void waitRightFrameAppears() {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                List<WebElement> wes = wd.findElements(By.xpath(IDs.NaviPage.xpath_RIGHT_FRAME));
                if(wes.size()>0)
                    return wes.get(0).getAttribute("name").equals("right");
                return false;

            }
        });
    }

    public static void waitOutDocCreatingFormAppears() {

        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                Objs.switchToRightFrame();
                List<WebElement> wes = wd.findElements(By.xpath(IDs.NaviPage.xpath_OUTDOC_FORM));
                if(wes.size()>0)
                    return true;
                return false;

            }
        });

    }

    public static void waitAutoCompleteListAppears(final Integer autoCompleteSelectorNumberOnPage) {

        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                Objs.switchToRightFrame();
                String listItemsXPath = "//ul[@id='ui-id-%1$s']/li";
                listItemsXPath = String.format( listItemsXPath, autoCompleteSelectorNumberOnPage.toString() );
                List<WebElement> wes = wd.findElements(By.xpath(listItemsXPath));
                if(wes.size()>0)
                    return true;
                return false;

            }
        });

    }


    public static void waitWhileBrowserWindowWillBeTwo() {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {

                    Set<String> handles = wd.getWindowHandles();
                    if( handles.size() > 1 )
                        return true;
                    return false;
            }
        });

    }

    public static void waitWhileBrowserWindowCountWillBe(final int count) {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {

                Set<String> handles = wd.getWindowHandles();
                if( handles.size() == count )
                    return true;
                return false;
            }
        });

    }




}
