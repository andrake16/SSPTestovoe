package verdox;

import TestingData.OutDocs;
import TestingData.Users;
import ids.IDs;
import ids.Objs;

import ids.WaitStates;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.ArrayList;
import java.util.Arrays;


public class TestSuite001 {

    @BeforeSuite
    public void setUp(){

    }

    @AfterSuite
    public void tearDown() {
        //Environment.tearDownWebDriver();
    }

    @BeforeMethod
    public void beforeTest() {

    }

    @AfterMethod
    public void afterTest() {
       // Environment.tearDownWebDriver();
    }

    @Test(enabled = true, priority = 0, description = "логин в СЭД и создание исходящего документа, редактируем, отправляем на согласование")
    public void test001() {

        Environment.getWebDriver().get(SETTINGS.ADDRESS_WEB);
        HighLEvelActions.loginByUser(Users.dir());

        Objs.NaviPage.createOutDocBtn().click();
        Objs.switchToDefaultContext();

        WaitStates.waitOutDocCreatingFormAppears();
        HighLEvelActions.fillOutDocForm(OutDocs.OutDoc_0001());
        HighLEvelActions.editOutDocAfterCreate();
        HighLEvelActions.sendToAgr(Arrays.asList(Users.zamdir2(), Users.yurist()),
                "Описание отправления на согласование");

        Environment.tearDownWebDriver(); //temporary for debug next test

    }

    @Test(enabled = true, priority = 1, description = "логин согласующими и согласуем исходящий документ")
    public void test002() {
        Environment.getWebDriver().get(SETTINGS.ADDRESS_WEB);
        HighLEvelActions.loginByUser(Users.zamdir2());


    }





}