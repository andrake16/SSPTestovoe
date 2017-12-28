package verdox;

import TestingData.Classes.Org;
import TestingData.Classes.OutDoc;
import TestingData.OutDocs;
import ids.IDs;
import ids.Objs;
import ids.WaitStates;

import java.util.List;

public class HighLEvelActions {

    public static void fillOutDocForm(OutDoc outDoc) {

        //TODO: add checking result of actions
        ComboActions.select(Objs.OutDocForm.deliveryTypeSelector(), outDoc.getDeliveryType().getName());
        ComboActions.select(Objs.OutDocForm.deliverySubTypeSelector(), outDoc.getDeliveryType().getSubType());
        Objs.OutDocForm.deliveryDetails().sendKeys(outDoc.getDeliveryDetails());
        ComboActions.select(Objs.OutDocForm.type(), outDoc.getType());

        ComboActions.autoCompleteTextField(Objs.OutDocForm.fromTextField(),1,outDoc.getFrom());
        //TODO: support more than one doc
        for(String inputDoc : outDoc.getInputDocList()) {
            ComboActions.autoCompleteTextField(Objs.OutDocForm.docIncomingTextField(), 2, inputDoc);
            Objs.OutDocForm.docIncomingDialogNoBtn().click();
        }

        Objs.OutDocForm.docNameTextArea().sendKeys(outDoc.getName());

        Objs.OutDocForm.addOrgBtn().click();
        //TODO: support more than one org
        for(Org org : outDoc.getOrgs()) {
            ComboActions.selectWithSearch(Objs.OutDocForm.addOrgNameInput(), org.getName() );
            ComboActions.selectWithSearch(Objs.OutDocForm.addOrgSignerInput(), org.getCorrespondencyReciever() );
            ComboActions.selectWithSearch(Objs.OutDocForm.addOrgAdressInput(), org.getAdress() );
        }

        //TODO: support more than one person
        for(String whoSigns : outDoc.getWhoSignsList()) {
            Objs.OutDocForm.whoSignsHref().click();
            selectUsersFromPopupWindow(whoSigns);
        }

        //TODO: support more than one performer to add
        for(String performer : outDoc.getPerformerList()) {
            Objs.OutDocForm.performerHref().click();
            selectUsersFromPopupWindow(performer);
        }

        Objs.OutDocForm.descriptionTextArea().sendKeys(outDoc.getAdditionalInfo());
        Objs.OutDocForm.createBtn().click();

        ComboActions.delay();
        Objs.switchToDefaultContext();
        WaitStates.waitAppearsByXpath(IDs.AfterCreateOutDoc.xpath_OUTDOC_AFTERCREATE_FRAME);

    }

    public static void selectUsersFromPopupWindow(String fio) {
        ComboActions.swithToLastBrowserWindow();
        Objs.UsersSelectPopup.fioSearchField().sendKeys(fio.substring(0,7));//search by full fio not works correctly
        Objs.UsersSelectPopup.searchBtn().click();
        Objs.UsersSelectPopup.specifiedUserInTable(fio).click();
        WaitStates.waitWhileBrowserWindowCountWillBe(1);
        ComboActions.swithToParentBrowserWindow();
        Objs.switchToRightFrame();
        ComboActions.delay();
        WaitStates.waitJSdone();
    }

    public static void editOutDocAfterCreate() {
        Objs.switchToLeftFrame();
        Objs.afterCreateOutDoc.editOutDoc().click();
        Objs.switchToRightFrame();
        WaitStates.waitJSdone();
        ComboActions.clickAndType( Objs.OutDocForm.docNameTextArea(), "in process");
        OutDocs.OutDoc_0001().setName(OutDocs.OutDoc_0001().getName() + "in process");
        Objs.afterCreateOutDoc.saveBtn().click();
        Objs.switchToDefaultContext();
        WaitStates.waitJSdone();

    }

    public static void sendToAgr(List<String> agrPersonList, String comments) {

        Objs.switchToLeftFrame();
        Objs.afterCreateOutDoc.toAgreeOutDoc().click();
        Objs.switchToDefaultContext();
        WaitStates.waitJSdone();
        ComboActions.swithToLastBrowserWindow();
        Objs.switchToRightFrame();
        WaitStates.waitJSdone();

        for(String fio : agrPersonList) {
            Objs.afterCreateOutDoc.addAgrPersonBtn().click();
            HighLEvelActions.selectUsersFromPopupWindow(fio);
        }

        //Objs.switchToRightFrame();
        //WaitStates.waitJSdone();
        ComboActions.clickAndType(Objs.afterCreateOutDoc.descriptionTextArea(),comments);

        Objs.afterCreateOutDoc.sendToAgrBtn().click();

        Environment.getWebDriver().switchTo().alert().accept();

    }
}

