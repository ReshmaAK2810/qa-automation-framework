package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {
    private static WebDriver driver;
    protected static String browser;
    public static WebDriver getDriver(){
        if(driver==null){
            if(browser==null)
                browser="chrome";// default browser assignment
            initDriver(browser);
        }
        return driver;
    }

    public static void initDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        //For later use-multiple browser testing
//        switch (browserName.toLowerCase()){
//            case "chrome":
//                driver=new ChromeDriver();
//                break;
//             case "firefox":
//                 driver = new FirefoxDriver();
//                 break;
//             case "edge":
//                 driver = new EdgeDriver();
//                 break;
//            default:
//                System.out.println("Browser not supported. Launching Chrome as default.");
//                driver = new ChromeDriver();
//                break;
//        }

    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

    public static void setBrowser(String browserName){
        browser=browserName;
    }
}

