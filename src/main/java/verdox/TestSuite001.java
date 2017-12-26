package verdox;

import TestingData.OutDocs;
import ids.Objs;

import ids.WaitStates;
import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestSuite001 {

    private static final String LOGIN = "dir";
    private static final String PASSWORD = "123";
    private static final String ADDRESS_WEB = "http://demo107140.verdox.ru/107140/navigate.jsp";

    private static java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger("InfoLogging");


    @BeforeSuite
    public void setUp(){
        Objs objs = new Objs();
    }

    @AfterSuite
    public void tearDown() {
        //Environment.tearDownWebDriver();
    }


    @Test(enabled = true, priority = 0, description = "логин в СЭД")
    public void test001() throws Exception {

        Environment.getWebDriver().get(ADDRESS_WEB);
        comboActions.clickAndType( Objs.LoginPage.loginInput(), LOGIN);
        comboActions.clickAndType( Objs.LoginPage.passwdInput(), PASSWORD);
        Objs.LoginPage.submitBtn().click();

        WaitStates.waitLeftFrameAppears();

        Objs.NaviPage.createOutDocBtn().click();
        Objs.switchToDefaultContext();

        WaitStates.waitOutDocCreatingFormAppears();
        HighLEvelActions.fillOutDocForm(OutDocs.OutDoc_0001());







    }





}