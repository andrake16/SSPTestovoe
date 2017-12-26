package TestingData;

import TestingData.Classes.OutDoc;

public class OutDocs {

    public static OutDoc OutDoc_0001() {
        OutDoc outDoc = new OutDoc();

        outDoc.setDeliveryType(DeliveryTypes.RussianPost_SimpleMail_get());
        outDoc.setDeliveryDetails("Просто детали доставки");
        outDoc.setType("Письмо");
        outDoc.setFrom("ООО \"Вторая организация\"");
        outDoc.addInputDoc("(б/н) Вх-041/13 от 15.12.2017 Коммерческое предложение на сайт");
        outDoc.addOrg(Orgs.OOO_Sever_get());
        outDoc.addWhoSigns("Колобова Марина Олеговна");
        outDoc.addPerformer("Доронина Светлана Олеговна");
        outDoc.setAdditionalInfo("Просто дополнительная информация");

        return outDoc;

    }

}
