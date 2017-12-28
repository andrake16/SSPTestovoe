package verdox;

import ids.Objs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Environment {

    private static Environment environment;
    private static WebDriver webDriver;
    private static JavascriptExecutor javascriptExecutor;
    private static String parentWindowHandler;

    private Environment() {
        System.setProperty("webdriver.gecko.driver", SETTINGS.pathToGeckoDriver + "\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();

        javascriptExecutor = (JavascriptExecutor) webDriver;
        //javascriptExecutor.executeScript("window.focus();");

        Objs.setWebdriver(webDriver);
    }

    private static void getInstance() {
       if(environment == null)
           environment = new Environment();

    }

    public static WebDriver getWebDriver(){
        getInstance();
        return webDriver;
    }

    public static void tearDownWebDriver(){
        if(webDriver != null) {
            //webDriver.close(); //close browser
            webDriver.quit(); //destroy driver
        }
        environment = null;
    }

    public static JavascriptExecutor getJSexecutor() {
        getInstance();
        return javascriptExecutor;
    }

    public static String getParentWindowHandler() {
        return parentWindowHandler;
    }

    public static void setParentWindowHandler(String windowHandler) {
        parentWindowHandler = windowHandler;
    }
}