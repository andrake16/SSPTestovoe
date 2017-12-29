package ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import verdox.ComboActions;
import verdox.Environment;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static sun.awt.SunToolkit.DEFAULT_WAIT_TIME;

public class WaitPages {

    public static void waitAgreePage() {
        waitPageByAdressPattern(".*/dc.jsp\\?docId=.*&entityClassId=.*");
    }


    public static void waitPageByAdressPattern(final String pattern) {
        (new WebDriverWait(Environment.getWebDriver(), DEFAULT_WAIT_TIME)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return isItMatchPattern( Environment.getWebDriver().getCurrentUrl() , pattern);
            }
        });

    }


    public static boolean isItMatchPattern(String it , String patternString ) {

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(it);
        boolean matches = matcher.matches();

        System.out.println("**Match Pattern**" +
                "\nString: " + it +
                "\nPattern: " + patternString +
                "\nResult: " + matches);

        return  matches;

    }

}
