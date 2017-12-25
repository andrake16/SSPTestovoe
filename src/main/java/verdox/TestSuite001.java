package verdox;

import ids.Objs;

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
        Environment.tearDownWebDriver();
    }


    @Test(enabled = true, priority = 0, description = "логин в СЭД")
    public void test001() throws Exception {
        Environment.getWebDriver().get(ADDRESS_WEB);
        Objs.LoginPage.loginInput().click();
        Objs.LoginPage.loginInput().sendKeys(LOGIN);
    }





}