package TestingData;

import TestingData.Classes.Org;

public class Orgs {

    public static Org OOO_Sever_get() {
        Org org = new Org();
        org.setName("ООО \"Север\"");
        org.setCorrespondencyReciever("Неизвестный Александр Васильевич");
        org.setAdress("ул. Новосибирская 23");
        return org;
    }

    public static Org OOO_South_get() {
        Org org = new Org();
        org.setName("ООО \"Юг\"");
        org.setCorrespondencyReciever("Смирнов Вадим Вадимович");
        org.setAdress("Новгородская 61/5 каб. 555");
        return org;
    }
}
