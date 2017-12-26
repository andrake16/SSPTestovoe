package ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import verdox.Environment;

import java.util.List;

public class WaitStates {
    private static int DEFAULT_WAIT_TIME = 2;

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

}
