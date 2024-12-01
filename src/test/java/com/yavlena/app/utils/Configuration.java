package com.yavlena.app.utils;

import com.yavlena.app.pages.BrokersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Configuration {
    public static WebDriver driver;
    public WebDriverWait wait;
    public final int TIMEOUT=5;
    public BrokersPage brokersPage;

    public static WebDriver driver(ITestContext testContext) {
        return driver;
    }

    @Parameters({"browserName"})
    @BeforeClass
    public void setup(String browserName, ITestContext iTestContext){
        this.setDriverToContext(iTestContext,driver);
        switch (browserName){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver","src\\test\\resources\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                System.setProperty("webdriver.edge.driver","src\\test\\resources\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            case "OPERA":
                System.setProperty("webdriver.opera.driver","src\\test\\resources\\drivers\\operadriver.exe");
                driver = new OperaDriver();
                break;
            default:
                System.out.println("Browser not supported");

        }
        wait = new WebDriverWait(driver,TIMEOUT);
        driver.manage().window().maximize();

        //logs
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        //call constructor from class
        brokersPage = new BrokersPage(driver,wait);
    }

    private void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }
}
