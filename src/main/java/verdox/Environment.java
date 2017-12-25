package verdox;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Environment {

    private static Environment environment;
    private static WebDriver webDriver;
    private static JavascriptExecutor javascriptExecutor;

    private Environment() {
        System.setProperty("webdriver.gecko.driver", SETTINGS.pathToGeckoDriver + "\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        javascriptExecutor = (JavascriptExecutor) webDriver;
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
            webDriver.close();
            //wd.quit();
        }
    }

    public static JavascriptExecutor getJSexecutor() {
        getInstance();
        return javascriptExecutor;
    }
}