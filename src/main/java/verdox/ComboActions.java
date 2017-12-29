package verdox;

import ids.Objs;
import ids.WaitStates;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class ComboActions {

//TODO: add all variants for select value from selectors

    public static void clickAndType(WebElement el, String text) {
        el.click();
        el.sendKeys(Keys.END);
        el.sendKeys(text);
    }

    /**
     *drop down selector with black arrow. without input field
     */
    public static void select(WebElement selectorElement, String textValueForSelect) {
        selectorElement.click();
        selectorElement.findElement(By.xpath("option[text()='"+ textValueForSelect+ "']")).click();
    }

    /**
     * dropdown selector without arrow with input field for filter
     */
    public static void autoCompleteTextField(WebElement inputFieldObj, int autoCompleteSelectorNumberOnPage, String textValueForSelect) {
        inputFieldObj.clear();
        inputFieldObj.sendKeys(textValueForSelect);
        WaitStates.waitAutoCompleteListAppears(autoCompleteSelectorNumberOnPage);
        String listItemXpath = "//ul[@id='ui-id-%1$s']/li/a[contains(text(),'%2$s')]";
        if(textValueForSelect.length()>46)
            textValueForSelect = textValueForSelect.substring(0,45);
        //in autocomplete items max size of name is near 45 chars, so we should cut it. otherwise item element could not be founded
        String replacedListItemXpath = String.format(listItemXpath,autoCompleteSelectorNumberOnPage,textValueForSelect);
        Objs.byXpath(replacedListItemXpath).click();
    }

    /**
     *dropdown selector with black arrow and field for search
     */
    public static void selectWithSearch(WebElement inputField, String textValue) {
        inputField.sendKeys(textValue);
        String dropDownValueXpath = "//div[contains(@id,'widget_uniqName_3_0_')]/div/div/div/div/div/span[text()='%1$s']";
        dropDownValueXpath = String.format(dropDownValueXpath,textValue);
        WaitStates.waitAppearsByXpath(dropDownValueXpath);
        Objs.byXpath(dropDownValueXpath).click();
    }


    public static void swithToLastBrowserWindow() {

        //WaitStates.waitWhileBrowserWindowWillBeTwo();
        delay();
        WebDriver wd = Environment.getWebDriver();

        Environment.setParentWindowHandler(wd.getWindowHandle()); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = wd.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        wd.switchTo().window(subWindowHandler); // switch to popup window

    }

    public static void swithToRootWndAfterClickingInChildWnd() {

        WebDriver wd = Environment.getWebDriver();
        WaitStates.waitWhileBrowserWindowCountWillBe(1);
        //Environment.setParentWindowHandler(wd.getWindowHandle());
        Set<String> handles = wd.getWindowHandles();
        wd.switchTo().window(handles.iterator().next());

    }

    public static void swithToParentBrowserWindow() {
        Environment.getWebDriver().switchTo().window(Environment.getParentWindowHandler());  // switch back to parent window
        delay();
    }

    public static void delay() {
        delay(SETTINGS.DEFAULT_DELAY);
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
