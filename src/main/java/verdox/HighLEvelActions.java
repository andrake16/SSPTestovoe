package verdox;

import TestingData.Classes.OutDoc;
import ids.Objs;

public class HighLEvelActions {

    public static void fillOutDocForm(OutDoc outDoc) {

        comboActions.select(Objs.OutDocForm.deliveryTypeSelector(), outDoc.getDeliveryType().getName());
        comboActions.select(Objs.OutDocForm.deliverySubTypeSelector(), outDoc.getDeliveryType().getSubType());
        Objs.OutDocForm.deliveryDetails().sendKeys(outDoc.getDeliveryDetails());
        comboActions.select(Objs.OutDocForm.type(), outDoc.getType());


    }

}
