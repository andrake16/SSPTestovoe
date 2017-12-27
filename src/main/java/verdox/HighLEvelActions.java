package verdox;

import TestingData.Classes.Org;
import TestingData.Classes.OutDoc;
import ids.Objs;

public class HighLEvelActions {

    public static void fillOutDocForm(OutDoc outDoc) {

        //TODO: add checking result of actions
        comboActions.select(Objs.OutDocForm.deliveryTypeSelector(), outDoc.getDeliveryType().getName());
        comboActions.select(Objs.OutDocForm.deliverySubTypeSelector(), outDoc.getDeliveryType().getSubType());
        Objs.OutDocForm.deliveryDetails().sendKeys(outDoc.getDeliveryDetails());
        comboActions.select(Objs.OutDocForm.type(), outDoc.getType());

        comboActions.autoCompleteTextField(Objs.OutDocForm.fromTextField(),1,outDoc.getFrom());
        //TODO: support more than one doc
        for(String inputDoc : outDoc.getInputDocList()) {
            comboActions.autoCompleteTextField(Objs.OutDocForm.docIncomingTextField(), 2, inputDoc);
            Objs.OutDocForm.docIncomingDialogNoBtn().click();
        }

        Objs.OutDocForm.docNameTextArea().sendKeys(outDoc.getName());

        Objs.OutDocForm.addOrgBtn().click();
        //TODO: support more than one org
        for(Org org : outDoc.getOrgs()) {
            comboActions.selectWithSearch(Objs.OutDocForm.addOrgNameInput(), org.getName() );
            comboActions.selectWithSearch(Objs.OutDocForm.addOrgSignerInput(), org.getCorrespondencyReciever() );
            comboActions.selectWithSearch(Objs.OutDocForm.addOrgAdressInput(), org.getAdress() );
        }

        //TODO: support more than one person
        for(String whoSigns : outDoc.getWhoSignsList()) {
            Objs.OutDocForm.whoSignsHref().click();
            comboActions.swithToLastBrowserWindow();
            Objs.UsersSelectPopup.fioSearchField().sendKeys(whoSigns.substring(0,7));//search by full fio not works correctly
            Objs.UsersSelectPopup.searchBtn().click();
            Objs.UsersSelectPopup.specifiedUserInTable(whoSigns).click();
        }






    }

}

