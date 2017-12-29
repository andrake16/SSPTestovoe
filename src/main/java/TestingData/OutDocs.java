package TestingData;

import TestingData.Classes.OutDoc;

import java.util.ArrayList;
import java.util.List;

public class OutDocs {
    //need to store changed/edited fields of outDoc between tests
    private final static int arrSize = 1;
    private static OutDoc[] outDocArr = new OutDoc[arrSize];

    public static OutDoc OutDoc_0001() {

        if(outDocArr[0] == null) {
            OutDoc outDoc = new OutDoc();

            outDoc.setDeliveryType(DeliveryTypes.RussianPost_SimpleMail_get());
            outDoc.setDeliveryDetails("Просто детали доставки");
            outDoc.setType("Письмо");
            outDoc.setFrom("ООО \"Вторая организация\"");
            outDoc.addIncomingDoc("(б/н) Вх-041/13 от 15.12.2017 Коммерческое предложение на сайт");
            outDoc.setName("Outgoing_Doc_0001_" + utils.common.getCurrentTimeStamp());
            outDoc.addOrg(Orgs.OOO_Sever_get());
            outDoc.addWhoSigns("Колобова Марина Олеговна");
            outDoc.addPerformer("Доронина Светлана Олеговна");
            outDoc.setAdditionalInfo("Просто дополнительная информация");

            outDocArr[0] = outDoc;
        }

        return outDocArr[0];

    }

    public static void resetEditedDataToDefault() {
        outDocArr = null;
        outDocArr = new OutDoc[arrSize];
    }

}
