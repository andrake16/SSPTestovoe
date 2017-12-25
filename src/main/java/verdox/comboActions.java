package verdox;

import org.openqa.selenium.WebElement;

public class comboActions {

    public static void clickAndType(WebElement el, String text) {
        el.click();
        el.sendKeys(text);
    }
}
