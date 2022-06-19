package com.tivix.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    // Singleton design pattern for WebDriver - creates single instance of a WebDriver and unique ID session
    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver() {

    }
    /*
        We make WebDriver private, because we want to close access from outside the class.
        We make it static because we will use it in a static method.
         */
    //private static WebDriver driver; // value is null by default

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
   // private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {
        /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
        String browser = ConfigurationReader.getProperty("browser");
        if (driverPool.get() == null) {
            return getDriver(browser);
        }
        return driverPool.get();
    }

    public static WebDriver getDriver(String browserType) {

        if(driverPool.get()==null){
            setDriver(browserType);
        }


        return driverPool.get();
    }

    /*
    This method will make sure our driver value is always null after using quit() method
     */
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPool.remove();
        }
    }

    public static void setDriver(String browserType) {
        synchronized (Driver.class) {
            switch (browserType) {
            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
                case "chrome":
                    //testing insecure pages
                    /*
                    DesiredCapabilities dp = new DesiredCapabilities().chrome();
                    dp.acceptInsecureCerts();
                    dp.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
                    dp.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.merge(dp);
                    //for stable ENV use setting below
                     */
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set(new OperaDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }


        }


    }


}
