package verdox;

import ids.Objs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class comboActions {

    public static void clickAndType(WebElement el, String text) {
        el.click();
        el.sendKeys(text);
    }

    public static void select(WebElement selectorElement, String textValueForSelect) {
        selectorElement.click();
        selectorElement.findElement(By.xpath("option[text()='"+ textValueForSelect+ "']")).click();
    }
}
