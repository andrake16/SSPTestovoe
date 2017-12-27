package verdox;

import ids.Objs;
import ids.WaitStates;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class comboActions {

//TODO: add all variants for select value from selectors

    public static void clickAndType(WebElement el, String text) {
        el.click();
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
        String dropDownValueXpath = "//div[@id=\"widget_uniqName_3_0_organizationId_dropdown\"]/div/div/div/div/div/span[text()='%1$s']";
        dropDownValueXpath = String.format(dropDownValueXpath,textValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Objs.byXpath(dropDownValueXpath).click();
    }
}
