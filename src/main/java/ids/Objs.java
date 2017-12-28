package ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import verdox.Environment;

public class Objs {

    private static WebDriver wd;

    public static void setWebdriver(WebDriver webdriver) {
        wd = webdriver;
    }


    public static void switchToDefaultContext() {
        wd.switchTo().defaultContent();
    }

    public static void switchToRightFrame() {
        switchToDefaultContext();
        WaitStates.waitRightFrameAppears();
        wd.switchTo().frame("right");
    }

    public static void switchToLeftFrame() {
        switchToDefaultContext();
        WaitStates.waitRightFrameAppears();
        wd.switchTo().frame("left");
    }

    public static WebElement byXpath(String xpath) {
        return wd.findElement(By.xpath(xpath));
        //return Environment.getWebDriver().findElement(By.xpath(xpath));
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
            return  byXpath(IDs.OutDocForm.xpath_FROM_INPUT);
        }

        public static WebElement docIncomingTextField() {
            return  byXpath(IDs.OutDocForm.xpath_DOC_INCOMING);
        }

        public static WebElement docIncomingDialogYesBtn() {
            return  byXpath(IDs.OutDocForm.xpath_FILLCARDBY_OUTDOC_YESBTN);
        }

        public static WebElement docIncomingDialogNoBtn() {
            return  byXpath(IDs.OutDocForm.xpath_FILLCARDBY_OUTDOC_NOBTN);
        }

        public static WebElement docNameTextArea() {
            return  byXpath(IDs.OutDocForm.xpath_DOC_NAME);
        }

        public static WebElement addOrgBtn() {
            return  byXpath(IDs.OutDocForm.xpath_ADD_ORG_BTN);
        }

        public static WebElement addOrgNameInput() {
            return  byXpath(IDs.OutDocForm.xpath_ADDORG_NAME_INPUTFIELD);
        }

        public static WebElement addOrgSignerInput() {
            return  byXpath(IDs.OutDocForm.xpath_ADDORG_SIGNER_INPUTFIELD);
        }

        public static WebElement addOrgAdressInput() {
            return  byXpath(IDs.OutDocForm.xpath_ADDORG_ADDRESS_INPUTFIELD);
        }

        public static WebElement whiSignsInput() {
            return  byXpath(IDs.OutDocForm.xpath_WHOSIGNS_INPUT);
        }

        public static WebElement performerInput() {
            return  byXpath(IDs.OutDocForm.xpath_PERFORMER_INPUT);
        }

        public static WebElement whoSignsHref() {
            return  byXpath(IDs.OutDocForm.xpath_WHOSIGNS_HREF);
        }

        public static WebElement performerHref() {
            return  byXpath(IDs.OutDocForm.xpath_PERFORMER_HREF);
        }

        public static WebElement descriptionTextArea() {return byXpath("//textarea[@name='doc.description']");}

        public static WebElement createBtn() {return byXpath("//input[@class='btn'][@value='Создать']"); }




    }

    public static class UsersSelectPopup {

        public static WebElement searchBtn() {
            return byXpath(ids.IDs.UsersSelectPopup.SEARCH_BTN);
        }

        public static WebElement fioSearchField() {
            return byXpath(ids.IDs.UsersSelectPopup.FIO_SEARCH_FIELD);
        }

        public static WebElement specifiedUserInTable(String fio) {
            String fio_xpath = "//tbody/tr/td/a/span[text()='%1$s']";
            fio_xpath = String.format(fio_xpath,fio);
            return byXpath(fio_xpath);
        }


    }

    public static class afterCreateOutDoc {

        public static WebElement editOutDoc() {return byXpath("//span[@id='item_dc_out_edit']"); }

        public static WebElement saveBtn() {return byXpath("//input[@class='btn'][@value='Сохранить']"); }

        public static WebElement toAgreeOutDoc() {return byXpath("//span[@id='item_dc_out_agr_create']"); }

        public static WebElement addAgrPersonBtn() {return byXpath("//input[@class='btn'][@value='Добавить согласующего']"); }

        public static WebElement descriptionTextArea() {return byXpath("//textarea[@name='description']"); }

        public static WebElement sendToAgrBtn() {return byXpath("//input[@class='btn'][@value='Отправить на согласование']"); }
    }

}
