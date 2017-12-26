package TestingData;

import TestingData.Classes.DeliveryType;

public class DeliveryTypes {

    public static DeliveryType RussianPost_SimpleMail_get() {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setName("Почта России");
        deliveryType.setSubType("Простое письмо");
        return deliveryType;
    }

    public static DeliveryType Other_Faximile_get() {
        DeliveryType deliveryType = new DeliveryType();
        deliveryType.setName("Прочие");
        deliveryType.setSubType("Факс");
        return deliveryType;
    }
}
